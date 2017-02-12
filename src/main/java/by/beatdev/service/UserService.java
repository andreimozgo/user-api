package by.beatdev.service;

import by.beatdev.model.ChangeStatusRequest;
import by.beatdev.model.ChangeStatusResponse;
import by.beatdev.entity.User;

public interface UserService extends Service<User> {
    ChangeStatusResponse updateUserStatus (ChangeStatusRequest request);

}
