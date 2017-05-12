package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 部门
 */
public class Department implements Serializable {

	private static final long serialVersionUID = -6932003951899301374L;
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;

	public Department() {

	}

	/**
	 * 部门构造器
	 * @param id 部门 id
	 * @param name 部门名称
	 */
	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id == null ? 0 : id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Department other = (Department) obj;
		if (id != other.id)
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
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
