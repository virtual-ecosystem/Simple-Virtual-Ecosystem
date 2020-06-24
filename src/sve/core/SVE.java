package sve.core;

import sve.event.EventManager;
import sve.gui.GuiScene;
import java.util.ArrayList;
import sve.event.EventType;
import sve.event.Listener;

/**
 *Main class for SVE system
 *
 *@author repelliuss
 */
public class SVE implements SVEModule, Listener {

	private static EventManager eventManager = new EventManager();

	private SVEDatabase database;

	private boolean quitSve, isWorking;

	public SVE() {

		ArrayList<Animal> animals = new ArrayList<>();
		AnimalGenerator aGenerator = new CheetahGenerator();

		animals.addAll(aGenerator.generate(5));

		aGenerator = new GazelleGenerator();

		animals.addAll(aGenerator.generate(10));

		this.database = new SVEDatabase(animals);

		this.quitSve = this.isWorking = false;
	}

	public void start() {

		init();
		update();
		finish();
	}

	@Override
	public void init() {
		Listener aeh = new AnimalEventHandler();
		eventManager.register(EventType.TIME_MINUTE, aeh);
		eventManager.register(EventType.TIME_HOUR, aeh);
		eventManager.register(EventType.TIME_DAY, aeh);
		eventManager.register(EventType.TIME_MONTH, aeh);
		eventManager.register(EventType.TIME_YEAR, aeh);
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

	@Override
	public void onEvent(EventType etype) {

		switch(etype) {
			case QUIT:
				quitSve = true;
				break;
			case START_SVE:
				isWorking = true;
				break;
			case STOP_SVE:
				isWorking = false;
				break;
		}
	}
	public static EventManager getEventManager() {
		return eventManager;
	}
}
