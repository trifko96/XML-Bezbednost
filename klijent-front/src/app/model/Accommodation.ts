import { Location } from './Location';
import { AccommodationType } from './AccommodationType';
import { AccommodationService } from './AccommodationService';

export class Accommodation{
    accommodationType: AccommodationType;
    description: String = "";
    accommodationService: AccommodationService;
    category: number;
    location: Location;
    accommodationId: number;
    capacity: number;
    name: String = "";
}