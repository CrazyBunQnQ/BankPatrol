package com.bank.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bank.dao.LogDao;
import com.bank.dao.impl.LogDaoImpl;
import com.bank.entity.Log;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportLogUtil {

	/**
	 * 导出日志方法
	 * @return
	 */
	public static boolean exportLogs(){
		LogDao logd = new LogDaoImpl();
		boolean flag = false;
		//表头
		String logId = "日志编号";
		String checkin_time = "登录时间";
		String checkout_time = "退出时间";
		String users_id = "用户id";
		//获取数据库中所有日志信息
		List<Log> logs = logd.getAllLogs();
		//创建file对象，指定文件导出路径为f:/log.xls
		File file = new File("f:/log.xls");	
		try {
			//创建工作簿
			WritableWorkbook wwb = Workbook.createWorkbook(file);
			//创建工作表，表明为log sheet
			WritableSheet ws = wwb.createSheet("log sheet", 0);
			//创建表头，设置表头位置
			Label labelLogId = new Label(0,0,logId);//0列 0行
			Label labelCheckInTime = new Label(1,0,checkin_time);
			Label labelCheckOutTime = new Label(2,0,checkout_time);
			Label labelUserId = new Label(3,0,users_id);
			//添加表头
			ws.addCell(labelLogId);
			ws.addCell(labelCheckInTime);
			ws.addCell(labelCheckOutTime);
			ws.addCell(labelUserId);
			//将数据库数据放入工作表
			for(int i = 0, size = logs.size(); i < size; i++){
				Label labelLogId_i = new Label(0,i+1,logs.get(i).getId()+"");//0列 0行
				Label labelCheckInTime_i = new Label(1,i+1,logs.get(i).getCheckIn());
				Label labelCheckOutTime_i = new Label(2,i+1,logs.get(i).getCheckOut());
				Label labelUserId_i = new Label(3,i+1,logs.get(i).getUseername());
				ws.addCell(labelLogId_i);
				ws.addCell(labelCheckInTime_i);
				ws.addCell(labelCheckOutTime_i);
				ws.addCell(labelUserId_i);
			}
			//将信息写入工作簿
			wwb.write();
			//关流
			wwb.close();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//测试
	public static void main(String[] args) {
		ExportLogUtil.exportLogs();
	}
}
