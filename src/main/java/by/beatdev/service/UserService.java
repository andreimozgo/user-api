package by.beatdev.service;

import by.beatdev.dto.ChangingStatusRequest;
import by.beatdev.dto.ChangingStatusResponse;
import by.beatdev.entity.User;

public interface UserService extends Service<User> {
    ChangingStatusResponse updateUserStatus (ChangingStatusRequest request);

}
