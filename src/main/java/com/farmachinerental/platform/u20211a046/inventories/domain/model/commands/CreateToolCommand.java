package com.farmachinerental.platform.u20211a046.inventories.domain.model.commands;

/**
 * Command to create a new tool
 * @param name
 * @param categoryId
 * @param description
 * @param referenceImageURL
 * @param rentalPrice
 * @author Samira Alvarez Araguache
 * @version 1.0
 */

public record CreateToolCommand (String name, Long categoryId, String description, String referenceImageURL, Double rentalPrice) {

    public CreateToolCommand{
        if (name == null || name.isBlank() || name.length() > 60) {
            throw new IllegalArgumentException("Name is required and must be less than 60 characters");
        }
        if (categoryId == null) {
            throw new IllegalArgumentException("Category is required");
        }
        if (description == null || description.isBlank() || description.length() > 300) {
            throw new IllegalArgumentException("Description is required and must be less than 300 characters");
        }
        if (referenceImageURL == null || referenceImageURL.isBlank()) {
            throw new IllegalArgumentException("Reference Image URL is required");
        }
        if (rentalPrice == null || rentalPrice < 1) {
            throw new IllegalArgumentException("Rental Price is required and must be greater than 0");
        }
    }

}
