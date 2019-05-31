package com.MyLibrary.library.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NewBookDTO {

    private String title;

    private Long authorId;

    private Date releaseDate;
}
