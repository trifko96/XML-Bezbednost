import { AccommodationType } from './AccommodationType';
import { AccommodationServices } from './AccommodationServices';
import { Image } from './Image';
import { Location } from './Location';

export class AccommodationUnit {
    accommodationType : AccommodationType;
    description : string = "";
    accommodationService : AccommodationServices[] = [];
    category : string;
    location : Location = new Location();
    accommodationId : number;
    capacity : number;
    name : string = "";
    cancelingPeriod : number;
    image : Image[];
    status : string;
}