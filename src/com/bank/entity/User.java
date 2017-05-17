package com.bank.entity;

import java.io.Serializable;

import com.bank.util.MD5Util;
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
	
	/**
	 * 巡检工
	 */
	private PiWorker worker;
	
	long workerId;

	public long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}

	public User() {
		job = new Job();
		department = new Department();
		worker = new PiWorker();
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
	public User(String loginId, Job job, Department department, String loginPwd, String name, boolean status, PiWorker worker) {
		super();
		this.loginId = loginId;
		this.job = job;
		this.department = department;
		this.loginPwd = MD5Util.getMD5(loginPwd);
		this.name = name;
		this.status = status;
		this.worker = worker;
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
		this.loginPwd = MD5Util.getMD5(loginPwd);
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
	
	public PiWorker getWorker() {
		return worker;
	}

	public void setWorker(PiWorker worker) {
		this.worker = worker;
	}
	
	/**
	 * 获取用户的岗位 id
	 * @return
	 */
	public Integer getJobId() {
		return job.getId();
	}
	
	/**
	 * 设置用户的岗位 id
	 * @param jobId
	 */
	public void setJobId(Integer jobId) {
		this.job.setId(jobId == null ? 0 : jobId);
	}
	
	/**
	 * 获取用户的岗位名称
	 * @return
	 */
	public String getJobName() {
		return job.getName();
	}
	
	/**
	 * 设置用户的岗位名称
	 * @param jname
	 */
	public void setJobName(String jname) {
		this.job.setName(jname);
	}

	/**
	 * 获取用户所在部门的 id
	 * @return
	 */
	public Integer getDepartmentId() {
		return department.getId();
	}

	public void setDepartmentId(Integer did) {
		this.department.setId(did == null ? 0 : did);
	}
	
	/**
	 * 获取用户所在的部门名称
	 * @return
	 */
	public String getDepartmentName() {
		return department.getName();
	}
	
	/**
	 * 设置用户所在的部门名称
	 * @param dname
	 */
	public void setDepartmentName(String dname) {
		this.department.setName(dname);
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
		result = prime * result + ((worker == null) ? 0 : worker.hashCode());
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
		if (worker == null) {
			if (other.worker != null)
				return false;
		} else if (!worker.equals(other.worker))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", job=" + job + ", department=" + department + ", loginPwd=" + loginPwd + ", name=" + name + ", status=" + status + ", worker=" + worker + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
