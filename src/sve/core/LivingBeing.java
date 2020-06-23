package sve.core;

/**
 * Every living being has some properties it has or
 * defined. This interface specify these properties.
 *
 * @author repelliuss
 */
public interface LivingBeing extends Resource {

	/**
	 * Many living beings move around in their
	 * environment. This method returns their walking
	 * speed in the map of SVE in meters per second.
	 * @return living being's speed in m/s
	 */
	double speed();

	/**
	 * The time it lived in the world since its
	 * birth in years.
	 * @return the biological age of living being
	 */
	int age();

	/**
	 * Mass of living being.
	 * @return weight of living being in gram
	 */
	int weight();

	/**
	 * Maximum length of living being from one point of
	 * it to another.
	 * @return the height of living being in cm
	 */
	int height();

	/**
	 * Gender of living being.
	 * @return sex of living being
	 */
	Sex sex();

	/**
	 * Fertility rating of living beings. If it is
	 * equal to or bigger than 1, then it can give a
	 * birth.
	 * @return the fertility rating
	 */
	double fertility();

	/**
	 * State living being has that develops over time
	 * to mate. It returns 0 to 1000.
	 * @return current heat ratio to copulate
	 */
	int heat();

	/**
	 * Every living being has periods of its life categorized
	 * by humans: baby, child, teenager, adult...
	 * @return current state it is in of its
	 * periods of life
	 */
	LifePeriod periodOfLife();
	
	/**
	 * Gestation time of the female living beings
	 * @return gestation of living beings in months, 0 for males
	 */
	int gestation();

	Point2D<Integer> location();
}
