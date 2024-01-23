import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Screening} from "../models/screening";
import {environment} from "../../../environments/environment";

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
}