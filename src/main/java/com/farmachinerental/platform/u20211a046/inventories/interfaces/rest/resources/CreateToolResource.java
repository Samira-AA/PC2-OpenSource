package com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.resources;

/**
 * CreateToolResource class is a record class that represents the create tool resource.
 * @param name
 * @param categoryId
 * @param description
 * @param referenceImageURL
 * @param rentalPrice
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
public record CreateToolResource(String name, Long categoryId, String description, String referenceImageURL, Double rentalPrice) {
}
