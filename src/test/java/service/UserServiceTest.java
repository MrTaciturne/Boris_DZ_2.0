package service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import user_sevice.UserService;
import user_sevice.dao.UserDao;
import user_sevice.domain.User;

import java.util.Optional;

public class UserServiceTest {

    private static final User VANYA = new User(1, "Ivan", "1111");
    private static final User PETYA = new User(2, "Petya", "2222");
    private static final User SENIY = new User(2, "Seniy", "3333");

    private UserService userService;
    private UserDao userDao;

    @BeforeEach
    void init() {
        userDao = Mockito.mock(UserDao.class);
        userService = new UserService(userDao);
        System.out.println("BeforeEach " + this);
        userService.add(PETYA);
    }

    // TODO: 16.09.2023 Протестировать получение пользователя по id.
    @Test
    void workingGetById() {
        Optional<User> test = userService.getById(1);

        Assertions.assertEquals(test.get(), VANYA);
    }

    // TODO: 16.09.2023 Протестировать метод на уникальность id
    //  пользователей в системе при добавлении нового пользователя. :: create(User newUser)
    @Test
    void workingCreateUniqId() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> userService.create(SENIY));
        // Долго искал реализацию в инете
        // Не уверен, что полнростью понимаю смысл того, что в скобках присвоения

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    // TODO: 16.09.2023 Протестировать метод на то, что получает пользователя, если такой пользователь есть. :: login(String name, String password)
    @Test
    void userGettingWhat(){
        Assertions.assertDoesNotThrow(() -> userService.login("Petya", "2222"));
    }

    // TODO: 16.09.2023 Протестировать удаление пользователя. :: delete(User user)
    @Test
    void deletingUser(){
        Assertions.assertEquals(false, userService.delete(PETYA));
    }

}
