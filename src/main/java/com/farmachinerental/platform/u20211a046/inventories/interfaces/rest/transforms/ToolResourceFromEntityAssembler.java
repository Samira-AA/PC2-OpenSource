package com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.transforms;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.aggregates.Tool;
import com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.resources.ToolResource;

/**
 * ToolResourceFromEntityAssembler class is a class that represents the assembler of the tool resource from entity.
 * @author Samira Alvarez Araguache
 * @version 1.0

 */
public class ToolResourceFromEntityAssembler {

    /**
     * Method to transform the tool entity to the tool resource
     * @param entity the tool entity
     * @return the tool resource
     */
    public static ToolResource toResourceFromEntity(Tool entity){
        return new ToolResource(
                entity.getId(),
                entity.getName(),
                entity.getCategoryId(),
                entity.getDescription(),
                entity.getReferenceImageURL(),
                entity.getRentalPrice()
        );

    }
}
