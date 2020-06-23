package sve.core;

import sve.event.EventManager;
import sve.gui.GuiScene;
import java.util.ArrayList;

/**
 *Main class for SVE system
 *
 *@author repelliuss
 */
public class SVE implements SVEModule {

	private static EventManager eventManager = new EventManager();;

	private SVEDatabase database;

	public SVE() {

		ArrayList<Animal> animals = new ArrayList<>();
		AnimalGenerator aGenerator = new CheetahGenerator();

		animals.addAll(aGenerator.generate(5));

		aGenerator = new GazelleGenerator();

		animals.addAll(aGenerator.generate(10));

		this.database = new SVEDatabase(animals);
	}

	public void start() {

		init();
		update();
		finish();
	}

	@Override
	public void init() {
		GuiScene.start();
	}

	@Override
	public void update() {
		//TODO
	}

	@Override
	public void finish() {
		//TODO
	}

	public static EventManager getEventManager() {
		return eventManager;
	}
}
