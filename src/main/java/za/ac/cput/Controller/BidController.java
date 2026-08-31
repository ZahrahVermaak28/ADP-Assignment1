package za.ac.cput.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Bid;
import za.ac.cput.Service.BidService;

import java.util.List;

@RestController
@RequestMapping("/bid")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/create")
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.create(bid);
    }

    @GetMapping("/read/{bidId}")
    public Bid readBid(@PathVariable("bidId") String bidId) {
        return bidService.read(bidId);
    }

    @PutMapping("/update")
    public Bid updateBid(@RequestBody Bid bid) {
        return bidService.update(bid);
    }

    @DeleteMapping("/delete/{bidId}")
    public boolean deleteBid(@PathVariable("bidId") String bidId) {
        return bidService.delete(bidId);
    }

    @GetMapping("/getall")
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }
}