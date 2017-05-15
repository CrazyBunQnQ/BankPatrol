package com.bank.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBUtil {
	private static final Logger LOGGER = LogManager.getLogger(DBUtil.class.getName());
	/**
	 * 数据库驱动
	 */
	private static String dbDriver;
	/**
	 * 数据库地址
	 */
	private static String dbUrl;
	/**
	 * 数据库用户名
	 */
	private static String dbUser;
	/**
	 * 数据库用户密码
	 */
	private static String dbPwd;
	
	static {
		Properties properties = new Properties();
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			dbDriver = properties.getProperty("driver");
			dbUrl = properties.getProperty("url");
			dbUser = properties.getProperty("user");
			dbPwd = properties.getProperty("pwd");
			Class.forName(dbDriver);
		} catch (IOException e) {
			LOGGER.error("数据库连接创建失败：I/O 流错误");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			LOGGER.error("数据库连接创建失败：找不到类");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn 要关闭的数据库连接
	 * @param rs 要关闭的数据集
	 * @param ps 要关闭的 PreparedStatement 数据库语句
	 * @throws SQLException
	 */
	public static void closeConnection(Connection conn, ResultSet rs, PreparedStatement ps) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
