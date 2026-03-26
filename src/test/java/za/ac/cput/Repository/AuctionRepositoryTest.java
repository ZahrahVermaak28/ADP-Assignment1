package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Auction;
import za.ac.cput.repositoryImpl.AuctionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AuctionRepositoryTest {

    private IAuctionRepository repository = new AuctionRepository();

    private Auction auction = new Auction.Builder()
            .auctionID(1L)
            .productID(10L)
            .sellerId(2L)
            .startingPrice(new BigDecimal("100"))
            .endTime(LocalDateTime.now().plusDays(1))
            .build();


    @Test
    void create() {
        Auction created = repository.create(auction);

        assertNotNull(created);
        assertEquals(1L,created.getAuctionID());
    }

    @Test
    void read() {
        repository.create(auction);
        Auction read = repository.read(1L);

        assertNotNull(read);
    }

    @Test
    void update() {
        repository.create(auction);

        Auction updatedAuction = new Auction.Builder()
                .auctionID(1L)
                .productID(10L)
                .sellerId(2L)
                .startingPrice(new BigDecimal("200"))
                .endTime(LocalDateTime.now().plusDays(1))
                .build();

        Auction updated = repository.update(updatedAuction);
        assertEquals(new BigDecimal("200"), updated.getStartingPrice());
    }

    @Test
    void delete() {
        repository.create(auction);

        Boolean deleted = repository.delete(1L);
        assertTrue(deleted);

    }
}