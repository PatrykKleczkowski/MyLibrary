package com.MyLibrary.library.model;

import com.MyLibrary.library.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hire {

    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name="book_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Book book;

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    private Date hireDateFrom;

    private Date hireDateTo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hire hire = (Hire) o;
        return Objects.equals(id, hire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
