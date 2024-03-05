package controller.user;

import org.example.controller.user.UserController;
import org.example.dto.user.UserResponseDto;
import org.example.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class UserControllerTest {
   @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void get_all_users_with_data_test(){
        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto("1", "Yeni", "Velandia","velandia416@gmail.com"));
        users.add(new UserResponseDto("2", "Ruben", "Sanchez","ruben0606@gmail.com"));
        Mockito.when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<UserResponseDto>> response = userController.getAllUsers();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        }
    @Test
    public void find_user_by_id_existing_test(){
        String userId = "1";
        UserResponseDto userResponseDto = new UserResponseDto("1", "Yeni", "Velandia", "velandia416@gmail.com");
        Mockito.when(userService.findUserById(userId)).thenReturn(userResponseDto);

        ResponseEntity<UserResponseDto> response = userController.findUserById(userId);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(userResponseDto, response.getBody());
    }

    @Test
    public void find_user_by_id_not_found_test() {
        String userId = "456";
        Mockito.when(userService.findUserById(userId)).thenThrow(new NoSuchElementException("User not found"));

        ResponseEntity<UserResponseDto> response = userController.findUserById(userId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("The user " +  userId + " doesn't exist in the database", response.getBody());
    }

    @Test
    public void delete_user_test() {

        String userId = "1";
        Mockito.when(userService.deleteUserById(userId)).thenReturn(true);

        ResponseEntity<Boolean> response = userController.deleteUser(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
    }
    @Test
    public void delete_user_not_found_test() {
        // Arrange
        String userId = "123";
        Mockito.when(userService.deleteUserById(userId)).thenReturn(false);

        // Act
        ResponseEntity<Boolean> response = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.getBody());
    }

}
