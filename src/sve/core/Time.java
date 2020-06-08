package sve.core;

public class Time {

	private long start;
	private static final double NANO_TO_SECONDS = 1000000000.0;

	public Time() {
		start = System.nanoTime();
	}

	public void checkpoint() {
		start = System.nanoTime();
	}

	public double deltaTime() {
		return (System.nanoTime() - start) / NANO_TO_SECONDS;
	}
}
