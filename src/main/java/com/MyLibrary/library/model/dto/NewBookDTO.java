package com.MyLibrary.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBookDTO {

    private String title;

    private Long authorId;

    private Date releaseDate;
}
