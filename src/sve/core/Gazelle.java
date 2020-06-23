package sve.core;

import sve.gui.RenderTypes;

public class Gazelle extends Animal {
	
	public Gazelle(Sex sex, int age, int weight, int height, double speed, int gestation){
		// TODO
	}
	
	@Override
    public double speed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String pathTo(RenderTypes type) {
        return "file:src/sve/gui/images/64-gazelle.jpg";
    }
	@Override
	public Point2D<Integer> goTo(Condition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMinutely() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateHourly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDayly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMonthly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateYearly() {
		// TODO Auto-generated method stub
	}
}
