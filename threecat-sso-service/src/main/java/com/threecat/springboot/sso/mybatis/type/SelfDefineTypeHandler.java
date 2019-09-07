package com.threecat.springboot.sso.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR) //指定与其关联的 Java 类型列表
public class SelfDefineTypeHandler extends BaseTypeHandler<String>
{
	@Override public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException
	{

	}

	@Override public String getNullableResult(ResultSet rs, String columnName) throws SQLException
	{
		return null;
	}

	@Override public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException
	{
		return null;
	}

	@Override public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException
	{
		return null;
	}
}
