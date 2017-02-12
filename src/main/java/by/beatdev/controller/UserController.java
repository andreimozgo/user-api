package by.beatdev.controller;

import by.beatdev.dto.ChangingStatusRequest;
import by.beatdev.dto.ChangingStatusResponse;
import by.beatdev.dto.CreatingUserResponse;
import by.beatdev.entity.User;
import by.beatdev.entity.UserStatus;
import by.beatdev.service.UserService;
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
        User user = userService.findEntityById(id);
        if(user == null) {
            throw new NotFoundException("User not found with id " + id);
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
        UserStatus previousStatus = userService.updateUserStatus(request.getId(), request.getNewStatus());
        ChangingStatusResponse response = new ChangingStatusResponse();
        response.setId(request.getId());
        response.setNewStatus(request.getNewStatus());
        response.setPreviousStatus(previousStatus);
        return response;
    }
}
