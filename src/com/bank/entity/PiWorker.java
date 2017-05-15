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
	private Long id;
	/**
	 * 所属巡检组
	 */
	private PiGroup piGroup;
	/**
	 * 电话1
	 */
	private String tel1;
	/**
	 * 电话2
	 */
	private String tel2;
	
	private String workerName;

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public PiWorker() {
		piGroup = new PiGroup();
	}

	/**
	 * 巡检工
	 * @param id 编号
	 * @param piGroup 所属巡检组
	 * @param tel1 电话1
	 * @param tel2 电话2
	 */
	public PiWorker(Long id, PiGroup piGroup, String tel1, String tel2) {
		super();
		this.id = id;
		this.piGroup = piGroup;
		this.tel1 = tel1;
		this.tel2 = tel2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PiGroup getPiGroup() {
		return piGroup;
	}

	public void setPiGroup(PiGroup piGroup) {
		this.piGroup = piGroup;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "PiWorker [id=" + id + ", piGroup=" + piGroup + ", tel1=" + tel1 + ", tel2=" + tel2 + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
