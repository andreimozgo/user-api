package by.beatdev.service.impl;

import by.beatdev.dto.ChangingStatusResponse;
import by.beatdev.entity.User;
import by.beatdev.entity.UserStatus;
import by.beatdev.repository.UserRepository;
import by.beatdev.service.AbstractService;
import by.beatdev.service.UserService;
import by.beatdev.service.exceptions.NotFoundServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl extends AbstractService<User> implements UserService {
    final Logger LOG = Logger.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
        threadSleep();
    }

    public User getEntityById(Integer id) throws NotFoundServiceException {
        threadSleep();
        User user = userRepository.findOne(id);
        if(user == null) {
            throw new NotFoundServiceException("Not found user with id="+id);
        }
        return user;
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public UserStatus updateUserStatus(Integer userId, UserStatus newStatus) throws NotFoundServiceException {
        threadSleep();
        ChangingStatusResponse response = new ChangingStatusResponse();
        User user = getEntityById(userId);
        UserStatus previousStatus = user.getStatus();
        user.setStatus(newStatus);
        save(user);
        return previousStatus;
    }

    public User findById(Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    private void threadSleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOG.error("Error Thread.sleep: ", e);
        }
    }
}
