package com.MyLibrary.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBookDTO {

    private String title;

    private UUID authorId;

    private Date releaseDate;
}
