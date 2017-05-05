package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 用户
 */
public class User implements Serializable {

	private static final long serialVersionUID = -8888878211371330602L;
	/**
	 * 登录 ID
	 */
	private String loginId;
	/**
	 * 所属岗位
	 */
	private Job job;
	/**
	 * 所属部门
	 */
	private Department department;
	/**
	 * 登录密码
	 */
	private String loginPwd;
	/**
	 * 真实姓名
	 */
	private String name;
	/**
	 * 用户状态
	 * 
	 * true：启用
	 * 
	 * false：禁用
	 */
	private boolean status;

	public User() {

	}

	/**
	 * 用户
	 * @param loginId 用户名（登录id）
	 * @param job 岗位
	 * @param department 所属部门
	 * @param loginPwd 登录密码
	 * @param name 真实姓名
	 * @param status 是否启用
	 */
	public User(String loginId, Job job, Department department, String loginPwd, String name, boolean status) {
		super();
		this.loginId = loginId;
		this.job = job;
		this.department = department;
		this.loginPwd = loginPwd;
		this.name = name;
		this.status = status;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((loginPwd == null) ? 0 : loginPwd.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		User other = (User) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (loginPwd == null) {
			if (other.loginPwd != null)
				return false;
		} else if (!loginPwd.equals(other.loginPwd))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", job=" + job + ", department=" + department + ", loginPwd=" + loginPwd
				+ ", name=" + name + ", status=" + status + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
