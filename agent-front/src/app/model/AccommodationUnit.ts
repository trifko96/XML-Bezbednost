import { AccommodationType } from './AccommodationType';
import { AccommodationServices } from './AccommodationServices';
import { Image } from './Image';

export class AccommodationUnit {
    type : AccommodationType;
    description : string;
    services : AccommodationServices[] = [];
    category : string;
    location : Location = new Location();
    id : number;
    capacity : number;
    name : string;
    cancelingPeriod : number;
    image : Image[];
}