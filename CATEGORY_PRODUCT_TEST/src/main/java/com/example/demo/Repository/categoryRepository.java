package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Dao.Category;

public interface categoryRepository extends JpaRepository<Category, Long>
{
	// Custom Query for Pagination 
    @Query("SELECT c FROM Category c WHERE c.categoryId BETWEEN :start AND :end")
    List<Category> findCategoriesWithPagination(@Param("start") int start, @Param("end") int end);
}
