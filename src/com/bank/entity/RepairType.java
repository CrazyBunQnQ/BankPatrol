package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 保修类型
 */
public class RepairType implements Serializable {

	private static final long serialVersionUID = -7149513079046656859L;
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 名称
	 */
	private String value;

	public RepairType() {

	}

	public RepairType(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		RepairType other = (RepairType) obj;
		if (id != other.id)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FaultRepairType [id=" + id + ", value=" + value + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
