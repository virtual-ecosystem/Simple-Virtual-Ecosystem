package sve.core;

public class Time {

	private static long staticStart;
	private static final double NANO_TO_SECONDS = 1000000000.0;

	private long start;

	public Time() {
		start = System.nanoTime();
	}

	public static void checkpoint() {
		staticStart = System.nanoTime();
	}

	public static double deltaTime() {
		return (System.nanoTime() - staticStart) / NANO_TO_SECONDS;
	}

	public void refresh() {
		start = System.nanoTime();
	}

	public double getDeltaTime() {
		return (System.nanoTime() - start) / NANO_TO_SECONDS;
	}
}
