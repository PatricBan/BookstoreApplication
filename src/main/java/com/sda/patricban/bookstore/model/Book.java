package com.sda.patricban.bookstore.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    //    @Pattern(regexp = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})\n" +
    //    "[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$\n")

    @NotBlank
    @Size(min = 3, max = 40)
    @Column(name = "isbn")
    private String isbn;

    @NotEmpty
    @Size(min = 3)
    @Column(name = "title")
    private String title;

    @NotEmpty
    @Size(min = 20)
    @Column(name = "description")
    private String description;

    @NotNull
    @PastOrPresent
    @Column(name = "release_date")
    private Date releaseDate;

    public Book() {
    }

    public Book(@NotBlank String isbn, String title, String description, Date releaseDate) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
