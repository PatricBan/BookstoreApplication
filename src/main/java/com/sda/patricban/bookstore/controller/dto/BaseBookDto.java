package com.sda.patricban.bookstore.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO -> data transfer object
 */
public class BaseBookDto {

    @Size(min = 10)
    @NotEmpty
    private String description;

    @Size(min = 3)
    @NotEmpty
    private String title;

    @NotNull
    private String releaseDate;

    private Integer id;

    public BaseBookDto(String description, String title, String releaseDate, Integer id) {
        this.description = description;
        this.title = title;
        this.releaseDate = releaseDate;
        this.id = id;
    }

    public BaseBookDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
