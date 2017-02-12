package by.beatdev.service.impl;

import by.beatdev.entity.User;
import by.beatdev.model.ChangeStatusRequest;
import by.beatdev.model.ChangeStatusResponse;
import by.beatdev.repository.UserRepository;
import by.beatdev.service.AbstractService;
import by.beatdev.service.UserService;
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

    public void createOrUpdate(User user) {
            userRepository.save(user);
    }

    public User findEntityById(Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    public void delete(Integer id) {
            userRepository.delete(id);
    }

    public ChangeStatusResponse updateUserStatus (ChangeStatusRequest request){
        ChangeStatusResponse response = new ChangeStatusResponse();
        User user = findEntityById(request.getId());
        response.setId(user.getId());
        response.setPreviousSatus(user.getStatus());
        response.setStatus(request.getStatus());
        user.setStatus(request.getStatus());
        createOrUpdate(user);
        return response;
    }
}
