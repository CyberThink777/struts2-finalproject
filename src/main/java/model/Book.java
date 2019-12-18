package model;

import com.opensymphony.xwork2.validator.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

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
    @RegexFieldValidator(regex = "[0-9]{13}", key = "error.isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('title')")
    @StringLengthFieldValidator(maxLength = "255", key = "error.length", messageParams = "getText('title')")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('author')")
    @StringLengthFieldValidator(maxLength = "255", key = "error.length", messageParams = "getText('author')")
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('publisher')")
    @StringLengthFieldValidator(maxLength = "255", key = "error.length", messageParams = "getText('publisher')")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    @RequiredFieldValidator(key = "error.required", messageParams = "getText('year')")
    @IntRangeFieldValidator(min = "1000", max = "9999", key = "error.year")
    public void setYear(int year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    @IntRangeFieldValidator(min = "0", max = "99999", key = "error.intLength", messageParams = "getText('count')")
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
