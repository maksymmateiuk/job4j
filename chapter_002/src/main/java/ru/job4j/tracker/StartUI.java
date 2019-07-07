package ru.job4j.tracker;

/**
 * Start UI.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW_ALL_ITEMS = "1";
    private static final String EDIT_ITEM = "2";
    private static final String DELETE_ITEM = "3";
    private static final String FIND_ITEM_BY_ID = "4";
    private static final String FIND_ITEM_BY_NAME = "5";
    private static final String EXIT = "6";

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    public void init() {
        boolean exit = false;
        while(!exit) {
            this.showMenu();
            String answer = this.input.ask("Select:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL_ITEMS.equals(answer)) {
                this.showAllItems();
            } else if (EDIT_ITEM.equals(answer)) {
                this.editItem();
            } else if (DELETE_ITEM.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ITEM_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_ITEM_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("------ Adding new item ------");
        String name = this.input.ask("Please, enter item's name :");
        String desc = this.input.ask("Please, enter item's description :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------ New item getId : " + item.getId() + "------");
    }

    private void showAllItems() {
        for (Item item : this.tracker.findAll()) {
            System.out.println("-------------------------------------------------");
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("-------------------------------------------------");
        }
    }

    private void editItem() {
        System.out.println("------ Editing item ------");
        String id = this.input.ask("Please, enter item id :");
        String name = this.input.ask("Please, enter new item's name :");
        String desc = this.input.ask("Please, enter new item's description :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.replace(id, item);
    }

    private void deleteItem() {
        System.out.println("------ Deleting item ------");
        String id = this.input.ask("Please, enter item id: ");
        this.tracker.delete(id);
    }

    private void findById() {
        String id = this.input.ask("Please, enter item id: ");
        Item item = this.tracker.findById(id);
        System.out.println("-------------------------------------------------");
        System.out.println("Id: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Description: " + item.getDescription());
        System.out.println("-------------------------------------------------");
    }

    private void findByName() {
        String name = this.input.ask("Please, enter item name: ");
        for (Item item : this.tracker.findByName(name)) {
            System.out.println("-------------------------------------------------");
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("-------------------------------------------------");
        }
    }

    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
}
