package com.bulgaria.voting.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bulgaria.voting.entities.PollOption;

public interface PollOptionRepository extends MongoRepository<PollOption, String> {

}
