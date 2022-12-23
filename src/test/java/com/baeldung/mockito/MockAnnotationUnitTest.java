package com.baeldung.mockito;

import com.baeldung.mockito.repository.User;
import com.baeldung.mockito.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationUnitTest {
    
    @Mock
    UserRepository mockRepository;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
        Mockito.when(mockRepository.count()).thenReturn(123L);

        long userCount = mockRepository.count();

        Assert.assertEquals(userCount, 123L);
        Mockito.verify(mockRepository).count();
    }
    
    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
        UserRepository localMockRepository = Mockito.mock(UserRepository.class);
        Mockito.when(localMockRepository.count()).thenReturn(111L);

        long userCount = localMockRepository.count();

        Assert.assertEquals(userCount, 111L);
        Mockito.verify(localMockRepository).count();
    }

    @Test
    public void givenFindByIdMethodMocked_WhenFindByIdInvoked_ThenMockedValueReturned() {

        final Random rnd = new Random();

        final Integer USER_ID     = rnd.nextInt(1000);
        final String  USER_NAME   = java.util.UUID.randomUUID().toString();
        final Integer USER_STATUS = rnd.nextInt(1000);

        final User USER = new User(); {
            USER.setId(USER_ID);
            USER.setName(USER_NAME);
            USER.setStatus(USER_STATUS);
        }

        final Optional<User> OPTIONAL_USER = Optional.of(USER);

        Mockito
                .when(mockRepository.findById(USER_ID))
                .thenReturn(OPTIONAL_USER);

        // NEEDS REDEFINING HASH-CODE FOR USER CLASS:
        // Assert.assertEquals(mockRepository.findById(USER_ID), OPTIONAL_USER);

        // DOESN'T NEED REDEFINING HASH-CODE FOR USER CLASS:
        Assert.assertEquals(mockRepository.findById(USER_ID).orElse(new User()).getId(), USER_ID);
        Assert.assertEquals(mockRepository.findById(USER_ID).orElse(new User()).getName(), USER_NAME);
        Assert.assertEquals(mockRepository.findById(USER_ID).orElse(new User()).getStatus(), USER_STATUS);

        Mockito.verify(mockRepository,Mockito.times(3)).findById(USER_ID);

    }

}
