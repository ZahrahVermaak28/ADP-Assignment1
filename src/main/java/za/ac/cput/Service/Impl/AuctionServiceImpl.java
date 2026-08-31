package za.ac.cput.Service.Impl;


import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Auction;
import za.ac.cput.Service.AuctionService;

import java.util.*;

@Service
public class AuctionServiceImpl implements AuctionService {

    private final List<Auction> auctions = new ArrayList<>();

    @Override
    public Auction create(Auction auction) {
        auctions.add(auction);
        return auction;
    }

    @Override
    public Auction read(Long auctionID) {
        for (Auction auction : auctions) {
            if (auction.getAuctionID().equals(auctionID)) {
                return auction;
            }
        }
        return null;
    }

    @Override
    public Auction update(Auction auction) {
        Auction existingAuction = read(auction.getAuctionID());
        if (existingAuction != null) {
            auctions.remove(existingAuction);
            auctions.add(auction);
            return auction;
        }
        return null;
    }

    @Override
    public boolean delete(Long auctionID) {
        Auction auction = read(auctionID);
        if (auction != null) {
            auctions.remove(auction);
            return true;
        }
        return false;
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctions;
    }

    @Override
    public List<Auction> getAuctionsByProductID(Long productID) {
        List<Auction> result = new ArrayList<>();
        for (Auction auction : auctions) {
            if (auction.getProductID().equals(productID)) {
                result.add(auction);
            }
        }
        return result;
    }

    @Override
    public List<Auction> getAuctionsByUserID(String userID) {
        List<Auction> result = new ArrayList<>();
        for (Auction auction : auctions) {
            if (auction.getUserID().equals(userID)) {
                result.add(auction);
            }
        }
        return result;
    }

    @Override
    public List<Auction> getActiveAuctions() {
        List<Auction> result = new ArrayList<>();
        for (Auction auction : auctions) {
            if (auction.isActive()) {
                result.add(auction);
            }
        }
        return result;
    }
}
