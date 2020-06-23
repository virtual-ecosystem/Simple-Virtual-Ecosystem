package sve.core;

import java.util.ArrayList;

/**
 * Database class of SVE
 *
 * @author repelliuss
 */
public class SVEDatabase {

	private ArrayList<Animal> animals;

	public SVEDatabase(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}
}
