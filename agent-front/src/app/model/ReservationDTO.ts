import { AccommodationUnit } from './AccommodationUnit';
import { User } from './User';

export class Reservation{
    id : number;
    accName : string;
    username : string;
    fromDate : Date;
    toDate : Date;
    status : string;
}