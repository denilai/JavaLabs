package com.company;

public class Book {
    // FIELDS
    String author;
    String name;
    int yearOfCreating;

    //METHODS
    public Book(String author, String name, int yearOfCreating){

        this.author = author;
        this.name = name;
        this.yearOfCreating = yearOfCreating;
    }

    public int getYearOfCreating() {
        return yearOfCreating;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfCreating(int yearOfCreating) {
        this.yearOfCreating = yearOfCreating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", yearOfCreating=" + yearOfCreating +
                '}';
    }
}
