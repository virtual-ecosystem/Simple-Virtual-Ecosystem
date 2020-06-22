package sve.core;

public interface SVEModule {

	/**
	 * Init will be called when SVE starts
	 */
	void init();

	/**
	 * Update will be called each for each loop-frame
	 * of SVE
	 */
	void update();

	/**
	 * Finish will be called before quitting SVE
	 */
	void finish();
}
