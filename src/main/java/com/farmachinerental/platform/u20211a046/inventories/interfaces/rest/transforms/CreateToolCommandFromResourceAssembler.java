package com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.transforms;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.commands.CreateToolCommand;
import com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.resources.CreateToolResource;

/**
 * CreateToolCommandFromResourceAssembler class is a class that represents the assembler of the create tool command from resource.
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
public class CreateToolCommandFromResourceAssembler {

    /**
     * Method to transform the create tool resource to the create tool command
     * @param resource the create tool resource
     * @return the create tool command
     */
    public static CreateToolCommand toCommandFromResource(CreateToolResource resource){
        return new CreateToolCommand(
                resource.name(),
                resource.categoryId(),
                resource.description(),
                resource.referenceImageURL(),
                resource.rentalPrice()
        );

    }
}
