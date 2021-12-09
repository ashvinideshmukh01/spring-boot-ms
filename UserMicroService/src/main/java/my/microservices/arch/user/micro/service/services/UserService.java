package my.microservices.arch.user.micro.service.services;

import my.microservices.arch.user.micro.service.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO usersDetails);

}
