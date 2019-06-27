package xml.accommodation_service.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String getCurrentUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		return username;
	}
}
