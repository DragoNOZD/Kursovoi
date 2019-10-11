package org.tr.swapp.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource({"classpath:app.properties"})
@EnableSpringDataWebSupport
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.tr.swapp"})
public class DataBaseConfig {
    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";
    private static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("org.tr.swapp.**");
        //entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        final LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("org.tr.swapp");
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory/*SessionFactory sessionFactory*/) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        //transactionManager.setSessionFactory(sessionFactory);
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));

        return properties;
    }
}

// -/////////////////////////////////////////////////////////////////////////////////////////////-
// -/\,,,,,,,,,,,,,,,=======////=/.../}./.=\.\.\.\.".',__'____./.===\../../.(.'.>>>>> ....</././.-
// -/////////////////,===========================================================================,
// -\/'','''','''''''|010100100010110000.1001.10000.00100000000100000011.10100000100000001001.000|
// -\',,',,=='=======|001001000010100000000000010.0000000.000000.1010010011010.000101000000010111|
// ->-=////.<.[[ ./..|001.000.001100100000000010.000.010001000100000,-",-|00.00110001.0110001001/-
// -'^'."."".,/,/,/<.|001010001010.010000010000000100.11100.000,-",-"    |0100001.0.10101.011001|-
// -//./^:,.',\,\,\<.|00100.0010000011.1000.00000, - __001,-",-"         |0000000000100000100000|-
// ->//..............|111000101110001101000010,-",-"   "-,|  |    ,--"|  |011100100010000000.000|-
// -->//.............|0100001010.01.000,--" ,/  /    _    \  |   |10| |  |110.010001100100000110|-
// --->//............|00.0, - "" ,0011/",--'|  |   /0\ \   | |   |00| |  |1.001010.0.0000000001.|-
// ---->//...........|0101|'",--'|10./ /    |  |  |01.",|,"  |   |00| |  |100000.0000110.0000010|-
// ---->\\-----+>::::|0000|  |   |10/ /     |  |  |0000000|  |   |01| |  |1000000100001001100010|-
// --->\\============|0100|  |   |0/ /      |  |  |1101000|  |   |01| |  |00000000000000001.0000|-
// -...//<-----------|1.00|  |   |/ /       |  |  |010.000|  |   |10| |  |10.0110000000000101110|-
// -....//<==========|1000|  |   | /   /|   |  |  |0100,","| |   |10',|,-".00100000.0010000001.0|-
// --+>//>//.........|1011|  |   |/   / |   |  |  |000| |  | |   |1000000101000.0110111.00000001|-
// -+>\\=>//.........|0001|  |   /   /| |   |  |   \_/_/   /,|,-"010100001000000100001.011000000|-
// -"""//>//,,,,,,,,,|1001|  |      /0| |   |\  \        ,".1000000.0000000000000000010001.00000|-
// -:::\\<//:::::::::|.000|  |     /01| |   |1"-,"-,__,-"00011.0000001.1010000000100010001011000|-
// -...//>//.=>\.....|0000|  |    /00.',|,-"10.01010.1001000100100.000011.0011100000110001001.00|-
// -...\\<//......\..|0110|, |,--'00000110000001001100001.00100100001001001101.00111000000000011|-
// -...//>//..../....|001.00"00001.100010.0000010001000.100000011.0010010001010111100.0110000001|-
// -...\\<//.........|00001001100100010100101000011110001010110100000001000000001.1000101.001000|-
// -/<<//>//>>>>>>>>>|00101000.00100101100100100001000101011.0010001.100000110001000000010110001|-
// -.==\\<//========>'=========================================================================='-
// -=============================================================================================-
// -=============================================================================================-
// -/////////////////////////////////////////////////////////////////////////////////////////////-
