import { Location } from './Location';
import { AccommodationType } from './AccommodationType';
import { AccommodationService } from './AccommodationService';

export class Accommodation{
    accommodationType: AccommodationType;
    description: string = "";
    accommodationService: AccommodationService[] = [];
    category: number = 0;
    location: Location = new Location();
    accommodationId: number;
    capacity: number = 0;
    name: string = "";
    fromDate : Date;
    toDate : Date;
}


