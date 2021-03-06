package by.beatdev.controller;

import by.beatdev.controller.exceptions.NotFoundException;
import by.beatdev.dto.ChangingStatusRequest;
import by.beatdev.dto.ChangingStatusResponse;
import by.beatdev.dto.CreatingUserResponse;
import by.beatdev.entity.User;
import by.beatdev.entity.UserStatus;
import by.beatdev.service.UserService;
import by.beatdev.service.exceptions.NotFoundServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    final Logger LOG = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") int id) {
        User user;
        try {
            user = userService.getEntityById(id);
        } catch (NotFoundServiceException e) {
            LOG.error("User not found: ", e);
            throw new NotFoundException(e.getMessage());
        }
        return user;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CreatingUserResponse addUser(@RequestBody User user) {
        userService.save(user);
        CreatingUserResponse creatingUserResponse = new CreatingUserResponse();
        creatingUserResponse.setId(user.getId());
        return creatingUserResponse;
    }

    @PutMapping(value = "/changestatus", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChangingStatusResponse updateUserStatus(@RequestBody ChangingStatusRequest request) {
        UserStatus previousStatus;
        try {
            previousStatus = userService.updateUserStatus(request.getId(), request.getNewStatus());
        } catch (NotFoundServiceException e) {
            LOG.error("User not found: ", e);
            throw new NotFoundException(e.getMessage());
        }
        ChangingStatusResponse response = new ChangingStatusResponse();
        response.setId(request.getId());
        response.setNewStatus(request.getNewStatus());
        response.setPreviousStatus(previousStatus);
        return response;
    }
}
