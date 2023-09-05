package com.slackIntegration.bot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slackIntegration.bot.service.SlackService;

@RestController
@RequestMapping("/slackBot")
public class BotController {

	@Autowired
	SlackService service;

	@PostMapping("/createChannel/{name}")
	public String createChannel(@PathVariable String name) {
		
		return service.createChannel(name);
	}

	@PostMapping("/joinChannel/{channelId}")
	public String joinChannel(@PathVariable String channelId) {
		return service.joinChannel(channelId);
	}
	
	@PostMapping("/inviteToChannel/{channelId}/{member}")
	public String inviteToChannel(@PathVariable String channelId, @PathVariable String member) {
		
		return service.inviteToChannel(channelId, member);
	}
	
	@PostMapping("/sendMessage/{channelId}/{message}")
	public String sendMessage(@PathVariable String channelId, @PathVariable String message) {
		return service.sendMessage(channelId, message);
	}
}
