package by.beatdev;

import by.beatdev.entity.User;
import by.beatdev.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class UserRepositoryTest extends Assert {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = new User();
        user.setName("testUser");
        User createdUser = userRepository.save(user);
        User readUser = userRepository.findOne(createdUser.getId());
        assertNotNull(readUser);
        assertEquals(createdUser, readUser);
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setName("testUser");
        User createdUser = userRepository.save(user);
        userRepository.delete(createdUser.getId());
        User deletedUser = userRepository.findOne(createdUser.getId());
        assertNull(deletedUser);
    }

    @Test
    public void testFindEntityById() {
        User user = new User();
        user.setName("testUser");
        User createdUser = userRepository.save(user);
        User readUser = userRepository.findOne(createdUser.getId());
        assertEquals(createdUser, readUser);
    }

}
