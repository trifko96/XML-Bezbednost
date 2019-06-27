package xml.reservation_service.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String getUser() {
		String tmp = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		return tmp;
	} 
}
