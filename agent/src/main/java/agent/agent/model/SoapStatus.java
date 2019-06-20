package agent.agent.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "soap_status")
public enum SoapStatus {

	SUCCESS, ERROR;
}
