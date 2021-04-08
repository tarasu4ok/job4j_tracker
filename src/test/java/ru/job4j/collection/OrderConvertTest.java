package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = List.of(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenFewOrdersWithChanging() {
        List<Order> orders = List.of(
                new Order("3sfe", "Dress"),
                new Order("5gsr", "Boots"),
                new Order("2hyg", "Shirt"),
                new Order("7qse", "Dress"),
                new Order("3sfe", "Hat"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Hat")));
        assertThat(map.get("5gsr"), is(new Order("5gsr", "Boots")));
        assertThat(map.get("2hyg"), is(new Order("2hyg", "Shirt")));
        assertThat(map.get("7qse"), is(new Order("7qse", "Dress")));
    }
}