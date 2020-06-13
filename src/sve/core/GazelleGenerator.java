import java.util.ArrayList;
import java.util.Random;

public class GazelleGenerator extends AnimalGenerator {
	private final int minWeight = 45; // kg
	private final int maxWeight = 65; // kg
	private final int minHeight = 140; // cm
	private final int maxHeight = 166; // cm 
	private final int maxAgeMale = 12; // year
	private final int maxAgeFemale = 12; // year
	private final int gestationTime = 7; // month
	private final int minSpeedLimit = 80; // k/h
	private final int maxSpeedLimit = 97; // k/h
	
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
			list.add(new Gazelle(gender, age, weight, height, speedLimit, gestation));
		}
		return list;
	}	
}
