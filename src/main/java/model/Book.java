package model;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//TODO Validate
@Entity(name = "books")
public class Book implements Serializable {
    private String isbn, title, author, publisher, editBy;
    private int year, count;

    @Id
    @Column(name = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('isbn')")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('title')")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('author')")
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('publisher')")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}
