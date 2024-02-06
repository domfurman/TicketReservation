import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Screening} from "../models/screening";
import {environment} from "../../../environments/environment";
import {Movie} from "../models/movie";
import {ScreeningDto} from "../models/screening-dto";
import {Ticket} from "../models/ticket";
import {TicketDto} from "../models/ticket-dto";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class CinemaService {
  // private basicUrl: string = environment.apiBaseUrl
  private basicUrl: string = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  getAllScreenings(): Observable<Screening[]> {
    return this.http.get<Screening[]>(`${this.basicUrl}/api/screenings`);
  }

  getSingleScreening(screeningId: number): Observable<ScreeningDto> {
    return this.http.get<ScreeningDto>(`${this.basicUrl}/api/screenings/${screeningId}`)
  }

  getSingleTicket(ticketId: number): Observable<TicketDto> {
    return this.http.get<TicketDto>(`${this.basicUrl}/api/ticket/${ticketId}`)
  }

  addNewMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(`${this.basicUrl}/api/add-movie`, movie)
  }

  addNewScreening(screening: Screening): Observable<Screening> {
    return this.http.post<Screening>(`${this.basicUrl}/api/add-screening`, screening)
  }

  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.basicUrl}/api/movies`)
  }

  makeTicketReservation(ticket: Ticket): Observable<Ticket> {
    return this.http.post<Ticket>(`${this.basicUrl}/api/make-ticket-reservation`, ticket)
  }

  makeUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.basicUrl}/make-new-user`, user)
  }

  getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(`${this.basicUrl}/api/get-user-by-email/${email}`)
  }
}
