package sve.core;

public class SystemTime {

	private static long start = System.nanoTime();
	private static final double NANO_TO_SECONDS = 1000000000.0;

	public static void checkpoint() {
		start = System.nanoTime();
	}

	public static double deltaTime() {
		return (System.nanoTime() - start) / NANO_TO_SECONDS;
	}
}
