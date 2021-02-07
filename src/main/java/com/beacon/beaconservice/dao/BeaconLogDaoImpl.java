package com.beacon.beaconservice.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.beacon.beaconservice.domain.BeaconLog;
import com.db.cloud.dao.CloudDatastoreDAOImpl;


@Repository
public class BeaconLogDaoImpl extends CloudDatastoreDAOImpl<BeaconLog> implements BeaconLogDao {

	protected BeaconLogDaoImpl() {
		super(BeaconLog.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Long createBeaconLog(BeaconLog beaconLog) throws SQLException{
		return add(beaconLog);
	}
	@Override
	public  BeaconLog readBeaconLog(Long id) throws SQLException{
		  return findById(id);
	  }
	
	@Override
	public  List<BeaconLog> readBeaconLogByUserId(Long userId) throws SQLException{
		  return getByParam("userId", userId+"");
	  }
	
	@Override
	public void updateBeaconLog(BeaconLog beaconLog) throws SQLException{
		  update(beaconLog);
	  }
	@Override
	public  void deleteBeaconLog(Long id) throws SQLException{
		  delete(id);
	  }


}
