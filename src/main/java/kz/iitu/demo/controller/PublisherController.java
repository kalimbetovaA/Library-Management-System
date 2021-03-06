package kz.iitu.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.demo.entity.Publisher;
import kz.iitu.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/publishers")
@Api(value = "Publisher Controller", description = "Publisher Controller allows to work with Publisher object")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @ApiOperation(value = "To get all Publishers from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public List<Publisher> getAll() {
        return publisherService.findAllPublishers();
    }

    @ApiOperation(value = "To get a specific Publisher by Id", response = Publisher.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Publisher object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    public Publisher findPublisherById(@PathVariable Long id) {
        return publisherService.findPublisherById(id);
    }

    @ApiOperation(value = "To search Publishers by the keyword", response = List.class)
    @GetMapping("/search/")
    public List<Publisher> searchPublishers(@RequestParam String keyword) {
        return publisherService.searchPublishers(keyword);
    }

    @ApiOperation(value = "To Create a new Publisher in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public void createPublisher(@RequestBody Publisher publisher) {
        publisherService.createPublisher(publisher);
    }

    @ApiOperation(value = "To Update specific Publisher")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public void updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        publisherService.updatePublisher(id, publisher);
    }

    @ApiOperation(value = "To Delete an Publisher")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
    }



}
