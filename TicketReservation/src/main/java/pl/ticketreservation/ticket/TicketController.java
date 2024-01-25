package pl.ticketreservation.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.movie.MovieService;
import pl.ticketreservation.screening.Screening;
import pl.ticketreservation.screening.ScreeningService;
import pl.ticketreservation.seat.Seat;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;
import pl.ticketreservation.ticket.ticketrepository.JdbcTicketRepository;
import pl.ticketreservation.user.User;
import pl.ticketreservation.user.userrepository.JdbcUserRepository;

import java.util.List;

@Controller
public class TicketController {

    private final TicketService ticketService;
    private final MovieService movieService;
    private final ScreeningService screeningService;
    private final JdbcUserRepository jdbcUserRepository;
    private final JdbcSeatRepository jdbcSeatRepository;

    @Autowired
    public TicketController(TicketService ticketService, MovieService movieService, ScreeningService screeningService, JdbcUserRepository jdbcUserRepository, JdbcSeatRepository jdbcSeatRepository){
        this.ticketService = ticketService;
        this.movieService = movieService;
        this.screeningService = screeningService;
        this.jdbcUserRepository = jdbcUserRepository;
        this.jdbcSeatRepository = jdbcSeatRepository;
    }

    @GetMapping(path = "api/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

//    @ResponseBody
    @PostMapping(value = "api/make-ticket-reservation")
    public ResponseEntity<Integer> makeTicketReservation(@RequestBody Ticket ticket){
        int ticketId =  ticketService.makeTicketReservation(ticket);
        return ResponseEntity.ok(ticketId);
    }

    @GetMapping(path = "api/ticket/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable("id") int ticketId) {
        /*model.addAttribute("ticket", ticketService.getTicketById(ticketId));
        model.addAttribute("movie", movieService.getMovieInfoByTicketId(ticketId));
        model.addAttribute("screening", screeningService.getScreeningInfoByTicketId(ticketId));
        model.addAttribute("user", jdbcUserRepository.getUserInfoByTicketId(ticketId));
        model.addAttribute("seat", jdbcSeatRepository.getSeatInfoByTicketId(ticketId));*/
//        return "ticket";
        Ticket ticket = ticketService.getTicketById(ticketId);
        Movie movie = movieService.getMovieInfoByTicketId(ticketId);
        Screening screening = screeningService.getScreeningInfoByTicketId(ticketId);
        User user = jdbcUserRepository.getUserInfoByTicketId(ticketId);
        Seat seat = jdbcSeatRepository.getSeatInfoByTicketId(ticketId);

        TicketDTO ticketDTO = new TicketDTO(ticket, screening, user, seat);

        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
    }
}
