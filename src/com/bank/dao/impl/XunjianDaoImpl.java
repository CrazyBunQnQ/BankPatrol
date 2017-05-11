package com.bank.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank.dao.XunjianDao;
import com.bank.entity.PiEquipment;
import com.bank.util.DBUtil;

public class XunjianDaoImpl extends BaseDaoImpl implements XunjianDao {

	@Override
	//设置巡检信息添加
	public boolean addXunjian(PiEquipment piEquipment) {
		boolean flag = false;
		try{
			String sql = "insert into piequipmenttable (id, login_id, bank_id, group_id, equipment_id, pitype_id, EquipmentEach_ID, PI_Date, PI_Evaluation, PI_Status) values(?,?,?,?,?,?,?,?,?,?)";	
			setConnAndPS(sql);
			/**
			 * 赋值:
			 * Login_ID	用户登录帐号(外键，关联表users)
			 * Bank_id	银行ID（外键，关联表bank）
			 * Group_id	巡检组id(外键，关联表pi_group)
			 * Equipment_id	设备种类id(外键，关联表equipmenttype)
			 * PITYPE_Id	类型id(编号)(外键，关联表fault_repair_type)
			 * EquipmentEach_ID	设备流水ID(外键，关联表bank_equipment)
			 * PI_Date	巡检时间 
			 * PI_Evaluation	评价,描述
			 * PI_Status	状态,设备状态（0为故障，1为正常）
			 * Status	是否确认，0为未确认，1为确认
			 */
			//给占位符赋值
			ps.setLong(1, piEquipment.getId());
			ps.setString(2, piEquipment.getUser().getLoginId());
			ps.setString(3, piEquipment.getBank().getId());
			ps.setLong(4, piEquipment.getPiGroup().getId());
			ps.setString(5, piEquipment.getBankEquipment().getType().getId());
			ps.setInt(6, piEquipment.getRepairType().getId());
			ps.setString(7, piEquipment.getBankEquipment().getEachID());
			ps.setDate(8, new java.sql.Date(piEquipment.getPiDate().getTime()));
			ps.setString(9, piEquipment.getEvaluation());
			ps.setBoolean(10, piEquipment.isPiStatus());
			LOGGER.info("添加巡检信息：" + ps.toString());
			int a = ps.executeUpdate();
			if(a>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	@Override
	//根据id进行设备巡检信息删除（逻辑删除）
	public boolean deleteXunjian(int id) {
		boolean flag = false;
		try{
			String sql= "delete from piequipmenttable where id = ?";
			setConnAndPS(sql);
			//给占位符赋值
			ps.setInt(1, id);
			LOGGER.info("删除巡检信息：" + ps.toString());
			int a = ps.executeUpdate();
			if(a>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	@Override
	//根据网点查询设备巡检信息
	public List<PiEquipment> queryByBankId(int bankId) {
		List<PiEquipment> piEquipments = new ArrayList<PiEquipment>();
		String sql = "select id, login_id, bank_id, group_id, equipment_id, pitype_id, EquipmentEach_ID, PI_Date, PI_Evaluation, PI_Status, Status from PiEquipment where bankId = ?"; 
		//给占位符赋值
		try {
			ps.setLong(1,bankId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return piEquipments;
	}

	@Override
	//根据巡检组查询设备巡检信息
	public List<PiEquipment> queryByGroupId(int groupId) {
		List<PiEquipment> piEquipments = new ArrayList<PiEquipment>();
		String sql = "select id, login_id, bank_id, group_id, equipment_id, pitype_id, EquipmentEach_ID, PI_Date, PI_Evaluation, PI_Status, Status from PiEquipment where groupId = ?"; 
		//给占位符赋值
		try {
			ps.setLong(1,groupId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return piEquipments;
	}

	@Override
	//根据巡检日期查询设备巡检信息
	public List<PiEquipment> queryByDate(Date date) {
		List<PiEquipment> piEquipments = new ArrayList<PiEquipment>();
		String sql = "select id, login_id, bank_id, group_id, equipment_id, pitype_id, EquipmentEach_ID, PI_Date, PI_Evaluation, PI_Status, Status from PiEquipment where date = ?"; 
		//给占位符赋值
		try {
			ps.setDate(1, new java.sql.Date(date.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return piEquipments;
	}

	@Override
	//根据巡检状态查询设备巡检信息
	public List<PiEquipment> queryByPIState(int piState) {
		List<PiEquipment> piEquipments = new ArrayList<PiEquipment>();
		String sql = "select id, login_id, bank_id, group_id, equipment_id, pitype_id, EquipmentEach_ID, PI_Date, PI_Evaluation, PI_Status, Status from PiEquipment where piState = ?"; 
		//给占位符赋值
		try {
			ps.setInt(1, piState);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return piEquipments;
	}

	@Override
	//根据设备状态查询设备巡检信息
	public List<PiEquipment> queryByEvaluateState(int evaluateState) {
		List<PiEquipment> piEquipments = new ArrayList<PiEquipment>();
		String sql = "select id, login_id, bank_id, group_id, equipment_id, pitype_id, EquipmentEach_ID, PI_Date, PI_Evaluation, PI_Status, Status from PiEquipment where evaluateState = ?"; 
		//给占位符赋值
		try {
			ps.setInt(1, evaluateState);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return piEquipments;
	}

	@Override
	//修改设备巡检信息
	public boolean updatePIEquipment(PiEquipment piEquipment) {
		boolean flag = false;
		try{
			String sql= "UPDATE piequipmenttable set (login_id, bank_id, group_id, equipment_id, pitype_id, EquipmentEach_ID, PI_Date, PI_Evaluation, PI_Status, Status) values(?,?,?,?,?,?,?,?,?,?) where id = ?";
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, piEquipment.getUser().getLoginId());
			ps.setString(2, piEquipment.getBank().getId());
			ps.setLong(3, piEquipment.getPiGroup().getId());
			ps.setString(4, piEquipment.getBankEquipment().getType().getId());
			ps.setInt(5, piEquipment.getRepairType().getId());
			ps.setString(6, piEquipment.getBankEquipment().getEachID());
			ps.setDate(7, new java.sql.Date(piEquipment.getPiDate().getTime()));
			ps.setString(8, piEquipment.getEvaluation());
			ps.setBoolean(9, piEquipment.isPiStatus());
			ps.setBoolean(10, piEquipment.isStatus());
			ps.setLong(11, piEquipment.getId());
			LOGGER.info("修改巡检信息：" + ps.toString());
			int a = ps.executeUpdate();
			if(a>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}
}
