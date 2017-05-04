package com.bank.entity;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

/**
 * 设备维护记录
 */
public class EquipmentMaintain implements Serializable {

	private static final long serialVersionUID = -2743089298029948704L;
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 设备
	 */
	private BankEquipment bankEquipment;
	/**
	 * 维护日期
	 */
	private Date maintainDate;
	/**
	 * 维护结果
	 */
	private String result;

	public EquipmentMaintain() {

	}

	public EquipmentMaintain(int id, BankEquipment bankEquipment, Date maintainDate, String result) {
		super();
		this.id = id;
		this.bankEquipment = bankEquipment;
		this.maintainDate = maintainDate;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BankEquipment getBankEquipment() {
		return bankEquipment;
	}

	public void setBankEquipment(BankEquipment bankEquipment) {
		this.bankEquipment = bankEquipment;
	}

	public Date getMaintainDate() {
		return maintainDate;
	}

	public void setMaintainDate(Date maintainDate) {
		this.maintainDate = maintainDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankEquipment == null) ? 0 : bankEquipment.hashCode());
		result = prime * result + id;
		result = prime * result + ((maintainDate == null) ? 0 : maintainDate.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
		EquipmentMaintain other = (EquipmentMaintain) obj;
		if (bankEquipment == null) {
			if (other.bankEquipment != null)
				return false;
		} else if (!bankEquipment.equals(other.bankEquipment))
			return false;
		if (id != other.id)
			return false;
		if (maintainDate == null) {
			if (other.maintainDate != null)
				return false;
		} else if (!maintainDate.equals(other.maintainDate))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EquipmentMaintain [id=" + id + ", bankEquipment=" + bankEquipment + ", maintainDate=" + maintainDate
				+ ", result=" + result + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
