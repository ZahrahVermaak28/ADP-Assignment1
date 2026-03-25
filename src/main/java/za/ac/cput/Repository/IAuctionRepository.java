package za.ac.cput.Repository;

import za.ac.cput.Domain.Auction;

public interface IAuctionRepository {

    Auction create(Auction auction);
    Auction read(Long auctionID);
    Auction update(Auction auction);
    Boolean delete(Long auctionID);

}
