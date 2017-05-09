package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 功能（模块）
 */
public class Function implements Serializable {

	private static final long serialVersionUID = -5006456112253770155L;
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;

	public Function() {

	}

	/**
	 * 模块
	 * @param id 编号
	 * @param name 名称
	 */
	public Function(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Function other = (Function) obj;
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
		return "Function [id=" + id + ", name=" + name + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
