import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Screening} from "../models/screening";
import {environment} from "../../../environments/environment";
import {Movie} from "../models/movie";
import {ScreeningDto} from "../models/screening-dto";

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
}
