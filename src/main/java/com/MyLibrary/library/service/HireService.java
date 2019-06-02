package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Hire;
import com.MyLibrary.library.repository.HireRepository;
import com.MyLibrary.library.security.service.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireService {

    @Autowired
    private HireRepository hireRepository;
    @Autowired
    private UserHelper userHelper;


    public List<Hire> getUserHires() {
        return hireRepository.getHireByUserId(new PageRequest(0, 15), userHelper.getLoggedUser().getId());
    }
}
