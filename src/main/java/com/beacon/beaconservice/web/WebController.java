package com.beacon.beaconservice.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beacon.beaconservice.domain.BeaconLog;
import com.beacon.beaconservice.service.BeaconLogService;

@RestController
public class WebController {

	@Autowired
	ServletContext context;

	@Autowired
	BeaconLogService service;

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	
	@RequestMapping(value = "/beaconLog/{id}", method = RequestMethod.GET)
	public BeaconLog getBeaconLogById(@PathVariable Long id) throws Exception {
		System.out.println(dtf.format(now) +":"+this.getClass().getSimpleName() + " - Get BeaconLog details by id is invoked.");
		BeaconLog BeaconLog = service.readBeaconLog(id);
		if (BeaconLog == null)
			throw new Exception("Could not find BeaconLog with id- " + id);
		return BeaconLog;
	}

	@RequestMapping(value = "/beaconLog/user/{userId}", method = RequestMethod.GET)
	public List<BeaconLog> getBeaconLogByUserId(@PathVariable Long userId) throws Exception {
		System.out.println(dtf.format(now) +":"+this.getClass().getSimpleName() + " - Get BeaconLog details by userId is invoked.");
		List<BeaconLog> beaconLogList = service.readBeaconLogByUserId(userId);
		if (beaconLogList == null || beaconLogList.isEmpty())
			throw new Exception("Could not find BeaconLogs with user id- " + userId);
		return beaconLogList;
	}

	@RequestMapping(value = "/beaconLog/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public BeaconLog createBeaconLog(@RequestBody BeaconLog beaconLogParam) {
		BeaconLog beaconLogResult = null;
		try {

			System.out.println(dtf.format(now) +":"+this.getClass().getSimpleName() + " - Create new BeaconLog method is invoked for type "
					+ beaconLogParam.getEventType() + " : " + beaconLogParam.getId());
			System.out.println("Received object : " + beaconLogParam);
			if (beaconLogParam.getEventType().equals("ENTRY")) {
				Long BeaconLogId = service.createBeaconLog(beaconLogParam);
				beaconLogParam.setId(BeaconLogId);
				beaconLogResult = beaconLogParam;
			} else {
				Long BeaconLogId = beaconLogParam.getId();
				beaconLogResult = service.readBeaconLog(BeaconLogId);
				if (beaconLogResult == null)
					throw new Exception("Could not find BeaconLog with id- " + beaconLogResult);
				beaconLogResult.setExitTime(beaconLogParam.getExitTime());
				beaconLogResult.setEventType(beaconLogParam.getEventType());
				service.updateBeaconLog(beaconLogResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beaconLogResult;
	}

	@RequestMapping(value = "/beaconLog/update/{id}", method = RequestMethod.PUT)
	public BeaconLog updateBeaconLog(@RequestBody BeaconLog updBeaconLog, @PathVariable Long id) throws Exception {
		System.out.println(dtf.format(now) +":"+this.getClass().getSimpleName() + " - Update BeaconLog details by id is invoked.");

		BeaconLog BeaconLog = service.readBeaconLog(id);
		if (BeaconLog == null)
			throw new Exception("Could not find BeaconLog with id- " + id);

		updBeaconLog.setId(id);
		service.updateBeaconLog(updBeaconLog);
		return updBeaconLog;
	}

	@RequestMapping(value = "/beaconLog/delete/{id}", method = RequestMethod.DELETE)
	public void deleteBeaconLogById(@PathVariable Long id) throws Exception {
		System.out.println(dtf.format(now) +":"+this.getClass().getSimpleName() + " - Delete BeaconLog by id is invoked.");

		BeaconLog BeaconLog = service.readBeaconLog(id);
		if (BeaconLog == null)
			throw new Exception("Could not find BeaconLog with id- " + id);
		service.deleteBeaconLog(id);
	}

}
