package agent.agent.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "reservation_status")
public enum ReservationStatus {

	APPROVED, PENDING;
}
