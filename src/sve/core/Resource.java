package sve.core;

public interface Resource {

	/**
	 * Food value that resource has in
	 * between 0 to 100.
	 * @return food value it has
	 */
	int resourceValue();

	/**
	 * Type of food.
	 * @return type of food
	 */
	ResourceType resourceType();
}
