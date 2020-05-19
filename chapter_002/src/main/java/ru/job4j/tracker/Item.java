package ru.job4j.tracker;

import java.util.Objects;

/**
 * Item.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long time;

    public Item() {

    }

    public Item(String name, String description, long time) {
        this.name = name;
        this.description = description;
        this.time = time;
    }

   public void setName(String name) {
      this.name = name;
   }

   public void setDescription(String description) {
      this.description = description;
   }

    public void setTime(long time) {
        this.time = time;
    }

   public String getName() {
      return this.name;
   }

   public String getDescription() {
      return this.description;
   }

   public long getTime() {
      return this.time;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String id) {
      this.id = id;
   }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time
                == item.time
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, time);
    }
}
