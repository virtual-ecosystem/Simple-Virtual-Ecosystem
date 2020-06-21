package sve.core;

import java.util.ArrayList;
import java.util.Random;

public class CheetahGenerator extends AnimalGenerator{
	private final int minWeight = 20; // kg
	private final int maxWeight = 72; // kg 
	private final int minHeight = 100; // cm
	private final int maxHeight = 150; // cm 
	private final int maxAgeMale = 10; // year
	private final int maxAgeFemale = 14; // year
	private final int gestationTime = 3; // month
	private final int minSpeedLimit = 95; // k/h
	private final int maxSpeedLimit = 120; // k/h
	
	@Override
	public ArrayList<Animal> generate(int count) {
		Sex gender;
		int age;
		int weight;
		int height;
		int gestation;
		double speedLimit;

		ArrayList<Animal> list = new ArrayList<Animal>();
		
		for(int i=0; i<count; i++){
			Random r = new Random();
			
			if(r.nextInt(2) == 1){
				gender = Sex.FEMALE;
				age = (r.nextInt((maxAgeFemale -1)  + 1) + 1);
				gestation = gestationTime;
			}else{
				gender = Sex.FEMALE;
				age = (r.nextInt((maxAgeMale - 1)  + 1) + 1);
				gestation = 0;
			}	
			weight = (r.nextInt((maxWeight - minWeight) + 1) + minWeight);
			height = (r.nextInt((maxHeight - minHeight) + 1) + minHeight);
			speedLimit = (r.nextInt((maxSpeedLimit - minSpeedLimit) + 1) + minSpeedLimit);
			speedLimit = speedLimit * KPHtoMPS;
			list.add(new Cheetah(gender, age, weight, height, speedLimit, gestation));
		}
		return list;
	}
}
