import { Location } from './Location';
import { AccommodationType } from './AccommodationType';
import { AccommodationService } from './AccommodationService';

export class Accommodation{
    accommodationType: AccommodationType;
    description: string = "";
    accommodationService: AccommodationService;
    category: number;
    location: Location = new Location();
    accommodationId: number;
    capacity: number;
    name: string = "";
}


