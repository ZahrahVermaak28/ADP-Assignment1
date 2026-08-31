package za.ac.cput.Service;

import za.ac.cput.Domain.Bid;
//import za.ac.cput.Service.IService;
import java.util.List;

public interface BidService extends IService<Bid, String> {

    List<Bid> getAllBids();
    List<Bid> getAllBidsByAuctionId(String auctionId);
    List<Bid> getAllBidsByUserId(String userId);
}
