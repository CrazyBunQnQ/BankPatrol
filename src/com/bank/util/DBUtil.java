package com.bank.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBUtil {
	private static final Logger LOGGER = LogManager.getLogger(DBUtil.class.getName());
	private static String dbDriver;
	private static String dbUrl;
	private static String dbUser;
	private static String dbPwd;
	
	static {
		Properties properties = new Properties();
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
			dbDriver = properties.getProperty("driver");
			dbUrl = properties.getProperty("url");
			dbUser = properties.getProperty("user");
			dbPwd = properties.getProperty("pwd");
			Class.forName(dbDriver);
			LOGGER.info("数据库连接成功");
		} catch (IOException e) {
			LOGGER.error("数据库连接创建失败：I/O 流错误");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			LOGGER.error("数据库连接创建失败：找不到类");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		LOGGER.info("数据库连接创建成功");
		return conn;
	}
	
	public static void closeConnection(Connection conn, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
			LOGGER.info("数据库结果集关闭成功");
		}
		if (conn != null) {
			conn.close();
			LOGGER.info("数据库连接关闭成功");
		}
	}
	
	public static void closeConnection(Connection conn, ResultSet rs, Statement st) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void closeConnection(Connection conn, ResultSet rs, PreparedStatement ps) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
