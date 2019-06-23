package ru.job4j.profession;

import ru.job4j.profession.otherclasses.Competitor;
import ru.job4j.profession.otherclasses.Design;
import ru.job4j.profession.otherclasses.Industry;
import ru.job4j.profession.otherclasses.Plane;

/**
 * Engineer.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Engineer extends Profession {

    private Industry industry;

    public Plane analyze(Plane plane) {
        return new Plane();
    }

    public Plane research(Competitor competitor) {
        return new Plane();
    }

    public Design makeDesign() {
        return new Design();
    }

    public void provideTesting(Plane plane) {
        // plane.doTesting();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
