package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 银行
 */
public class Bank implements Serializable {

	private static final long serialVersionUID = -2578803055874032523L;
	/**
	 * 银行编号
	 */
	private int id;
	/**
	 * 银行名称
	 */
	private String name;
	/**
	 * 经度
	 */
	private double longitude;
	/**
	 * 维度
	 */
	private double latitude;
	/**
	 * 银行 IP 地址
	 */
	private String ip;

	public Bank() {

	}

	public Bank(int id, String name, double longitude, double latitude, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Bank other = (Bank) obj;
		if (id != other.id)
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", longitude=" + longitude + ", latitude=" + latitude + ", ip="
				+ ip + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
