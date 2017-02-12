package by.beatdev.service;

import by.beatdev.entity.User;
import by.beatdev.entity.UserStatus;

public interface UserService extends Service<User> {


    /**
     * Updated user status
     *
     * @param userId    user Id
     * @param newStatus new status
     * @return return previous status
     */
    UserStatus updateUserStatus(Integer userId, UserStatus newStatus);

}
