package sve.stats;

import java.io.File;
import java.util.ArrayList;

import sve.core.Point2D;
import sve.core.RuntimeGenerator;

public class Graphicer implements RuntimeGenerator<Session> {
	
	private ArrayList<Session> sessions;

	public void export() {
		// TODO Auto-generated method stub
	}
	
	public void draw(GraphType gtype, Point2D data) {
		// TODO Auto-generated method stub
	}
	
	public void newSession(GraphType type) {
		// TODO Auto-generated method stub
	}
	
	public Session getSession(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Session> generate(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void read(File file) {
		// TODO Auto-generated method stub	
	}
}
