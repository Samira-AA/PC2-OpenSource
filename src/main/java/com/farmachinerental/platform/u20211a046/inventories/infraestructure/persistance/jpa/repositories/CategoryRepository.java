package com.farmachinerental.platform.u20211a046.inventories.infraestructure.persistance.jpa.repositories;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.entities.Category;
import com.farmachinerental.platform.u20211a046.inventories.domain.model.valueobjects.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle the category entity
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    boolean existsByName(CategoryType name);
}
