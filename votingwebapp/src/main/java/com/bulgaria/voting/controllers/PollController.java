package com.bulgaria.voting.controllers;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bulgaria.voting.entities.BasePoll;
import com.bulgaria.voting.entities.PollOption;
import com.bulgaria.voting.entities.Poll;
import com.bulgaria.voting.entities.User;
import com.bulgaria.voting.entities.Vote;
import com.bulgaria.voting.repositories.PollOptionRepository;
import com.bulgaria.voting.repositories.PollRepository;
import com.bulgaria.voting.repositories.UserRepository;

@Controller
public class PollController {
	@Autowired
	PollRepository pollRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PollOptionRepository pollOptionRepository;

	@GetMapping("/")
	public String showFormLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		if(pollRepository.findBasePollByStatus("active").isEmpty()) {
		return "login";
		}
		return "login_election_day"; 
	}
	
	public void registerVote(User user, BasePoll poll,Model model){
		List<PollOption> pollOptionsList = new ArrayList<>();
		for (String pollOptionIds : poll.getPollOptions()) {
			PollOption pollOption = pollOptionRepository.findById(pollOptionIds).get();
			pollOptionsList.add(pollOption);
		}
		List<PollOption> sortedOptions = pollOptionsList.stream().sorted().collect(Collectors.toList());
		model.addAttribute("pollOptionList", sortedOptions);
		Poll outputPoll = new Poll(poll.getId(), poll.getPollName(), poll.getPollOwner(), sortedOptions,
				poll.getStatus(), poll.getVoterEgns());
		Vote vote = new Vote();
		vote.setPollId(poll.getId());
		model.addAttribute("user",user);
		model.addAttribute("vote", vote);
		model.addAttribute("poll", outputPoll);
	}

	@PostMapping("/login")
	public String sendLogin(@ModelAttribute("user") User user, Model model) {
		Optional<User> optionalUser = userRepository.findUserByEgnAndPersonalCode(user.getEgn(),
				user.getPersonalCode());
		if (optionalUser.isPresent()) {
			User activeUser = optionalUser.get();
			switch (activeUser.getRole()) {
			case "admin":
				return "index_admin";
			case "user":
				List<Optional<BasePoll>> optionalPoll = pollRepository.findBasePollByStatus("active");
				if (!optionalPoll.isEmpty()) {
					BasePoll poll = optionalPoll.get(0).get();
					if (poll.getVoterEgns().contains(user.getEgn())) {
						return "already_voted";
					} else {
						registerVote(user, poll, model);
						return "register_vote";
					}
				} else {
					return "index_user";
				}
			}
		}
		if(pollRepository.findBasePollByStatus("active").isEmpty()) {
		return "login_failed";
		}
		return "login_failed_election_day";
	}

	@GetMapping("/register")
	public String showForm(Model model) {
		BasePoll poll = new BasePoll();
		model.addAttribute("poll", poll);
		return "register_poll";
	}

	@PostMapping("/register")
	public String submitPoll(@ModelAttribute("poll") BasePoll poll, Model model) {
		try {
			if (poll.getPollName().isEmpty() || poll.getPollOptions().isEmpty() || poll.getPollOwner().isEmpty()) {
				return "register_failed";
			} else {
				List<String> pollOptionIds = new ArrayList<>();
				List<PollOption> pollOptionsList = new ArrayList<>();
				for (String pollOptionId : poll.getPollOptions()) {
					PollOption pollOption = new PollOption(pollOptionId);
					String id = pollOptionRepository.save(pollOption).getId();
					pollOptionIds.add(id);
					pollOptionsList.add(pollOption);
				}
				List<PollOption> sortedOptions = pollOptionsList.stream().sorted().collect(Collectors.toList());
				model.addAttribute("pollOptionList", sortedOptions);
				Poll outputPoll = new Poll(poll.getId(), poll.getPollName(), poll.getPollOwner(), sortedOptions,
						poll.getStatus(), poll.getVoterEgns());
				model.addAttribute("poll", outputPoll);
				poll.setPollOptions(pollOptionIds);
				String id = pollRepository.save(poll).getId();
				Vote vote = new Vote();
				vote.setPollId(id);
				model.addAttribute("vote", vote);
				return "poll_created";
			}
		} catch (Exception e) {
			return "register_failed";
		}
	}

	@GetMapping("polls/list")
	public String getPolls(Model model) {
		List<Poll> outputPolls = new ArrayList<>();
		List<BasePoll> polls = pollRepository.findAll();
		for (BasePoll poll : polls) {
			List<String> pollOptionsIds = poll.getPollOptions();
			List<PollOption> pollOptions = new ArrayList<>();
			for (String pollOptionId : pollOptionsIds) {
				PollOption pollOption = pollOptionRepository.findById(pollOptionId).get();
				pollOptions.add(pollOption);
			}
			outputPolls.add(new Poll(poll.getId(), poll.getPollName(), poll.getPollOwner(), pollOptions,
					poll.getStatus(), poll.getVoterEgns()));
		}
		model.addAttribute("polls", outputPolls);
		model.addAttribute("vote", new Vote());
		return "polls_list";
	}
	
	@GetMapping("info")
		public String getInfoPage() {
		return "no_active_poll_user";
	}
	
	@GetMapping("elections/history")
	public String getPollsHistory(Model model) {
		List<Poll> outputPolls = new ArrayList<>();
		List<Optional<BasePoll>> optionalPolls = pollRepository.findBasePollByStatus("inactive");
		List<BasePoll> inactivePolls = new ArrayList<>();
		for (Optional<BasePoll> optional : optionalPolls) {
			if(optional.isPresent()) {
				inactivePolls.add(optional.get());
			}
		}
		if(!inactivePolls.isEmpty()) {
			for (BasePoll poll : inactivePolls) {
			List<String> pollOptionsIds = poll.getPollOptions();
			List<PollOption> pollOptions = new ArrayList<>();
			for (String pollOptionId : pollOptionsIds) {
				PollOption pollOption = pollOptionRepository.findById(pollOptionId).get();
				pollOptions.add(pollOption);
			}
			outputPolls.add(new Poll(poll.getId(), poll.getPollName(), poll.getPollOwner(), pollOptions,
					poll.getStatus(), poll.getVoterEgns()));
		}
		model.addAttribute("polls", outputPolls);
		return "previous_polls";
		}
		else {
			return "no_previous_polls";
		}
	}

	@PostMapping("/startPoll")
	public String startPoll(@ModelAttribute Vote vote, Model model) {
		String id = vote.getPollId();
		BasePoll poll = pollRepository.findById(id).get();
		for (BasePoll p : pollRepository.findAll()) {
			if(p.getStatus().equals("active")){
			p.setStatus("inactive");
			pollRepository.save(p);
		}
		}
		poll.setStatus("active");
		pollRepository.save(poll);
		return "poll_activated";
	}

	@PostMapping("/deletePoll")
	public String deletePoll(@ModelAttribute Vote vote, Model model) {
		String id = vote.getPollId();
		BasePoll poll = pollRepository.findById(id).get();
		pollRepository.delete(poll);
		List<String> pollOptionIds = poll.getPollOptions();
		for (String optionId : pollOptionIds) {
			pollOptionRepository.deleteById(optionId);
		}
		return "index_admin";
	}
	
	@PostMapping("/deactivatePoll")
	public String deactivatePoll(@ModelAttribute Poll poll) {
		BasePoll basePoll = pollRepository.findById(poll.getPollId()).get();
		basePoll.setStatus("inactive");
		pollRepository.save(basePoll);
		return "end_voting";
	}

	@PostMapping("/polls/sendVote")
	public String getPollById(@ModelAttribute("vote") Vote vote,@ModelAttribute("user") User user, Model model) {
		if(vote.getPollOptionId().isEmpty()) {
			return null;
		}		
		Optional<BasePoll> optionalPoll = pollRepository.findById(vote.getPollId());
		if (optionalPoll.isPresent()) {
			BasePoll poll = optionalPoll.get();
			List<PollOption> pollOptions = new ArrayList<>();
			for (String pollOptionId : poll.getPollOptions()) {
				if (pollOptionId.equals(vote.getPollOptionId())) {
					PollOption pollOption = pollOptionRepository.findById(vote.getPollOptionId()).get();
					pollOptions.add(pollOption);
					int oldVotes = pollOption.getOptionVotes();
					pollOption.setOptionVotes(oldVotes + 1);
					pollOptionRepository.save(pollOption);
				}
			}
			poll.addVoterEgn(user.getEgn());
			pollRepository.save(poll);
			Poll outputPoll = new Poll(poll.getId(), poll.getPollName(), poll.getPollOwner(), pollOptions,
					poll.getStatus(), poll.getVoterEgns());
			model.addAttribute("poll", outputPoll);
		}
		return "vote_success";
	}

	@GetMapping("user/results")
	public String getPollResults(Model model) {
		List<Optional<BasePoll>> optionalPoll = pollRepository.findBasePollByStatus("active");
		if (!optionalPoll.isEmpty()) {
			BasePoll poll = optionalPoll.get(0).get();
			List<String> pollOptionsIds = poll.getPollOptions();
			List<PollOption> pollOptions = new ArrayList<>();
			for (String pollOptionId : pollOptionsIds) {
				PollOption pollOption = pollOptionRepository.findById(pollOptionId).get();
				pollOptions.add(pollOption);
			}
			List<PollOption> sortedOptions = pollOptions.stream().sorted().collect(Collectors.toList());
			Poll pollOutput = new Poll(poll.getId(), poll.getPollName(), poll.getPollOwner(), sortedOptions,
					poll.getStatus(), poll.getVoterEgns());
			model.addAttribute("poll", pollOutput);
			return "poll_results_user";
		}
		return "no_active_poll_user";
	}

	@GetMapping("admin/results")
	public String getPollResultsAdmin(Model model) {
		List<Optional<BasePoll>> optionalPoll = pollRepository.findBasePollByStatus("active");
		if (!optionalPoll.isEmpty()) {
			BasePoll poll = optionalPoll.get(0).get();
			List<String> pollOptionsIds = poll.getPollOptions();
			List<PollOption> pollOptions = new ArrayList<>();
			for (String pollOptionId : pollOptionsIds) {
				PollOption pollOption = pollOptionRepository.findById(pollOptionId).get();
				pollOptions.add(pollOption);
			}
			List<PollOption> sortedOptions = pollOptions.stream().sorted().collect(Collectors.toList());
			Poll pollOutput = new Poll(poll.getId(), poll.getPollName(), poll.getPollOwner(), sortedOptions,
					poll.getStatus(), poll.getVoterEgns());
			model.addAttribute("poll", pollOutput);
			return "poll_results";
		}
		return "no_active_poll";
	}

}
