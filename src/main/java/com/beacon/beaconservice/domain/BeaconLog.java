package com.beacon.beaconservice.domain;

public class BeaconLog {
	String userId;
	String entryTime;
	String exitTime;
	Long id;
	String eventType;

	public BeaconLog(String userId, String entryTime, String exitTime, Long id, String eventType) {
		super();
		this.userId = userId;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.id = id;
		this.eventType = eventType;
	}

	public BeaconLog() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BeaconLog [userId=" + userId + ", entryTime=" + entryTime + ", exitTime=" + exitTime + ", id=" + id
				+ ", eventType=" + eventType + "]";
	}

}
