package za.ac.cput.Controller;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Auction;
import za.ac.cput.Factory.AuctionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class AuctionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "/auction";

    private static final Auction auction =
            AuctionFactory.createAuction(
                    1L,
                    1L,
                    "user1",
                    new BigDecimal("5000.00"),
                    LocalDateTime.now().plusDays(7)
            );

    @Test
    void a_create() {
        ResponseEntity<Auction> response =
                restTemplate.postForEntity(
                        baseURL + "/create",
                        auction,
                        Auction.class
                );

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getAuctionID());

        System.out.println("Created: " + response.getBody());
    }

    @Test
    void b_read() {
        ResponseEntity<Auction> response =
                restTemplate.getForEntity(
                        baseURL + "/read/1",
                        Auction.class
                );

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getAuctionID());
        assertEquals(
                new BigDecimal("5000.00"),
                response.getBody().getStartingPrice()
        );

        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {

        Auction updatedAuction =
                AuctionFactory.createAuction(
                        1L,
                        1L,
                        "user1",
                        new BigDecimal("7500.00"),
                        auction.getEndTime()
                );

        HttpEntity<Auction> request =
                new HttpEntity<>(updatedAuction, new HttpHeaders());

        ResponseEntity<Auction> response =
                restTemplate.exchange(
                        baseURL + "/update",
                        HttpMethod.PUT,
                        request,
                        Auction.class
                );

        assertNotNull(response.getBody());
        assertEquals(
                new BigDecimal("7500.00"),
                response.getBody().getStartingPrice()
        );

        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void d_getAll() {
        ResponseEntity<Auction[]> response =
                restTemplate.getForEntity(
                        baseURL + "/getall",
                        Auction[].class
                );

        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);

        System.out.println("All Auctions:");

        for (Auction auction : response.getBody()) {
            System.out.println(auction);
        }
    }

    @Test
    void e_getByProductID() {
        ResponseEntity<Auction[]> response =
                restTemplate.getForEntity(
                        baseURL + "/product/1",
                        Auction[].class
                );

        assertNotNull(response.getBody());

        System.out.println("Auctions by Product ID:");

        for (Auction auction : response.getBody()) {
            System.out.println(auction);
        }
    }

    @Test
    void f_getByUserID() {
        ResponseEntity<Auction[]> response =
                restTemplate.getForEntity(
                        baseURL + "/user/user1",
                        Auction[].class
                );

        assertNotNull(response.getBody());

        System.out.println("Auctions by User ID:");

        for (Auction auction : response.getBody()) {
            System.out.println(auction);
        }
    }

    @Test
    void g_getActive() {
        ResponseEntity<Auction[]> response =
                restTemplate.getForEntity(
                        baseURL + "/active",
                        Auction[].class
                );

        assertNotNull(response.getBody());

        System.out.println("Active Auctions:");

        for (Auction auction : response.getBody()) {
            System.out.println(auction);
        }
    }

    @Test
    void h_delete() {
        restTemplate.delete(baseURL + "/delete/1");

        ResponseEntity<Auction> response =
                restTemplate.getForEntity(
                        baseURL + "/read/1",
                        Auction.class
                );

        assertNull(response.getBody());

        System.out.println("Deleted: " + response.getBody());
    }
}