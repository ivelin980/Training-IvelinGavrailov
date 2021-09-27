package com.bulgaria.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bulgaria.voting.repositories.PollRepository;

@SpringBootApplication
public class VotingwebappApplication{

	@Autowired
	PollRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(VotingwebappApplication.class, args);
	}
}
