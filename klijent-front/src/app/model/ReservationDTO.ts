import { Accommodation } from './AccommodationDTO';

export class Reservation{
    id: number;
    accommodationName: string;
    accommodationId: number;
    fromDate: Date;
    toDate: Date;
    status: string;
}