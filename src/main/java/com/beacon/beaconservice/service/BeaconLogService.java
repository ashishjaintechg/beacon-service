package com.beacon.beaconservice.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beacon.beaconservice.domain.BeaconLog;

@Service
public interface BeaconLogService {

	Long createBeaconLog(BeaconLog BeaconLog) throws SQLException;

	BeaconLog readBeaconLog(Long BeaconLogId) throws SQLException;

	void updateBeaconLog(BeaconLog BeaconLog) throws SQLException;

	void deleteBeaconLog(Long BeaconLogId) throws SQLException;

	List<BeaconLog> readBeaconLogByUserId(Long userId) throws SQLException;

}
