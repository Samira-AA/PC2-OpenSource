package com.farmachinerental.platform.u20211a046.inventories.domain.model.aggregates;

import com.farmachinerental.platform.u20211a046.inventories.domain.model.commands.CreateToolCommand;
import com.farmachinerental.platform.u20211a046.inventories.domain.model.entities.Category;
import com.farmachinerental.platform.u20211a046.shared.domain.agreggates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * Tool entity class
 * <p>
 *     This class represents the tool entity in the domain model.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */

@Entity
public class Tool extends AuditableAbstractAggregateRoot<Tool> {


    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @NotBlank
    @Size(max=60)
    @Column(length = 60, nullable = false)
    private String name;

    @Getter
    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private Category category;

    @Getter
    @NotBlank
    @Size(max=300)
    @Column(length = 300, nullable = false)
    private String description;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private String referenceImageURL;

    @Getter
    @NotBlank
    @Min(1)
    @Column(nullable = false)
    private Double rentalPrice;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Long categoryId;

    public Tool(){

    }

    public Tool(String name, Category category, String description, String referenceImageURL, Double rentalPrice, Long categoryId){
        this.name = name;
        this.category = category;
        this.description = description;
        this.referenceImageURL = referenceImageURL;
        this.rentalPrice = rentalPrice;
        this.categoryId = categoryId;
    }

    /**
     * Constructor for the Tool entity
     * <p>
     *     This constructor creates a new Tool entity from a CreateToolCommand object.
     * </p>
     * @param command  The CreateToolCommand object
     */
    public Tool(CreateToolCommand command){
        this.name = command.name();
        this.description = command.description();
        this.referenceImageURL = command.referenceImageURL();
        this.rentalPrice = command.rentalPrice();
        this.categoryId = command.categoryId();
    }

}
