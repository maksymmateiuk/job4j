package ru.job4j.tracker;

import java.util.List;

/**
 * ValidateInput.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {

    public int ask(String question, List<Integer> range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Please select key from menu.");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);

        return value;
    }
}
