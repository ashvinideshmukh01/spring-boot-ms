package my.microservices.arch.user.micro.service.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.microservices.arch.user.micro.service.dto.UserDTO;
import my.microservices.arch.user.micro.service.rest.model.CreateUserRequestModel;
import my.microservices.arch.user.micro.service.rest.model.CreateUserResponseModel;
import my.microservices.arch.user.micro.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/status/check")
	public String status() {
		return "Working....from "+env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel user) {
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDTO userDto = mapper.map(user, UserDTO.class);
		
		UserDTO createdUser = userService.createUser(userDto);
		
		//return new ResponseEntity<CreateUserResponseModel>(createdUser, HttpStatus.CREATED);
		
		return ResponseEntity.status(HttpStatus.CREATED)	
							 .header("location", "http://localhost:8082/user-micro-service/users/"+userDto.getUserId())
							 .header("anyHeader", "headerValue")
							 .body(mapper.map(userDto, CreateUserResponseModel.class));
	}

}
