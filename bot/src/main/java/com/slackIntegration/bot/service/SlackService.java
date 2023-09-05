package com.slackIntegration.bot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slack.api.methods.SlackApiException;
import com.slackIntegration.bot.repository.SlackRepository;

@Service
public class SlackService {

	@Autowired
	SlackRepository repository;

	public String createChannel(String name) {
		try {
			repository.createChannel(name);
			
			return "Channel was created";
		} catch (IOException | SlackApiException e) {
			e.printStackTrace();
			
			return "There was mistake of some kind";
		}
	}

	public String joinChannel(String channelId) {
		try {
			repository.joinChannel(channelId);
			
			return "Bot joined channel";
		} catch (IOException | SlackApiException e) {
			e.printStackTrace();
			
			return "There was mistake of some kind";
		}
	}

	public String inviteToChannel(String channelId, String member) {
		try {
			List<String> members = new ArrayList<String>();
			members.add(member);
			repository.inviteToChannel(channelId, members);
			
			return "Members were added to channel";
		} catch (IOException | SlackApiException e) {
			e.printStackTrace();
			
			return "There was mistake of some kind";
		}
	}
	
	  public String sendMessage(String channelId, String message) {
		  try {
			repository.sendMessage(channelId, message);
			
			return "Message was sent";
		} catch (IOException | SlackApiException e) {
			e.printStackTrace();
			
			return "There was mistake of some kind";
		}
	  }
	 
}
