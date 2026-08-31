package za.ac.cput.Service.Impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Bid;
import za.ac.cput.Service.BidService;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {


    @Override
    public Bid create(Bid bid) {
        return null;
    }

    @Override
    public Bid read(String bidId) {
        return null;
    }

    @Override
    public Bid update(Bid bid) {
        return null;
    }

    @Override
    public boolean delete(String bidId) {
        return false;
    }

    @Override
    public List<Bid> getAllBids() {
        return null;
    }

    @Override
    public List<Bid> getAllBidsByAuctionId(String auctionId) {
        return null;
    }

    @Override
    public List<Bid> getAllBidsByUserId(String userId) {
        return null;
    }
}
