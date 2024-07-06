package com.farmachinerental.platform.u20211a046.inventories.infraestructure.persistance.jpa.repositories;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.aggregates.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle the tool entity
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Repository
public interface ToolRepository extends JpaRepository<Tool, Long>{

    boolean existsByName(String name);
}
