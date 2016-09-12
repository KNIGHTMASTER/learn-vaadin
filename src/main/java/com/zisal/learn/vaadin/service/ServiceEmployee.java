package com.zisal.learn.vaadin.service;

import com.zisal.learn.vaadin.data.EntityEmployee;
import com.zisal.learn.vaadin.data.RepoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ladies Man on 4/22/2016.
 */
@Service
public class ServiceEmployee implements IServiceEmployee{

    @Autowired
    RepoEmployee repoEmployee;

    @Override
    public List<EntityEmployee> getAllEmployee() {
        return (List<EntityEmployee>) repoEmployee.findAll();
    }


}
