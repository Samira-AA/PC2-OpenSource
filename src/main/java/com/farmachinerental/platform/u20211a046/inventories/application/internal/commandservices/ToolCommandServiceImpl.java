package com.farmachinerental.platform.u20211a046.inventories.application.internal.commandservices;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.aggregates.Tool;
import com.farmachinerental.platform.u20211a046.inventories.domain.model.commands.CreateToolCommand;
import com.farmachinerental.platform.u20211a046.inventories.domain.services.ToolCommandService;
import com.farmachinerental.platform.u20211a046.inventories.infraestructure.persistance.jpa.repositories.CategoryRepository;
import com.farmachinerental.platform.u20211a046.inventories.infraestructure.persistance.jpa.repositories.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service to handle the tool commands
 * <p>
 *     This class implements the ToolCommandService interface
 *     It is used to handle the create tool command
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Service
public class ToolCommandServiceImpl implements ToolCommandService {

    private final ToolRepository toolRepository;

    private final CategoryRepository categoryRepository;

    public ToolCommandServiceImpl(ToolRepository toolRepository, CategoryRepository categoryRepository) {
        this.toolRepository = toolRepository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * Method to handle the create tool command and save the tool
     * It creates the tool if it does not exist
     * It throws an exception if the tool already exists
     * It throws an exception if the category does not exist
     * @param command the create tool command
     * @return the tool created
     */

    @Override
    public Optional<Tool>handle (CreateToolCommand command){
        if(toolRepository.existsByName(command.name())){
            throw new IllegalArgumentException("Tool with name already exists");
        }
        if(!categoryRepository.existsById(command.categoryId())){
            throw new IllegalArgumentException("Category with name does not exist");
        }
        var tool = new Tool(command);
        return Optional.of(toolRepository.save(tool));
    }
}
