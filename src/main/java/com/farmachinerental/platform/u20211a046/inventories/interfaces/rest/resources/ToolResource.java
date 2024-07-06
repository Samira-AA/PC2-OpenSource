package com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.resources;

/**
 * ToolResource class is a record class that represents the tool resource.
 *
 * @param id
 * @param name
 * @param categoryId
 * @param description
 * @param referenceImageURL
 * @param rentalPrice
 */
public record ToolResource (Long id, String name, Long categoryId, String description, String referenceImageURL, Double rentalPrice){
}
