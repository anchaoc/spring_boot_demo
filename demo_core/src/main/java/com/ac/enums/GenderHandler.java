package com.ac.enums;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis 枚举转换处理
 */
public class GenderHandler extends BaseTypeHandler<BookTypeEnum> {

    private Class<BookTypeEnum> type;

    private final BookTypeEnum[] enums;

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     * @param type 配置文件中设置的转换类
     */
    public GenderHandler(Class<BookTypeEnum> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
    }

    @Override
    public BookTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
        String str = rs.getString(columnName);
        //int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位EnumStatus子类
            return locateGender(str);
        }
    }

    @Override
    public BookTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位EnumStatus子类
            return locateGender(i);
        }
    }

    @Override
    public BookTypeEnum getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位EnumStatus子类
            return locateGender(i);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BookTypeEnum parameter,
                                    JdbcType arg3) throws SQLException {
        ps.setInt(i, parameter.getCode());

    }

    /**
     * 枚举类型转换，由于构造函数获取了枚举的子类enums，让遍历更加高效快捷
     * @param name 数据库中存储的自定义code属性
     * @return code对应的枚举类
     */
    private BookTypeEnum locateGender(String name) {
        System.out.println("-----"+name);
        BookTypeEnum bookTypeEnum = BookTypeEnum.getEnum(name);
        System.out.println("-----"+bookTypeEnum);
        return bookTypeEnum;
//        for(BookTypeEnum gender : enums) {
//            if(gender.getCode().equals(Integer.valueOf(code))) {
//                return gender;
//            }
//        }
        //throw new IllegalArgumentException("未知的枚举类型：" + name + ",请核对" + type.getSimpleName());
    }

    /**
     * 枚举类型转换，由于构造函数获取了枚举的子类enums，让遍历更加高效快捷
     * @param code 数据库中存储的自定义code属性
     * @return code对应的枚举类
     */
    private BookTypeEnum locateGender(int code) {
        for(BookTypeEnum gender : enums) {
            if(gender.getCode().equals(Integer.valueOf(code))) {
                return gender;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + type.getSimpleName());
    }

}