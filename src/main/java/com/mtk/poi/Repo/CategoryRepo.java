package com.mtk.poi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtk.poi.Model.Category;

public interface CategoryRepo extends JpaRepository<Category,String> {
    
}
