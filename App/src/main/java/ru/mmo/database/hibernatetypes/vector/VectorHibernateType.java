package ru.mmo.database.hibernatetypes.vector;

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
        if (o == null || o1 == null){
            return false;
        }
        return o.equals(o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
//        Double x = (Double) DoubleType.INSTANCE.get(resultSet, strings[0], sharedSessionContractImplementor);
//        Double y = (Double)DoubleType.INSTANCE.get(resultSet, strings[1], sharedSessionContractImplementor);
//        Double z = (Double)DoubleType.INSTANCE.get(resultSet, strings[2], sharedSessionContractImplementor);
        Vector v = (Vector) resultSet.getObject(strings[0]);
        return new Vector(v);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if(o == null) {
//            DoubleType.INSTANCE.set(preparedStatement, null, i, sharedSessionContractImplementor);
//            DoubleType.INSTANCE.set(preparedStatement, null, i, sharedSessionContractImplementor);
//            DoubleType.INSTANCE.set(preparedStatement, null, i, sharedSessionContractImplementor);
            preparedStatement.setNull(i, Types.OTHER);
        } else {
            Vector v = (Vector) o;
//            DoubleType.INSTANCE.set(preparedStatement, v.x, i, sharedSessionContractImplementor);
//            DoubleType.INSTANCE.set(preparedStatement, v.y, i + 1, sharedSessionContractImplementor);
//            DoubleType.INSTANCE.set(preparedStatement, v.z, i + 2, sharedSessionContractImplementor);
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

//    @Override
//    public Serializable disassemble(Object o, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
//        return (Serializable)this.deepCopy(o);
//    }
//
//    @Override
//    public Object assemble(Serializable serializable, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
//        return this.deepCopy(serializable);
//    }
//
//    @Override
//    public Object replace(Object o, Object o1, SharedSessionContractImplementor sharedSessionContractImplementor, Object o2) throws HibernateException {
//        return this.deepCopy(o);
//    }
}
