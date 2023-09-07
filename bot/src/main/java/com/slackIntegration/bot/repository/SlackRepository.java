package com.slackIntegration.bot.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.conversations.ConversationsCreateRequest;
import com.slack.api.methods.request.conversations.ConversationsInviteRequest;
import com.slack.api.methods.request.conversations.ConversationsJoinRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.methods.response.conversations.ConversationsCreateResponse;
import com.slack.api.methods.response.conversations.ConversationsInviteResponse;
import com.slack.api.methods.response.conversations.ConversationsJoinResponse;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SlackRepository {

	private final MethodsClient methods;

	public SlackRepository() {
		this.methods = SlackContext.getMethods("xoxb-5818656836292-5816320164770-V8T0MqkNSCLAX9zZUfJgy4ap");
	}

	public ConversationsCreateResponse createChannel(String name) throws IOException, SlackApiException {

		return methods.conversationsCreate(ConversationsCreateRequest.builder().name(name).build());
	}

	public ConversationsJoinResponse joinChannel(String channelId) throws IOException, SlackApiException {

		return methods.conversationsJoin(ConversationsJoinRequest.builder().channel(channelId).build());
	}

	public ConversationsInviteResponse inviteToChannel(String channelId, List<String> users)
			throws IOException, SlackApiException {

		return methods
				.conversationsInvite(ConversationsInviteRequest.builder().channel(channelId).users(users).build());
	}

	public ChatPostMessageResponse sendMessage(String channelId, String message) throws IOException, SlackApiException {

		return methods.chatPostMessage(ChatPostMessageRequest.builder().channel(channelId).text(message).build());
	}

}