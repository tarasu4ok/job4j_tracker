package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + formatter.format(created)
                + '}';
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.getId());
    }

    public static class ItemComparatorNormalOrderByName implements Comparator<Item> {
        @Override
        public int compare(Item first, Item second) {
            return first.getName().compareTo(second.getName());
        }
    }

    public static class ItemComparatorReverseOrderByName implements Comparator<Item> {
        @Override
        public int compare(Item first, Item second) {
            return second.getName().compareTo(first.getName());
        }
    }

    public static class ItemComparatorNormalOrderByIdAndName implements Comparator<Item> {
        @Override
        public int compare(Item first, Item second) {
            if (first.getId() == second.getId()) {
                return first.getName().compareTo(second.getName());
            } else {
                return Integer.compare(first.getId(), second.getId());
            }
        }
    }

    public static class ItemComparatorReverseOrderByIdAndName implements Comparator<Item> {
        @Override
        public int compare(Item first, Item second) {
            if (first.getId() == second.getId()) {
                return second.getName().compareTo(first.getName());
            } else {
                return Integer.compare(second.getId(), first.getId());
            }
        }
    }
}