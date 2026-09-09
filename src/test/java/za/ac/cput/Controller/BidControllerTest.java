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
import za.ac.cput.Domain.Bid;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class BidControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "/bid";

    private static final Bid bid =
            new Bid.Builder()
                    .setAuctionId("auction1")
                    .setUserId("user1")
                    .setBidId("bid1")
                    .setBidAmount(5000.00)
                    .setTimestamp(new Date())
                    .build();


    @Test
    void a_create() {

        ResponseEntity<Bid> response =
                restTemplate.postForEntity(
                        baseURL + "/create",
                        bid,
                        Bid.class
                );

        assertNotNull(response.getBody());
        assertEquals("bid1", response.getBody().getBidId());
        assertEquals("auction1", response.getBody().getAuctionId());
        assertEquals("user1", response.getBody().getUserId());
        assertEquals(5000.00, response.getBody().getBidAmount());

        System.out.println("Created: " + response.getBody());
    }


    @Test
    void b_read() {

        ResponseEntity<Bid> response =
                restTemplate.getForEntity(
                        baseURL + "/read/bid1",
                        Bid.class
                );

        assertNotNull(response.getBody());
        assertEquals("bid1", response.getBody().getBidId());
        assertEquals("auction1", response.getBody().getAuctionId());
        assertEquals("user1", response.getBody().getUserId());
        assertEquals(5000.00, response.getBody().getBidAmount());

        System.out.println("Read: " + response.getBody());
    }


    @Test
    void c_update() {

        Bid updatedBid =
                new Bid.Builder()
                        .setAuctionId("auction1")
                        .setUserId("user1")
                        .setBidId("bid1")
                        .setBidAmount(7500.00)
                        .setTimestamp(bid.getTimestamp())
                        .build();

        HttpEntity<Bid> request =
                new HttpEntity<>(updatedBid, new HttpHeaders());

        ResponseEntity<Bid> response =
                restTemplate.exchange(
                        baseURL + "/update",
                        HttpMethod.PUT,
                        request,
                        Bid.class
                );

        assertNotNull(response.getBody());
        assertEquals("bid1", response.getBody().getBidId());
        assertEquals(7500.00, response.getBody().getBidAmount());

        System.out.println("Updated: " + response.getBody());
    }


    @Test
    void d_getAll() {

        ResponseEntity<Bid[]> response =
                restTemplate.getForEntity(
                        baseURL + "/getall",
                        Bid[].class
                );

        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);

        System.out.println("All Bids:");

        for (Bid bid : response.getBody()) {
            System.out.println(bid);
        }
    }


   /* @Test
    void e_delete() {

        restTemplate.delete(baseURL + "/delete/bid1");

        ResponseEntity<Bid> response =
                restTemplate.getForEntity(
                        baseURL + "/read/bid1",
                        Bid.class
                );
        System.out.println("Deleted: " + response.getBody());
    }*/

       // assertNull(response.getBody());

}

