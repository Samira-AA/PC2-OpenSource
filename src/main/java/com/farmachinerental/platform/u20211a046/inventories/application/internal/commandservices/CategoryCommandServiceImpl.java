package com.farmachinerental.platform.u20211a046.inventories.application.internal.commandservices;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.commands.SeedCategoryCommand;
import com.farmachinerental.platform.u20211a046.inventories.domain.model.entities.Category;
import com.farmachinerental.platform.u20211a046.inventories.domain.model.valueobjects.CategoryType;
import com.farmachinerental.platform.u20211a046.inventories.domain.services.CategoryCommandService;
import com.farmachinerental.platform.u20211a046.inventories.infraestructure.persistance.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;


/**
 * Service to handle the category commands
 * <p>
 *     This class implements the CategoryCommandService interface
 *     It is used to handle the seed category command
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {

    private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Method to handle the seed category command
     * It creates the category if it does not exist
     * @param command the seed category command
     */
    @Override
    public void handle(SeedCategoryCommand command) {
        Arrays.stream(CategoryType.values()).forEach(name -> {
            if (!categoryRepository.existsByName(name)) {
                categoryRepository.save(new Category(name));
            }
        });
    }
}
