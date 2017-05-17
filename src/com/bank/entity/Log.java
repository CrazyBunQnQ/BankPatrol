package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 日志
 */
public class Log implements Serializable {

	private static final long serialVersionUID = 2463727512545435827L;
	/**
	 * 编号
	 */
	private Long id;
	/**
	 * 登录时间
	 */
	private String checkIn;
	/**
	 * 退出时间
	 */
	private String checkOut;
	/**
	 * 登录账号
	 */
	@Deprecated
	private User user;
	

	/**
	 * 登录账号
	 */
	private String useername;
	public String getUseername() {
		return useername;
	}

	public void setUseername(String useername) {
		this.useername = useername;
	}

	public Log() {
//		checkIn = new String();
//		checkOut = new String();
	}

	/**
	 * 日志
	 * @param id 编号
	 * @param checkIn 登录时间
	 * @param checkOut 退出时间
	 * @param user 登录用户
	 */
	public Log(Long id, String checkIn, String checkOut, User user) {
		super();
		this.id = id == null ? 0 : id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id == null ? 0 : id;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (checkIn == null) {
			if (other.checkIn != null)
				return false;
		} else if (!checkIn.equals(other.checkIn))
			return false;
		if (checkOut == null) {
			if (other.checkOut != null)
				return false;
		} else if (!checkOut.equals(other.checkOut))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", user=" + user + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
