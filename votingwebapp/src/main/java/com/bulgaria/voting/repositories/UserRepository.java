package com.bulgaria.voting.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bulgaria.voting.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
	public Optional<User> findUserByEgnAndPersonalCode(String egn, String personalCode);
	
}
