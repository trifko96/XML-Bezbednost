package agent.agent.soap_config;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender.RemoveSoapHeadersInterceptor;

import agent.agent.soap_clients.AccommodationServiceSoapClient;
import agent.agent.soap_clients.AuthServiceSoapClient;
import agent.agent.soap_clients.MessaggeServiceSoapClient;
import agent.agent.soap_clients.ReservationServiceSoapClient;

@Configuration
public class SoapClientsConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("agent.agent.model");
		return marshaller;
	}

	@Bean
	public AccommodationServiceSoapClient accomodationServiceSoapClient(Jaxb2Marshaller marshaller) {
		AccommodationServiceSoapClient client = new AccommodationServiceSoapClient();
		ClientInterceptor[] interceptors = new ClientInterceptor[]{securityRequestInterceptor()};
	    client.setInterceptors(interceptors);
		client.setDefaultUri("http://localhost:8762/accomodation/soap");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.getWebServiceTemplate().setCheckConnectionForFault(true);
		return client;
	}
	
	@Bean
	public ReservationServiceSoapClient reservationServiceSoapClient(Jaxb2Marshaller marshaller) {
		ReservationServiceSoapClient client = new ReservationServiceSoapClient();
		ClientInterceptor[] interceptors = new ClientInterceptor[]{securityRequestInterceptor()};
		client.setInterceptors(interceptors);
		client.setDefaultUri("http://localhost:8762/reservation/soap");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.getWebServiceTemplate().setCheckConnectionForFault(true);
		return client;
	}
	
	@Bean
	public MessaggeServiceSoapClient messagesServiceSoapClient(Jaxb2Marshaller marshaller) {
		MessaggeServiceSoapClient client = new MessaggeServiceSoapClient();
		ClientInterceptor[] interceptors = new ClientInterceptor[]{securityRequestInterceptor()};
		client.setInterceptors(interceptors);
		client.setDefaultUri("http://localhost:8762/messagge/soap");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.getWebServiceTemplate().setCheckConnectionForFault(true);
		return client;
	}
	
	@Bean
	public AuthServiceSoapClient authServiceSoapClient(Jaxb2Marshaller marshaller) {
		AuthServiceSoapClient client = new AuthServiceSoapClient();
		ClientInterceptor[] interceptors = new ClientInterceptor[]{securityRequestInterceptor()};
		client.setInterceptors(interceptors);
		client.setDefaultUri("http://localhost:8762/auth/soap");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		//client.getWebServiceTemplate().setCheckConnectionForFault(true);
		return client;
	}
	
	@Bean 
	public SecurityRequestInterceptor securityRequestInterceptor() {
		return new SecurityRequestInterceptor();
	}
	
	@Bean
	  public HttpComponentsMessageSender httpComponentsMessageSender() throws Exception {
	    HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
	    httpComponentsMessageSender.setHttpClient(httpClient());

	    return httpComponentsMessageSender;
	  }

	  public HttpClient httpClient() throws Exception {
	    return HttpClientBuilder.create().setSSLSocketFactory(sslConnectionSocketFactory())
	        .addInterceptorFirst(new RemoveSoapHeadersInterceptor()).build();
	  }

	  public SSLConnectionSocketFactory sslConnectionSocketFactory() throws Exception {
	    // NoopHostnameVerifier essentially turns hostname verification off as otherwise following error
	    // is thrown: java.security.cert.CertificateException: No name matching localhost found
	    return new SSLConnectionSocketFactory(sslContext(), NoopHostnameVerifier.INSTANCE);
	  }

	  public SSLContext sslContext() throws Exception {
	    return SSLContextBuilder.create()
	        .loadTrustMaterial( new ClassPathResource("agent.jks").getFile(), "password".toCharArray()).build();
	  }
}
