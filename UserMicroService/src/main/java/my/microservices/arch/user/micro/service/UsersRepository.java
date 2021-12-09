package my.microservices.arch.user.micro.service;

import org.springframework.data.jpa.repository.JpaRepository;

import my.microservices.arch.user.micro.service.entity.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}
