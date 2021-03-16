package ru.job4j.oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("War and peace", 2000);
        Book book2 = new Book("Clean code", 550);
        Book book3 = new Book("First steps in Java", 1024);
        Book book4 = new Book("Master and Margaret", 420);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        System.out.println("Books in our library:");
        for (int index = 0; index < books.length; index++) {
            System.out.println(String.valueOf(index + 1) + ". Name: " + books[index].getName()
                    + ", pages: " + books[index].getPageCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("===========================================");
        System.out.println("Books in our library after replace:");
        for (int index = 0; index < books.length; index++) {
            System.out.println(String.valueOf(index + 1) + ". Name: " + books[index].getName()
                    + ", pages: " + books[index].getPageCount());
        }
        System.out.println("===========================================");
        System.out.println("Books in our library with name " + '"' + "Clean code" + '"' + ":");
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(String.valueOf(index + 1) + ". Name: " + books[index].getName()
                        + ", pages: " + books[index].getPageCount());
            }
        }
    }
}
