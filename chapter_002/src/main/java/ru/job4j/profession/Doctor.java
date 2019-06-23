package ru.job4j.profession;

import ru.job4j.profession.otherclasses.MedicalRecord;
import ru.job4j.profession.otherclasses.Nurse;
import ru.job4j.profession.otherclasses.Patient;

/**
 * Doctor.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Doctor extends Profession {

    @Override
    public String getName() {
        return super.getName();
    }

    public void callNurse(Nurse nurse) {
        // some to do
    }

    public String heal(Patient patient) {
        return "Доктор " + this.getName() + " лечит " + patient.getName();
    }

    public MedicalRecord diagnostics(Patient patient) {
        return new MedicalRecord();
    }
}
