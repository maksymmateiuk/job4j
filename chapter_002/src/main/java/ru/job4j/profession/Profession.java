package ru.job4j.profession;

import ru.job4j.profession.otherclasses.Degree;
import ru.job4j.profession.otherclasses.Institution;
import ru.job4j.profession.otherclasses.Speciality;

/**
 * Profession.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Profession {

    private String name;

    private Degree degree;

    private Institution institution;

    private Speciality speciality;

    public String getName() {
        return this.name;
    }

}
