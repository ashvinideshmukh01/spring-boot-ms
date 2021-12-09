package my.microservices.arch.user.micro.service.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.microservices.arch.user.micro.service.UsersRepository;
import my.microservices.arch.user.micro.service.dto.UserDTO;
import my.microservices.arch.user.micro.service.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService{
	
	private UsersRepository userRepo;	

	@Autowired
	public UserServiceImpl(UsersRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDTO createUser(UserDTO usersDetails) {
		
		usersDetails.setUserId(UUID.randomUUID().toString());
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = mapper.map(usersDetails, UserEntity.class);		
		
		userEntity.setEncryptedPassword("test");
		UserEntity createdUserDetails = userRepo.save(userEntity);
		
		
		return mapper.map(createdUserDetails, UserDTO.class);
	}

}
