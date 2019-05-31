package com.MyLibrary.library.repository;

import com.MyLibrary.library.model.Hire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HireRepository extends JpaRepository<Hire, Long> {

    Hire getHireByBook_Id(Long bookId);
}
