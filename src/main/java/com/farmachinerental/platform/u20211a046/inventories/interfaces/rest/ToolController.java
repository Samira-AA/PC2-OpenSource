package com.farmachinerental.platform.u20211a046.inventories.interfaces.rest;


import com.farmachinerental.platform.u20211a046.inventories.domain.services.ToolCommandService;
import com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.resources.CreateToolResource;
import com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.resources.ToolResource;
import com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.transforms.CreateToolCommandFromResourceAssembler;
import com.farmachinerental.platform.u20211a046.inventories.interfaces.rest.transforms.ToolResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ToolController class
 * <p>
 *     This class is the entry point for all the REST endpoints related to the Tool entity.
 *     It is responsible for creating a new Tool.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@RestController
@RequestMapping(value="/api/v1/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipment", description = "Equipment Management Endpoints")
public class ToolController {

    private final ToolCommandService toolCommandService;

    /**
     * Constructor of the ToolController class
     * @param toolCommandService the service to handle the Tool commands
     */

    public ToolController(ToolCommandService toolCommandService) {
        this.toolCommandService = toolCommandService;
    }

    /**
     * Create a new Tool with the input data.
     * @param resource the resource containing the data to create the Tool
     * @return the created Tool
     */
    @Operation(summary = "Create a new Tool", description = "Create a new Tool with the input data.")
    @PostMapping
    public ResponseEntity<ToolResource> createTool(@RequestBody CreateToolResource resource){
        try{
            var createToolCommand = CreateToolCommandFromResourceAssembler.toCommandFromResource(resource);
            var toolEntity = toolCommandService.handle(createToolCommand);
            if (toolEntity.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            var toolResource = ToolResourceFromEntityAssembler.toResourceFromEntity(toolEntity.get());
            return new ResponseEntity<>(toolResource, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) { //404
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
