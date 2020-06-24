package sve.core;

import java.util.ArrayList;

/**
 * Database class of SVE
 *
 * @author repelliuss
 */
public class SVEDatabase {

	private static ArrayList<Animal> animals;

	public SVEDatabase(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	public static ArrayList<Animal> getAnimals() {
		return animals;
	}
}
