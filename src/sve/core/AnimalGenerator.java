package sve.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class AnimalGenerator implements RuntimeGenerator<Animal> {
	
	/**
	 * ArrayList of Animal to hold the data that read from file
	 */
	private ArrayList<Animal> animals;
	
	/**
	 * coefficient for convert k/h to m/s
	 */
	protected final double KPHtoMPS = 0.27777777777778 ;
	
	@Override
	public void read(File file) {
		BufferedReader br = null;
		String line = "";
		String temp = "";
		int word = 0;
		ArrayList<Animal> list = new ArrayList<Animal>();
		Sex gender = Sex.NONE;
		int age = 0;
		int weight = 0;
		int height = 0;
		int gestation = 0;
		double speed = 0;
		try{
			br = new BufferedReader(new FileReader(file));
		    line = br.readLine();
		   
		    while ((line = br.readLine()) != null) {
		        for(int i=0; i<line.length(); i++){
		        	if(line.charAt(i) != ','){
		        		temp += line.charAt(i);
		        	}else{
		        		if(word == 0){
		        			if(temp.equals("male")){
		        				gender = Sex.MALE;
		        			}else{
		        				gender = Sex.FEMALE;
		        			}
		        		}else if(word == 1){
		        			age = Integer.valueOf(temp);
		        		}else if(word == 2){
		        			gestation = Integer.valueOf(temp);
		        		}else if(word == 3){
		        			weight = Integer.valueOf(temp);
		        		}else if(word == 4){
		        			height = Integer.valueOf(temp);
		        		}else if(word == 5){
		        			speed = Double.valueOf(temp);
		        		}
		        		temp = "";
		        		word++;
		        	} 
		        }
		        list.add(new Cheetah(gender, age, weight, height, speed, gestation));
		        word = 0;
		    }   
		    setAnimals(list);
		    br.close();
		}catch(Exception e){
			
		}	
	}

	@Override
	public ArrayList<Animal> generate(int count) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Write given ArrayList of Animal to given file in csv format
	 * @param file file to be wrote on
	 * @param animals ArrayList of Animal to be wrote
	 */
	public void write(File file, ArrayList<Animal> animals){
		try{
			FileWriter fWriter = new FileWriter(file);
			LinkedList<LinkedList<String>> mainList = new LinkedList<LinkedList<String>>();
			for(int i=0; i<animals.size(); i++){
					
				LinkedList<String> subList = new LinkedList<String>();
								
				subList.addFirst(animals.get(i).sex().toString());
				subList.addFirst(Integer.toString(animals.get(i).age()));
				subList.addFirst(Integer.toString(animals.get(i).gestation()));
				subList.addFirst(Integer.toString(animals.get(i).weight()));
				subList.addFirst(Integer.toString(animals.get(i).height()));
				subList.addFirst(Double.toString(animals.get(i).speed()));
				mainList.addFirst(subList);
			}
			while(mainList.size()!=0){
				while(mainList.getFirst().size() !=0 ){
					fWriter.append(mainList.getFirst().poll());
					fWriter.append(",");
				}
				mainList.poll();
				fWriter.append("\n");
			}
			fWriter.close();	
		}catch(IOException e){
			
		}
		
	}
	
	/**
	 * Set animals list 
	 * @param animals ArrayList of Animal to be set
	 */
	private void setAnimals(ArrayList<Animal> animals){
		this.animals = new ArrayList<Animal>();
		this.animals = animals;
	}
	
	/**
	 * Get animals list
	 * @return animals list
	 */
	public ArrayList<Animal> getAnimals(){
		return animals;
	}

}
