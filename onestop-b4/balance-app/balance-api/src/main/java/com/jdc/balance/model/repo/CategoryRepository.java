package com.jdc.balance.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.entity.Category;
import com.jdc.balance.model.entity.Category.CategoryType;

public interface CategoryRepository extends JpaRepositoryImplementation<Category, Integer> {

	List<Category> findByType(CategoryType type);

}
