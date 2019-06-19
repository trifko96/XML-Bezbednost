package com.eureka.model.eurekamodel.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "user_status")
public enum UserStatus {
	
	BLOCKED, ACTIVATED;

}
