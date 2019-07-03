package com.MyLibrary.library.repository;

import com.MyLibrary.library.model.Hire;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface HireRepository extends JpaRepository<Hire, Long> {

    Hire getHireByBook_Id(Long bookId);

    @Query("SELECT h FROM Hire h WHERE h.user.id =:id  ORDER BY h.hireDateFrom DESC")
    List<Hire> getHireByUserId(Pageable pageable, @Param("id") UUID id);
}
