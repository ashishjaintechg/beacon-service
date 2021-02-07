package com.beacon.beaconservice.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beacon.beaconservice.dao.BeaconLogDao;
import com.beacon.beaconservice.domain.BeaconLog;


@Service
public class BeaconLogServiceImpl implements BeaconLogService {

    @Autowired
    private BeaconLogDao dao;

	@Override
	public Long createBeaconLog(BeaconLog BeaconLog) throws SQLException{
		return dao.createBeaconLog(BeaconLog);
	}
	@Override
	public  BeaconLog readBeaconLog(Long BeaconLogId) throws SQLException{
		  return dao.readBeaconLog(BeaconLogId);
	  }
	@Override
	public void updateBeaconLog(BeaconLog BeaconLog) throws SQLException{
		  dao.update(BeaconLog);
	  }
	@Override
	public  void deleteBeaconLog(Long BeaconLogId) throws SQLException{
		  dao.deleteBeaconLog(BeaconLogId);
	  }
	
	@Override
	public List<BeaconLog> readBeaconLogByUserId(Long userId) throws SQLException {
				List<BeaconLog> resultLogList = null;
				List<BeaconLog> logList = dao.readBeaconLogByUserId(userId);
				if(logList == null || logList.isEmpty())
					return logList;
				
				resultLogList = getCurrentDateBeaconLogsForUser(logList);
				if(resultLogList == null || resultLogList.isEmpty())
					return resultLogList;
				for(BeaconLog beaconLog : resultLogList)
				{
					System.out.println(" beaconLog : "+beaconLog.getId());
				}
		  return resultLogList;
	  }
	
	
	
	private List<BeaconLog> getCurrentDateBeaconLogsForUser(List<BeaconLog> logList) {
		DateFormat date1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date currDate = new Date();
		currDate= getZeroTimeDate(currDate);
		List<BeaconLog> resultLogList =new ArrayList<>();
		for(BeaconLog beaconLog : logList)
		{
			System.out.println("Date " +beaconLog.getEntryTime());
			if(beaconLog.getEntryTime()!=null)
			{
				try {
					Date d1 = date1.parse(beaconLog.getEntryTime());
					Date zeroTimeDate = getZeroTimeDate(d1);
					if(currDate.compareTo(zeroTimeDate)==0)
						resultLogList.add(beaconLog);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultLogList;
	}
	
	private Date getZeroTimeDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}
	
	

}
