package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 巡检组
 */
public class PiGroup implements Serializable {

	private static final long serialVersionUID = 8885826051423132938L;
	/**
	 * 编号
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;

	public PiGroup() {

	}

	/**
	 * 巡检组
	 * @param id 编号
	 * @param name 名称
	 */
	public PiGroup(Long id, String name) {
		super();
		this.id = id == null ? 0 : id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PiGroup other = (PiGroup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "PiGroup [id=" + id + ", name=" + name + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
