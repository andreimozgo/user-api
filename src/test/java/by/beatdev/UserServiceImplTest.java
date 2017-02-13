package by.beatdev;

import by.beatdev.entity.User;
import by.beatdev.service.UserService;
import by.beatdev.service.exceptions.NotFoundServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest extends Assert {

    @Autowired
    private UserService userService;

    @Test
    public void testCreate() throws NotFoundServiceException {
        User user = new User();
        user.setName("testUser");
        userService.save(user);
        User readUser = userService.getEntityById(user.getId());
        assertNotNull(readUser);
        assertEquals(user.getName(), readUser.getName());
        userService.delete(user.getId());
    }

    @Test
    public void testFindEntityById() throws NotFoundServiceException {
        User user = new User();
        user.setName("testUser");
        userService.save(user);
        User findUser = userService.getEntityById(user.getId());
        assertNotNull(findUser);
        assertEquals(user.getId(), findUser.getId());
        assertEquals(user.getName(), findUser.getName());
        userService.delete(user.getId());
    }

    @Test
    public void testDelete() throws NotFoundServiceException {
        User user = new User();
        user.setId(null);
        user.setName("testUser");
        userService.save(user);
        userService.delete(user.getId());
        User deletedUser = userService.getEntityById(user.getId());
        assertNull(deletedUser);
    }
}
