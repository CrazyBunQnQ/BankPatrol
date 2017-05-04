package com.bank.entity;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

/**
 * 报修记录
 */
public class FaultRepair implements Serializable {

	private static final long serialVersionUID = 878184553280397995L;
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 巡检组
	 */
	private PiGroup piGroup;
	/**
	 * 设备
	 */
	private BankEquipment bankEquipment;
	/**
	 * 保修类型
	 */
	private RepairType repairType;
	/**
	 * 所属银行
	 */
	private Bank bank;
	/**
	 * 保修用户
	 */
	private User user;
	/**
	 * 保修开始时间
	 */
	private Date biginTime;
	/**
	 * 保修状态
	 */
	private int repairStatus;
	/**
	 * 分配状态
	 */
	private int allocateStatus;
	/**
	 * 保修结束时间
	 */
	private Date endTime;
	/**
	 * 评价
	 */
	private String evaluation;

	public FaultRepair() {

	}

	public FaultRepair(int id, PiGroup piGroup, BankEquipment bankEquipment, RepairType repairType, Bank bank,
			User user, Date biginTime, int repairStatus, int allocateStatus, Date endTime, String evaluation) {
		super();
		this.id = id;
		this.piGroup = piGroup;
		this.bankEquipment = bankEquipment;
		this.repairType = repairType;
		this.bank = bank;
		this.user = user;
		this.biginTime = biginTime;
		this.repairStatus = repairStatus;
		this.allocateStatus = allocateStatus;
		this.endTime = endTime;
		this.evaluation = evaluation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PiGroup getPiGroup() {
		return piGroup;
	}

	public void setPiGroup(PiGroup piGroup) {
		this.piGroup = piGroup;
	}

	public BankEquipment getBankEquipment() {
		return bankEquipment;
	}

	public void setBankEquipment(BankEquipment bankEquipment) {
		this.bankEquipment = bankEquipment;
	}

	public RepairType getRepairType() {
		return repairType;
	}

	public void setRepairType(RepairType repairType) {
		this.repairType = repairType;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getBiginTime() {
		return biginTime;
	}

	public void setBiginTime(Date biginTime) {
		this.biginTime = biginTime;
	}

	public int getRepairStatus() {
		return repairStatus;
	}

	public void setRepairStatus(int repairStatus) {
		this.repairStatus = repairStatus;
	}

	public int getAllocateStatus() {
		return allocateStatus;
	}

	public void setAllocateStatus(int allocateStatus) {
		this.allocateStatus = allocateStatus;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + allocateStatus;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((bankEquipment == null) ? 0 : bankEquipment.hashCode());
		result = prime * result + ((biginTime == null) ? 0 : biginTime.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((evaluation == null) ? 0 : evaluation.hashCode());
		result = prime * result + id;
		result = prime * result + ((piGroup == null) ? 0 : piGroup.hashCode());
		result = prime * result + repairStatus;
		result = prime * result + ((repairType == null) ? 0 : repairType.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		FaultRepair other = (FaultRepair) obj;
		if (allocateStatus != other.allocateStatus)
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (bankEquipment == null) {
			if (other.bankEquipment != null)
				return false;
		} else if (!bankEquipment.equals(other.bankEquipment))
			return false;
		if (biginTime == null) {
			if (other.biginTime != null)
				return false;
		} else if (!biginTime.equals(other.biginTime))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (evaluation == null) {
			if (other.evaluation != null)
				return false;
		} else if (!evaluation.equals(other.evaluation))
			return false;
		if (id != other.id)
			return false;
		if (piGroup == null) {
			if (other.piGroup != null)
				return false;
		} else if (!piGroup.equals(other.piGroup))
			return false;
		if (repairStatus != other.repairStatus)
			return false;
		if (repairType == null) {
			if (other.repairType != null)
				return false;
		} else if (!repairType.equals(other.repairType))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FaultRepair [id=" + id + ", piGroup=" + piGroup + ", bankEquipment=" + bankEquipment + ", repairType="
				+ repairType + ", equipmentType=" + ", bank=" + bank + ", user=" + user + ", biginTime=" + biginTime
				+ ", repairStatus=" + repairStatus + ", allocateStatus=" + allocateStatus + ", endTime=" + endTime
				+ ", evaluation=" + evaluation + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
