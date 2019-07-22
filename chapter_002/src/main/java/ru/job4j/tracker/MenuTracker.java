package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Menu tracker.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    public int getActionsLength() {
        return actions.size();
    }

    public int select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
        return key;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println("-------------------------------------------------");
                System.out.println("Id: " + item.getId());
                System.out.println("Name: " + item.getName());
                System.out.println("Description: " + item.getDescription());
                System.out.println("-------------------------------------------------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    private class UpdateItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------ Editing item ------");
            String id = input.ask("Please, enter item id :");
            String name = input.ask("Please, enter new item's name :");
            String desc = input.ask("Please, enter new item's description :");
            Item item = new Item(name, desc, System.currentTimeMillis());
            if (tracker.replace(id, item)) {
                System.out.println("------ Items saved ------");
            } else {
                System.out.println("------ Item not found ------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------ Deleting item ------");
            String id = input.ask("Please, enter item id: ");
            if (tracker.delete(id)) {
                System.out.println("------ Item deleted ------");
            } else {
                System.out.println("------ Item not found ------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    private class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter item id: ");
            Item item = tracker.findById(id);
            System.out.println("-------------------------------------------------");
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("-------------------------------------------------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id.");
        }
    }

    private class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter item name: ");
            for (Item item : tracker.findByName(name)) {
                System.out.println("-------------------------------------------------");
                System.out.println("Id: " + item.getId());
                System.out.println("Name: " + item.getName());
                System.out.println("Description: " + item.getDescription());
                System.out.println("-------------------------------------------------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
        }
    }

    private class ExitProgram implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            //System.out.println("Bye Bye.");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program.");
        }
    }
}
