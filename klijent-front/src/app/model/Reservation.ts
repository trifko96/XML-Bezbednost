import { Accommodation } from './Accommodation';

export class Reservation{
    id: number;
    accommodation: Accommodation;
    fromDate: Date;
    toDate: Date;
}