package com.slackIntegration.bot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slackIntegration.bot.service.SlackService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/slack/bot")
@RequiredArgsConstructor
public class BotController {
	private final SlackService service;

	@PostMapping("/channel/create/{name}")
	public String createChannel(@PathVariable String name) {

		return service.createChannel(name);
	}

	@PostMapping("/channel/join/{id}")
	public String joinChannel(@PathVariable String id) {

		return service.joinChannel(id);
	}

	@PostMapping("/channel/invite/{id}/{member}")
	public String inviteToChannel(@PathVariable String id, @PathVariable String member) {

		return service.inviteToChannel(id, member);
	}

	@PostMapping("/channel/send/{id}/{message}")
	public String sendMessage(@PathVariable String id, @PathVariable String message) {

		return service.sendMessage(id, message);
	}
}
