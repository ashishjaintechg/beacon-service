package com.beacon.beaconservice.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.beacon.beaconservice.domain.BeaconLog;
import com.db.cloud.dao.CloudDatastoreDAO;

@Repository
public interface BeaconLogDao extends CloudDatastoreDAO<BeaconLog> {
	Long createBeaconLog(BeaconLog beaconLog) throws SQLException;

	BeaconLog readBeaconLog(Long id) throws SQLException;

	void updateBeaconLog(BeaconLog beaconLog) throws SQLException;

	void deleteBeaconLog(Long id) throws SQLException;

	List<BeaconLog> readBeaconLogByUserId(Long userId) throws SQLException;
}
