package agent.agent.soap_clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import agent.agent.model.GetMessageRequest;
import agent.agent.model.GetMessageResponse;
import agent.agent.model.MessageRequest;
import agent.agent.model.MessageResponse;
import agent.agent.model.Messagge;

public class MessaggeServiceSoapClient extends WebServiceGatewaySupport{

	private static final String SERVICE_URI = "http://localhost:8762/messagge/soap";
	
	public GetMessageResponse getMessagges() {
		GetMessageRequest request = new GetMessageRequest();
		GetMessageResponse response = (GetMessageResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
	
	public MessageResponse sendMessagge(Messagge m) {
		MessageRequest request = new MessageRequest();
		request.setMessage(m);
		MessageResponse response = (MessageResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
}
