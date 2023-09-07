package com.slackIntegration.bot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.conversations.ConversationsCreateRequest;
import com.slack.api.methods.request.conversations.ConversationsInviteRequest;
import com.slack.api.methods.request.conversations.ConversationsJoinRequest;
import com.slackIntegration.bot.context.SlackContext;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SlackService {
	private final MethodsClient methods;

	public SlackService() {
		this.methods = SlackContext.getMethods("xoxb-5818656836292-5816320164770-V8T0MqkNSCLAX9zZUfJgy4ap");
	}

	public String createChannel(String name) {
		try {
			methods.conversationsCreate(ConversationsCreateRequest.builder().name(name).build());

			return "Channel was created";
		} catch (IOException | SlackApiException e) {
			e.printStackTrace();

			return "There was mistake of some kind";
		}
	}

	public String joinChannel(String channelId) {
		try {
			methods.conversationsJoin(ConversationsJoinRequest.builder().channel(channelId).build());

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
			methods.conversationsInvite(ConversationsInviteRequest.builder().channel(channelId).users(members).build());

			return "Members were added to channel";
		} catch (IOException | SlackApiException e) {
			e.printStackTrace();

			return "There was mistake of some kind";
		}
	}

	public String sendMessage(String channelId, String message) {
		try {
			methods.chatPostMessage(ChatPostMessageRequest.builder().channel(channelId).text(message).build());

			return "Message was sent";
		} catch (IOException | SlackApiException e) {
			e.printStackTrace();

			return "There was mistake of some kind";
		}
	}

}
