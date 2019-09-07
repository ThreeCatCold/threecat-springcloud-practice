package com.threecat.springboot.sso.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrepareStatementTest
{
	public static void main(String[] args) throws Exception
	{
		Connection conn = null;
		PreparedStatement ps = conn.prepareStatement("");
		ps.addBatch();
	}
}
