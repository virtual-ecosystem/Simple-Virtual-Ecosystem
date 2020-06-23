package sve.core;

public class Point2D<E> extends Point1D<E> {

	E y;
	
	public Point2D(E x, E y) {
		super(x);
		this.y = y;
	}
}
