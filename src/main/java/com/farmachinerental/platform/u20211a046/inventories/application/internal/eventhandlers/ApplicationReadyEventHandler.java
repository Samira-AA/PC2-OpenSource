package com.farmachinerental.platform.u20211a046.inventories.application.internal.eventhandlers;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.commands.SeedCategoryCommand;
import com.farmachinerental.platform.u20211a046.inventories.domain.services.CategoryCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Event handler to seed the categories when the application is ready
 * <p>
 *     This class implements the ApplicationReadyEvent interface
 *     It is used to seed the categories when the application is ready
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Service
public class ApplicationReadyEventHandler {

    private final CategoryCommandService categoryCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(CategoryCommandService categoryCommandService) {
        this.categoryCommandService = categoryCommandService;
    }

    /**
     * Method to seed the categories when the application is ready
     * It seeds the categories if they do not exist
     * It logs the information when the application is ready
     * @param event the application ready event
     */

    @EventListener
    public void on (ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if categories seeding is needed.", applicationName);
        var seedCommand = new SeedCategoryCommand();
        categoryCommandService.handle(seedCommand);
        LOGGER.info("Categories seeding is done.");
    }
}
