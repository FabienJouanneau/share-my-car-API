package com.fabienjouanneau.sharemycar.website.webServices.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    // GET ALL BOOKINGS
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
    // GET BOOKING BY ID
    public Booking getBookingById(Long id){
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if(optionalBooking.isPresent()){
            return optionalBooking.get();
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    // POST BOOKING
    public Booking postBooking(Booking booking){
        return bookingRepository.save(booking);
    }
    // PUT BOOKING
    public Booking putBooking(Booking booking, Long id){
        Booking bookingUpdated = bookingRepository.findById(id).get();
        bookingUpdated.setStartingDate(booking.getStartingDate());
        bookingUpdated.setEndingDate(booking.getEndingDate());
        bookingUpdated.setAmount(booking.getAmount());

        return bookingRepository.save(bookingUpdated);
    }
    // DELETE BOOKING
    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
}
