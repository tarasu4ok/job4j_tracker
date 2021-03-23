package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void normalOrderById() {
        List<Item> list = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #3", 3),
                new Item("Task #4", 4),
                new Item("Task #2", 2)
        );
        List<Item> expectedList = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #2", 2),
                new Item("Task #3", 3),
                new Item("Task #4", 4)
        );
        Collections.sort(list);
        Assert.assertEquals(expectedList.toString(), list.toString());
    }

    @Test
    public void reverseOrderById() {
        List<Item> list = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #7", 4),
                new Item("Task #5", 2),
                new Item("Task #3", 3)
        );
        List<Item> expectedList = Arrays.asList(
                new Item("Task #7", 4),
                new Item("Task #3", 3),
                new Item("Task #5", 2),
                new Item("Task #1", 1)
        );
        Collections.sort(list, Collections.reverseOrder());
        Assert.assertEquals(expectedList.toString(), list.toString());
    }

    @Test
    public void normalOrderByName() {
        List<Item> list = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #7", 2),
                new Item("Task #4", 3),
                new Item("Task #5", 4)
        );
        List<Item> expectedList = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #4", 3),
                new Item("Task #5", 4),
                new Item("Task #7", 2)
        );
        Collections.sort(list, new Item.ItemComparatorNormalOrderByName());
        Assert.assertEquals(expectedList.toString(), list.toString());
    }

    @Test
    public void reverseOrderByName() {
        List<Item> list = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #7", 2),
                new Item("Task #4", 3),
                new Item("Task #5", 4)
        );
        List<Item> expectedList = Arrays.asList(
                new Item("Task #7", 2),
                new Item("Task #5", 4),
                new Item("Task #4", 3),
                new Item("Task #1", 1)
        );
        Collections.sort(list, new Item.ItemComparatorReverseOrderByName());
        Assert.assertEquals(expectedList.toString(), list.toString());
    }

    @Test
    public void normalOrderByIdAndName() {
        List<Item> list = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #4", 3),
                new Item("Task #3", 3),
                new Item("Task #2", 2)
        );
        List<Item> expectedList = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #2", 2),
                new Item("Task #3", 3),
                new Item("Task #4", 3)
        );
        Collections.sort(list, new Item.ItemComparatorNormalOrderByIdAndName());
        Assert.assertEquals(expectedList.toString(), list.toString());
    }

    @Test
    public void reverseOrderByIdAndName() {
        List<Item> list = Arrays.asList(
                new Item("Task #1", 1),
                new Item("Task #2", 1),
                new Item("Task #5", 4),
                new Item("Task #4", 4)
        );
        List<Item> expectedList = Arrays.asList(
                new Item("Task #5", 4),
                new Item("Task #4", 4),
                new Item("Task #2", 1),
                new Item("Task #1", 1)
        );
        Collections.sort(list, new Item.ItemComparatorReverseOrderByIdAndName());
        Assert.assertEquals(expectedList.toString(), list.toString());
    }
}