package com.farmachinerental.platform.u20211a046.inventories.domain.services;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.aggregates.Tool;
import com.farmachinerental.platform.u20211a046.inventories.domain.model.commands.CreateToolCommand;

import java.util.Optional;

/**
 * Service to handle the tool commands
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
public interface ToolCommandService {

    Optional<Tool> handle (CreateToolCommand command);
}
