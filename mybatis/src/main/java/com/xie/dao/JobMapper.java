package com.xie.dao;

import com.xie.domain.Job;

import java.util.List;

public interface JobMapper {
    public List<Job> findAll();
    public Job findById(int id);
}
