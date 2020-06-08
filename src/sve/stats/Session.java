package sve.stats;

import java.util.LinkedList;

import sve.core.Point2D;

public class Session {
	LinkedList<Point2D> data;
	int sessionID;
	GraphType type;
	
	private static int UNIQUE_ID = 0;
	
	public Session(GraphType type) {
		this.type = type;
		this.data = new LinkedList<>();
		this.sessionID = UNIQUE_ID++;
	}
}