package com.MyLibrary.library.repository;

import com.MyLibrary.library.model.Hire;
import org.springframework.stereotype.Repository;

@Repository
public interface MockHireRepository extends HireRepository {

    @Override
    default <S extends Hire> S save(S entity) {
        return entity;
    }
}
