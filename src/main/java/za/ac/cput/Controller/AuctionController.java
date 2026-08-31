package za.ac.cput.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Auction;
import za.ac.cput.Service.AuctionService;

import java.util.List;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/create")
    public Auction createAuction(@RequestBody Auction auction) {
        return auctionService.create(auction);
    }

    @GetMapping("/read/{auctionID}")
    public Auction readAuction(@PathVariable("auctionID") Long auctionID) {
        return auctionService.read(auctionID);
    }

    @PutMapping("/update")
    public Auction updateAuction(@RequestBody Auction auction) {
        return auctionService.update(auction);
    }

    @DeleteMapping("/delete/{auctionID}")
    public boolean deleteAuction(@PathVariable("auctionID") Long auctionID) {
        return auctionService.delete(auctionID);
    }

    @GetMapping("/getall")
    public List<Auction> getAllAuctions() {
        return auctionService.getAllAuctions();
    }

    @GetMapping("/product/{productID}")
    public List<Auction> getAuctionsByProductID(@PathVariable("productID") Long productID) {
        return auctionService.getAuctionsByProductID(productID);
    }

    @GetMapping("/user/{userID}")
    public List<Auction> getAuctionsByUserID(@PathVariable("userID") String userID) {
        return auctionService.getAuctionsByUserID(userID);
    }

    @GetMapping("/active")
    public List<Auction> getActiveAuctions() {
        return auctionService.getActiveAuctions();
    }
}
