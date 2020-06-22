package sve.core;

import sve.event.Listener;
import sve.event.EventManager;
import sve.event.EventType;

public class EcosystemTime {

	private int year, month, day, hour, minute, second;

	private double offsecond;

	private double secRelativity;

	public EcosystemTime(double dayRelativity) {
		this.year = this.day = this.hour = this.minute = this.second = 0;
		this.month = 0;
		this.offsecond = 0.0;
		this.secRelativity = computeRelativeSeconds(dayRelativity);
	}

	private EcosystemTime(EcosystemTime other) {
		this.year = other.year;
		this.month = other.month;
		this.day = other.day;
		this.hour = other.hour;
		this.minute = other.minute;
	}

	public void advanceRelatively(double deltaTime) {

		double passedTime = computeSeconds(deltaTime);
		int passedSeconds = (int) passedTime;
		offsecond += passedTime - passedSeconds;

		if(offsecond >= 1.0) {
			offsecond -= 1.0;
			passedSeconds += 1;
		}

		calculateNewTime(passedSeconds);
	}

	public void advanceRealTime(int seconds) {
		calculateNewTime(seconds);
	}

	@Override
	public String toString() {
		return second + "s:" + minute + "m:" + hour + "h:" + day + "d:" +
			month + "m:" + year + "y";
	}

	private void calculateNewTime(int passedSeconds) {

		EcosystemTime checkpoint = new EcosystemTime(this);

		minute += passedSeconds / 60;
		second = passedSeconds % 60;

		hour += minute / 60;
		minute = minute % 60;

		day += hour / 24;
		hour = hour % 24;

		month += day / 30;
		day = day % 30;

		year += month / 12;
		month = month % 12;

		invokeEvents(checkpoint);
	}

	private void invokeEvents(EcosystemTime checkpoint) {

		EventManager eg = SVE.getEventManager();

		if(eg == null)
			return;

		for(int current = minute; current - checkpoint.minute > 1; --current)
			eg.callEvent(EventType.TIME_MINUTE);

		for(int current = hour; current - checkpoint.hour > 1; --current)
			eg.callEvent(EventType.TIME_HOUR);

		for(int current = day; current - checkpoint.day > 1; --current)
			eg.callEvent(EventType.TIME_DAY);

		for(int current = month; current - checkpoint.month > 1; --current)
			eg.callEvent(EventType.TIME_MONTH);

		for(int current = year; current - checkpoint.year > 1; --current)
			eg.callEvent(EventType.TIME_YEAR);
	}

	private double computeSeconds(double deltaTime) {
		return deltaTime * secRelativity;
	}

	private double computeRelativeSeconds(double day) {

		double passedSeconds = day * 86400;

		if(passedSeconds <= 1.0) {
			return 1.0;
		}

		return passedSeconds;
	}
}
