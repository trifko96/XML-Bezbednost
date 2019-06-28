package xml.messagge_service.endpoint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eureka.model.eurekamodel.model.GetMessageRequest;
import com.eureka.model.eurekamodel.model.GetMessageResponse;
import com.eureka.model.eurekamodel.model.MessageRequest;
import com.eureka.model.eurekamodel.model.MessageResponse;
import com.eureka.model.eurekamodel.model.Messagge;

import xml.messagge_service.service.MessaggeService;

@Endpoint
public class MessaggeEndpoint {

	@Autowired
	MessaggeService service;
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "get_message_request")
	public GetMessageResponse getMessagges(@RequestPayload GetMessageRequest request) {
		ArrayList<Messagge> messagges = (ArrayList<Messagge>) service.getAllMessagges();
		GetMessageResponse response = new GetMessageResponse();
		response.setMessagge(messagges);
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "message_request")
	public MessageResponse sendMessagge(@RequestPayload MessageRequest request) {
		Messagge m = request.getMessage();
		service.save(m);
		
		MessageResponse response = new MessageResponse();
		response.setMessaggeId(m.getId());
		return response;
	}
}
