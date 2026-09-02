package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Register;
import za.ac.cput.Service.RegisterService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisterControllerTest {

    private static Register register = new Register.Builder()
            .setRegisterId("R001")
            .setEmail("test@gmail.com")
            .build();

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:1200/register";

    @BeforeEach
    @Order(1)
    void setUp() {

    }

    @Test
    @Order(2)
    void createRegister() {

        String url = BASE_URL + "/create";

        System.out.println("Post data");

        ResponseEntity<Register> postResponse =
                this.restTemplate.postForEntity(
                        url,
                        register,
                        Register.class
                );

        assertNotNull(postResponse);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());

        Register registerSaved = postResponse.getBody();

        assertNotNull(registerSaved);
        assertEquals(
                register.getRegisterId(),
                registerSaved.getRegisterId()
        );
        assertEquals(
                register.getEmail(),
                registerSaved.getEmail()
        );

        System.out.println("Created: " + registerSaved);
    }

    @Test
    @Order(3)
    void readRegister() {

        String url = BASE_URL + "/read/" + register.getRegisterId();

        ResponseEntity<Register> response =
                restTemplate.getForEntity(
                        url,
                        Register.class
                );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        assertEquals(
                register.getRegisterId(),
                response.getBody().getRegisterId()
        );

        assertEquals(
                register.getEmail(),
                response.getBody().getEmail()
        );

        System.out.println("Read: " + response.getBody());
    }

    @Test
    @Order(4)
    void updateRegister() {

        Register updatedRegister = new Register.Builder()
                .setRegisterId(register.getRegisterId())
                .setEmail("updated@gmail.com")
                .build();

        String url = BASE_URL + "/update";

        this.restTemplate.put(url, updatedRegister);

        ResponseEntity<Register> response =
                restTemplate.getForEntity(
                        BASE_URL + "/read/" + updatedRegister.getRegisterId(),
                        Register.class
                );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        assertEquals(
                updatedRegister.getRegisterId(),
                response.getBody().getRegisterId()
        );

        assertEquals(
                "updated@gmail.com",
                response.getBody().getEmail()
        );

        System.out.println("Updated: " + response.getBody());
    }

    @Test
    @Order(5)
    void getAllRegisters() {

        String url = BASE_URL + "/getall";

        ResponseEntity<Register[]> response =
                this.restTemplate.getForEntity(
                        url,
                        Register[].class
                );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);

        System.out.println("Get All Registers:");

        for (Register register : response.getBody()) {
            System.out.println(register);
        }
    }

    @Test
    @Order(6)
    void deleteRegister() {

        String url = BASE_URL + "/delete/" + register.getRegisterId();

        ResponseEntity<Boolean> deleteResponse =
                restTemplate.exchange(
                        url,
                        org.springframework.http.HttpMethod.DELETE,
                        null,
                        Boolean.class
                );

        assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());
        assertNotNull(deleteResponse.getBody());
        assertTrue(deleteResponse.getBody());

        ResponseEntity<Register> response =
                restTemplate.getForEntity(
                        BASE_URL + "/read/" + register.getRegisterId(),
                        Register.class
                );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());

        System.out.println("Deleted: " + register.getRegisterId());
    }
}