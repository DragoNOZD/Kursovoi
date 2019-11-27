package ru.mmo.database.hibernate.types.vector;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class VectorHibernateType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.OTHER };
    }

    @Override
    public Class returnedClass() {
        return Vector.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        if (o == null){
            return o1 == null;
        }
        return o.equals(o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        Vector v = (Vector) resultSet.getObject(strings[0]);
        return new Vector(v);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if(o == null) {
            preparedStatement.setNull(i, Types.OTHER);
        } else {
            Vector v = (Vector) o;
            preparedStatement.setObject(i, new Vector(v));
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        Vector v = (Vector) o;
        return new Vector(v);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable)this.deepCopy(o);
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return this.deepCopy(serializable);
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return this.deepCopy(o);
    }
}
