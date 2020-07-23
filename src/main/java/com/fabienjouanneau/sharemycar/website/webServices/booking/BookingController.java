package com.fabienjouanneau.sharemycar.website.webServices.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }
    @GetMapping("{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.postBooking(booking);
    }
    @PutMapping("{id}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable Long id){
        if(booking.getBookingId() == id){
            return bookingService.putBooking(booking, id);
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookingById(@PathVariable Long id){
        bookingService.deleteBooking(id);
    }
}
