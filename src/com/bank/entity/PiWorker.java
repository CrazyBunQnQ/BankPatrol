package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 巡检工
 */
public class PiWorker implements Serializable {

	private static final long serialVersionUID = 6230672284723909414L;
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 所属巡检组
	 */
	private PiGroup piGroup;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 电话1
	 */
	private String tel1;
	/**
	 * 电话2
	 */
	private String tel2;

	public PiWorker() {

	}

	public PiWorker(int id, PiGroup piGroup, String name, String tel1, String tel2) {
		super();
		this.id = id;
		this.piGroup = piGroup;
		this.name = name;
		this.tel1 = tel1;
		this.tel2 = tel2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PiGroup getPiGroup() {
		return piGroup;
	}

	public void setPiGroup(PiGroup piGroup) {
		this.piGroup = piGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((piGroup == null) ? 0 : piGroup.hashCode());
		result = prime * result + ((tel1 == null) ? 0 : tel1.hashCode());
		result = prime * result + ((tel2 == null) ? 0 : tel2.hashCode());
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
		PiWorker other = (PiWorker) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (piGroup == null) {
			if (other.piGroup != null)
				return false;
		} else if (!piGroup.equals(other.piGroup))
			return false;
		if (tel1 == null) {
			if (other.tel1 != null)
				return false;
		} else if (!tel1.equals(other.tel1))
			return false;
		if (tel2 == null) {
			if (other.tel2 != null)
				return false;
		} else if (!tel2.equals(other.tel2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PiWorker [id=" + id + ", piGroup=" + piGroup + ", name=" + name + ", tel1=" + tel1 + ", tel2=" + tel2
				+ "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
