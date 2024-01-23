import {Auditorium} from "./auditorium";

export class Seat {

  seatId: number = 0;
  row: string = '';
  seatNo: string = '';
  auditorium: Auditorium = new Auditorium()

  constructor() {
  }
}
