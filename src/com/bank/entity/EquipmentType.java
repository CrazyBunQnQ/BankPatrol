package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 设备种类
 */
public class EquipmentType implements Serializable {

	private static final long serialVersionUID = 7460796068852604552L;
	/**
	 * 种类 ID
	 */
	private String id;
	/**
	 * 种类名称
	 */
	private String name;
	/**
	 * 是否已存在该种类的设备
	 */
	private boolean hasEq;

	public EquipmentType() {

	}
	
	/**
	 * 设备种类(默认该种类不包含设备)
	 * @param id 种类
	 * @param name 名称
	 */
	public EquipmentType(String id, String name) {
		this(id, name, false);
	}

	/**
	 * 设备种类
	 * @param id 种类编号
	 * @param name 种类名称
	 * @param hasEq 是否存在该种类的设备
	 */
	public EquipmentType(String id, String name, boolean hasEq) {
		super();
		this.id = id;
		this.name = name;
		this.hasEq = hasEq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isHasEq() {
		return hasEq;
	}

	public void setHasEq(boolean hasEq) {
		this.hasEq = hasEq;
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
		EquipmentType other = (EquipmentType) obj;
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
		return "EquipmentType [id=" + id + ", name=" + name + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
