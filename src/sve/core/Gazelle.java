package sve.core;

import sve.gui.RenderTypes;

public class Gazelle extends Animal {
    @Override
    public double speed() {
        return 0;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public Sex sex() {
        return null;
    }

    @Override
    public double fertility() {
        return 0;
    }

    @Override
    public int heat() {
        return 0;
    }

    @Override
    public LifePeriod periodOfLife() {
        return null;
    }

    @Override
    public int resourceValue() {
        return 0;
    }

    @Override
    public ResourceType resourceType() {
        return null;
    }

    @Override
    public String pathTo(RenderTypes type) {
        return "file:src/sve/gui/sample/images/64-gazelle.jpg";
    }
}
