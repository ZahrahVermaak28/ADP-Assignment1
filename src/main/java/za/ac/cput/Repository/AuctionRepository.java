package za.ac.cput.Repository;

import za.ac.cput.Domain.Auction;

import java.util.HashMap;
import java.util.Map;

public class AuctionRepository implements IAuctionRepository{

    private Map<Long, Auction> data = new HashMap<>();

    @Override
    public Auction create(Auction auction) {
        data.put(auction.getAuctionID(), auction );
        return auction;
    }

    @Override
    public Auction read(Long auctionID) {
        return data.get(auctionID);
    }

    @Override
    public Auction update(Auction auction) {
        data.put(auction.getAuctionID(), auction);
        return auction;
    }

    @Override
    public Boolean delete(Long auctionID) {
        data.remove(auctionID);
        return true;
    }
}
