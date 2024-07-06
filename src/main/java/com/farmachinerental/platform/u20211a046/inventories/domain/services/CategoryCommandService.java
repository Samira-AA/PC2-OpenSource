package com.farmachinerental.platform.u20211a046.inventories.domain.services;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.commands.SeedCategoryCommand;

/**
 * Service to handle the category commands
 * @author Samira Alvarez Araguache
 * @version 1.0
 */

public interface CategoryCommandService {

    void handle (SeedCategoryCommand command);
}
