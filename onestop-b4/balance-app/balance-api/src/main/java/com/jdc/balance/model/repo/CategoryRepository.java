package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jdc.balance.model.entity.Category;

public interface CategoryRepository extends 
JpaRepository<Category, Integer>, 
JpaSpecificationExecutor<Category> {

}
