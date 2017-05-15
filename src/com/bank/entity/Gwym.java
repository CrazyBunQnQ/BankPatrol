package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 岗位权限
 */
public class Gwym implements Serializable {

	private static final long serialVersionUID = -2744973970160908432L;
	/**
	 * 岗位
	 */
	private Job job;
	/**
	 * 岗位的权限
	 */
	private Xtymb xtymb;

	public Gwym() {
		job = new Job();
		xtymb = new Xtymb();
	}

	/**
	 * 岗位权限
	 * @param job 岗位
	 * @param xtymb 权限
	 */
	public Gwym(Job job, Xtymb xtymb) {
		super();
		this.job = job;
		this.xtymb = xtymb;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Xtymb getXtymb() {
		return xtymb;
	}

	public void setXtymb(Xtymb xtymb) {
		this.xtymb = xtymb;
	}
	
	public String getStatus() {
		return xtymb.isStatus() ? "checked" : "";
	}
	
	public void setStatus(boolean status) {
		this.xtymb.setStatus(status);
	}

	/**
	 * 获取子功能 id
	 * @return
	 */
	public Integer getXtymbId() {
		return xtymb.getId();
	}
	
	/**
	 * 设置子功能 id
	 * @param xtymbId
	 */
	public void setXtymbId(Integer xtymbId) {
		this.xtymb.setId(xtymbId);
	}
	
	/**
	 * 获取子功能名称
	 * @return
	 */
	public String getXtymbName() {
		return xtymb.getName();
	}
	
	/**
	 * 设置子功能名称
	 * @param xtymbName
	 */
	public void setXtymbName(String xtymbName) {
		this.xtymb.setName(xtymbName);
	}
	
	/**
	 * 获取模块 id
	 * @return
	 */
	public Integer getFunId() {
		return xtymb.getFunction().getId();
	}
	
	/**
	 * 设置模块 id
	 * @param funId 子功能 id
	 */
	public void setFunId(Integer funId) {
		this.xtymb.getFunction().setId(funId == null ? 0 : funId);
	}
	
	/**
	 * 获取模块名称
	 * @return
	 */
	public String getFunName() {
		return xtymb.getFunction().getName();
	}
	
	/**
	 * 设置模块名称
	 * @param fName
	 */
	public void setFunName(String fName) {
		this.xtymb.getFunction().setName(fName);
	}
	
	/**
	 * 获取岗位 id
	 * @return
	 */
	public Integer getJobId() {
		return job.getId();
	}
	
	/**
	 * 设置岗位 id
	 * @param jobId
	 */
	public void setJobId(Integer jobId) {
		this.job.setId(jobId == null ? 0 : jobId);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((xtymb == null) ? 0 : xtymb.hashCode());
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
		Gwym other = (Gwym) obj;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (xtymb == null) {
			if (other.xtymb != null)
				return false;
		} else if (!xtymb.equals(other.xtymb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gwym [job=" + job + ", xtymb=" + xtymb + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
