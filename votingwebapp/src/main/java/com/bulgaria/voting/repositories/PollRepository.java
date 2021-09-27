package com.bulgaria.voting.repositories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bulgaria.voting.entities.BasePoll;

public interface PollRepository extends MongoRepository<BasePoll, String>{
	public List<Optional<BasePoll>> findBasePollByStatus(String status);
}
