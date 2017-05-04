package com.bank.entity;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

/**
 * 银行设备
 */
public class BankEquipment implements Serializable {

	private static final long serialVersionUID = -9005658084919205189L;
	/**
	 * 流水 ID
	 */
	private int eachID;
	/**
	 * 种类
	 */
	private EquipmentType type;
	/**
	 * 所属银行
	 */
	private Bank bank;
	/**
	 * 购买价格
	 */
	private double value;
	/**
	 * 购买时间
	 */
	private Date buyDate;
	/**
	 * 状态
	 */
	private int status;
	/**
	 * 折旧残值
	 */
	private double depreciationValue;

	public BankEquipment() {

	}

	public BankEquipment(int eachID, EquipmentType type, Bank bank, double value, Date buyDate, int status,
			double depreciationValue) {
		super();
		this.eachID = eachID;
		this.type = type;
		this.bank = bank;
		this.value = value;
		this.buyDate = buyDate;
		this.status = status;
		this.depreciationValue = depreciationValue;
	}

	public int getEachID() {
		return eachID;
	}

	public void setEachID(int eachID) {
		this.eachID = eachID;
	}

	public EquipmentType getType() {
		return type;
	}

	public void setType(EquipmentType type) {
		this.type = type;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getDepreciationValue() {
		return depreciationValue;
	}

	public void setDepreciationValue(double depreciationValue) {
		this.depreciationValue = depreciationValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((buyDate == null) ? 0 : buyDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(depreciationValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eachID;
		result = prime * result + status;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BankEquipment other = (BankEquipment) obj;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (buyDate == null) {
			if (other.buyDate != null)
				return false;
		} else if (!buyDate.equals(other.buyDate))
			return false;
		if (Double.doubleToLongBits(depreciationValue) != Double.doubleToLongBits(other.depreciationValue))
			return false;
		if (eachID != other.eachID)
			return false;
		if (status != other.status)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankEquipment [eachID=" + eachID + ", type=" + type + ", bank=" + bank + ", value=" + value
				+ ", buyDate=" + buyDate + ", status=" + status + ", depreciationValue=" + depreciationValue + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
