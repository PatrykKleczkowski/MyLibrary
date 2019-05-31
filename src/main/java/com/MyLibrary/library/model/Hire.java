package com.MyLibrary.library.model;

import com.MyLibrary.library.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="book_id")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    private Date hireDateFrom;

    private Date hireDateTo;


}
