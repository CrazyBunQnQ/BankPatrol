package com.bank.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 岗位功能
 */
public class Gwym implements Serializable {

	private static final long serialVersionUID = -2744973970160908432L;
	/**
	 * 岗位
	 */
	private Job job;
	/**
	 * 功能
	 */
	private Xtymb xtymb;

	public Gwym() {

	}

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
