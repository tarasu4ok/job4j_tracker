package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sentWithoutDoubles() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sentWithDoubles() {
        List<Account> accounts = List.of(
                new Account("155", "Taras Kramarenko", "zzzxxxccc"),
                new Account("172", "Ivan Ivanov", "0000044"),
                new Account("155", "Tar Kram", "gggggggg"),
                new Account("172", "Ivan Ivanov", "0000011")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("155", "Taras Kramarenko", "zzzxxxccc"),
                        new Account("172", "Ivan Ivanov", "0000044")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}