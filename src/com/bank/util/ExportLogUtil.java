package com.bank.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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

	
	public static boolean exportLog(){
		LogDao logd = new LogDaoImpl();
		boolean flag = false;
		String logId = "日志编号";
		String checkin_time = "登录时间";
		String checkout_time = "退出时间";
		String users_id = "用户id";
		List<Log> logs = logd.getAllLogs();
		File file = new File("f:/log.xls");	
		try {
			WritableWorkbook wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet("log sheet", 0);
			Label labelLogId = new Label(0,0,logId);//0列 0行
			Label labelCheckInTime = new Label(1,0,checkin_time);
			Label labelCheckOutTime = new Label(2,0,checkout_time);
			Label labelUserId = new Label(3,0,users_id);
			ws.addCell(labelLogId);
			ws.addCell(labelCheckInTime);
			ws.addCell(labelCheckOutTime);
			ws.addCell(labelUserId);
			for(int i = 0, size = logs.size(); i < size; i++){
				Label labelLogId_i = new Label(0,i+1,logs.get(i).getId()+"");//0列 0行
				Label labelCheckInTime_i = new Label(1,i+1,DateUtils.dateToStr(logs.get(i).getCheckIn()));
				Label labelCheckOutTime_i = new Label(2,i+1,DateUtils.dateToStr(logs.get(i).getCheckOut()));
				Label labelUserId_i = new Label(3,i+1,logs.get(i).getUseername());
				ws.addCell(labelLogId_i);
				ws.addCell(labelCheckInTime_i);
				ws.addCell(labelCheckOutTime_i);
				ws.addCell(labelUserId_i);
			}
			wwb.write();
			wwb.close();
			flag = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/*public static void main(String[] args) {
		ExportLogUtil.exportLog();
	}*/
}
