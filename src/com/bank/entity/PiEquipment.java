package com.bank.entity;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

/**
 * 巡检记录
 */
public class PiEquipment implements Serializable {

	private static final long serialVersionUID = -2449556704981930693L;
	/**
	 * 编号
	 */
	private Long id;
	/**
	 * 登录用户
	 */
	private User user;
	/**
	 * 银行
	 */
	private Bank bank;
	/**
	 * 巡检组
	 */
	private PiGroup piGroup;
	/**
	 * 保修类型
	 */
	private RepairType repairType;
	/**
	 * 设备
	 */
	private BankEquipment bankEquipment;
	/**
	 * 巡检时间
	 */
	private Date piDate;
	/**
	 * 评价
	 */
	private String evaluation;
	/**
	 * 设备状态
	 * 
	 * true：正常
	 * 
	 * false：故障
	 */
	private boolean piStatus;
	/**
	 * 是否确认
	 * 
	 * true：确认
	 * 
	 * false：未确认
	 */
	private boolean status;

	public PiEquipment() {

	}

	/**
	 * 巡检记录
	 * @param id 记录编号
	 * @param user 登录用户
	 * @param bank 银行
	 * @param piGroup 巡检组
	 * @param repairType 报修类型
	 * @param bankEquipment 报修设备
	 * @param piDate 巡检时间
	 * @param evaluation 评价
	 * @param piStatus 设备状态
	 * @param status 是否确认
	 */
	public PiEquipment(Long id, User user, Bank bank, PiGroup piGroup, RepairType repairType,
			BankEquipment bankEquipment, Date piDate, String evaluation, boolean piStatus, boolean status) {
		super();
		this.id = id;
		this.user = user;
		this.bank = bank;
		this.piGroup = piGroup;
		this.repairType = repairType;
		this.bankEquipment = bankEquipment;
		this.piDate = piDate;
		this.evaluation = evaluation;
		this.piStatus = piStatus;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public PiGroup getPiGroup() {
		return piGroup;
	}

	public void setPiGroup(PiGroup piGroup) {
		this.piGroup = piGroup;
	}

	public RepairType getRepairType() {
		return repairType;
	}

	public void setRepairType(RepairType repairType) {
		this.repairType = repairType;
	}

	public BankEquipment getBankEquipment() {
		return bankEquipment;
	}

	public void setBankEquipment(BankEquipment bankEquipment) {
		this.bankEquipment = bankEquipment;
	}

	public Date getPiDate() {
		return piDate;
	}

	public void setPiDate(Date piDate) {
		this.piDate = piDate;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public boolean isPiStatus() {
		return piStatus;
	}

	public void setPiStatus(boolean piStatus) {
		this.piStatus = piStatus;
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
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((bankEquipment == null) ? 0 : bankEquipment.hashCode());
		result = prime * result + ((evaluation == null) ? 0 : evaluation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((piDate == null) ? 0 : piDate.hashCode());
		result = prime * result + ((piGroup == null) ? 0 : piGroup.hashCode());
		result = prime * result + (piStatus ? 1231 : 1237);
		result = prime * result + ((repairType == null) ? 0 : repairType.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		PiEquipment other = (PiEquipment) obj;
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
		if (evaluation == null) {
			if (other.evaluation != null)
				return false;
		} else if (!evaluation.equals(other.evaluation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (piDate == null) {
			if (other.piDate != null)
				return false;
		} else if (!piDate.equals(other.piDate))
			return false;
		if (piGroup == null) {
			if (other.piGroup != null)
				return false;
		} else if (!piGroup.equals(other.piGroup))
			return false;
		if (piStatus != other.piStatus)
			return false;
		if (repairType == null) {
			if (other.repairType != null)
				return false;
		} else if (!repairType.equals(other.repairType))
			return false;
		if (status != other.status)
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
		return "PiEquipment [id=" + id + ", user=" + user + ", bank=" + bank + ", piGroup=" + piGroup + ", repairType="
				+ repairType + ", bankEquipment=" + bankEquipment + ", piDate=" + piDate + ", evaluation=" + evaluation
				+ ", piStatus=" + piStatus + ", status=" + status + "]";
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}
