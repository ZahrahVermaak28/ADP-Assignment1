package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Bid;
import za.ac.cput.Repository.IBidRepository;
import za.ac.cput.Service.BidService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService {

    private final IBidRepository bidRepository;

    @Autowired
    public BidServiceImpl(IBidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid create(Bid bid) {
        return bidRepository.create(bid);
    }

    @Override
    public Bid read(String bidId) {
        return bidRepository.read(bidId);
    }

    @Override
    public Bid update(Bid bid) {
        return bidRepository.update(bid);
    }

    @Override
    public boolean delete(String bidId) {
        return bidRepository.delete(bidId);
    }

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.getAll();
    }

    @Override
    public List<Bid> getAllBidsByAuctionId(String auctionId) {
        return bidRepository.getAll()
                .stream()
                .filter(bid -> bid.getAuctionId().equals(auctionId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bid> getAllBidsByUserId(String userId) {
        return bidRepository.getAll()
                .stream()
                .filter(bid -> bid.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
