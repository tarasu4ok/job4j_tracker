package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(mapSuit -> Stream.of(Value.values())
                        .map(value -> new Card(mapSuit, value))
                )
                .forEach(card -> System.out.println(card.suit + " " + card.value));
    }
}
