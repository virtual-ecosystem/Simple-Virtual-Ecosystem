package sve.core;

import sve.gui.Renderable;
import java.util.Random;

public abstract class Animal implements LivingBeing, LifeTime, Movable, Renderable {

	private Sex sex;
	private int age, weight, height, gestation;
	private double speed;
	private Point2D<Integer> location;
	private Point2D<Double> highResLocation;

	public Animal(Sex sex, int age, int weight, int height, double speed, int gestation) {
		this.sex = sex;
		this.age = age;
		this.weight = height;
		this.speed = speed;
		this.gestation = gestation;
	}

	@Override
	public Point2D<Integer> location() {
		return location;
	}

	@Override
	public double speed() {
		return speed;
	}

	@Override
	public int age() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public Sex sex() {
		// TODO Auto-generated method stub
		return sex;
	}

	@Override
	public double fertility() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int heat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LifePeriod periodOfLife() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int resourceValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResourceType resourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int gestation() {
		// TODO Auto-generated method stub
		return 0;
	}
}
