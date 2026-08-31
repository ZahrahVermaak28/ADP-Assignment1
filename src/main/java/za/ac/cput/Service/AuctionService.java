package za.ac.cput.Service;

import za.ac.cput.Domain.Auction;

import java.util.List;

public interface AuctionService extends IService<Auction, Long> {

    List<Auction> getAllAuctions();

    List<Auction> getAuctionsByProductID(Long productID);

    List<Auction> getAuctionsByUserID(String userID);

    List<Auction> getActiveAuctions();
}
