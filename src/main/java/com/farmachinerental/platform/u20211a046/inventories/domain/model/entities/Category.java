package com.farmachinerental.platform.u20211a046.inventories.domain.model.entities;


import com.farmachinerental.platform.u20211a046.inventories.domain.model.valueobjects.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Category entity
 * <p>
 *     This class represents the category entity in the domain model.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */

@Entity
public class Category {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 60, nullable = false, unique = true)
    private CategoryType name;

    public Category() {
    }

    /**
     * Constructor with the category name
     * <p>
     *     This constructor creates a new category with the given name.
     * </p>
     * @param name the category name
     */
    public Category(CategoryType name) {
        this.name = name;
    }
}
