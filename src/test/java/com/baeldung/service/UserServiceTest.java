package com.baeldung.service;

import com.baeldung.mockito.repository.User;
import com.baeldung.mockito.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.Random;

// @RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    // @Mock
    UserRepository userRepository; 
    UserService userService;

    @Before
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService    = new UserService(userRepository);
    }

    @Test
    public void test_getById() {

        final Random rnd = new Random();

        final Integer USER_ID     = rnd.nextInt(1000);
        final String  USER_NAME   = java.util.UUID.randomUUID().toString();
        final Integer USER_STATUS = rnd.nextInt(1000);

        final User USER = new User(); {
            USER.setId(USER_ID);
            USER.setName(USER_NAME);
            // USER.setStatus(USER_STATUS);
        }

        final Optional<User> OPTIONAL_USER = Optional.of(USER);

        Mockito
                .when(userRepository.findById(USER_ID))
                .thenReturn(OPTIONAL_USER);

        // NEEDS REDEFINING HASH-CODE FOR USER CLASS:
        // Assert.assertEquals(userRepository.findById(USER_ID), OPTIONAL_USER);

        // DOESN'T NEED REDEFINING HASH-CODE FOR USER CLASS:
        Assert.assertEquals(userRepository.findById(USER_ID).orElse(new User()).getId(), USER_ID);
        Assert.assertEquals(userRepository.findById(USER_ID).orElse(new User()).getName(), USER_NAME);
        Assert.assertEquals(userRepository.findById(USER_ID).orElse(new User()).getStatus(), USER_STATUS);

        Mockito.verify(userRepository,Mockito.times(3)).findById(USER_ID);

    }

}
