package sve.core;

public class EcosystemTime {

	private int year, month, day, hour, minute, second;

	private double offsecond;

	private double secRelativity;

	public EcosystemTime() {
		this(0.25);
	}

	public EcosystemTime(double dayRelativity) {
		this.year = this.day = this.hour = this.minute = this.second = 0;
		this.month = 0;
		this.offsecond = 0.0;
		this.secRelativity = computeRelativeSeconds(dayRelativity);
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
