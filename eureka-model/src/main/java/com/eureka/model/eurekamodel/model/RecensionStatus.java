package com.eureka.model.eurekamodel.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "recension_status")
public enum RecensionStatus {
	
	REJECTED, ACCEPTED, NOT_ACCEPTED

}
