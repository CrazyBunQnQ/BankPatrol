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
			LOGGER.info("数据库连接成功");
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
		LOGGER.info("数据库连接创建成功");
		return conn;
	}
	
	/**
	 * 执行 DML 语句（INSERT, UPDATE 或 DELETE）
	 * @param ps PreparedStatement 数据库语句
	 * @return int 影响行数
	 * @throws SQLException
	 */
	@Deprecated
	public static int closeStatement(PreparedStatement ps) throws SQLException {
		int num = ps.executeUpdate();
		ps.close();
		return num;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn 要关闭的连接
	 * @param rs 要关闭的数据集
	 * @throws SQLException
	 */
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
	
	/**
	 * 关闭数据库连接
	 * @param conn 要关闭的连接
	 * @param rs 要关闭的数据集
	 * @param st 要关闭的 Statement 数据库语句
	 * @throws SQLException
	 */
	@Deprecated
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
