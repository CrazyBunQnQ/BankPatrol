package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 岗位
 */
public class Job implements Serializable {
	private static final long serialVersionUID = -5211387915337146201L;
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 岗位性质
	 * 
	 * 0：管理
	 * 
	 * 1：巡检组
	 */
	private Integer groupId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String description;

	public Job() {

	}

	/**
	 * 岗位
	 * @param id 编号
	 * @param groupId 岗位性质
	 * @param name 名称
	 * @param description 描述
	 */
	public Job(Integer id, Integer groupId, String name, String description) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
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
		Job other = (Job) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
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
		return "Job [id=" + id + ", groupId=" + groupId + ", name=" + name + ", description=" + description + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
