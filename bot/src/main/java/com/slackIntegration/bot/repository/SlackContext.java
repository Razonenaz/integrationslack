package com.slackIntegration.bot.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;

@Configuration
@Component
public class SlackContext {

	public static MethodsClient getMethods(String token) {

		return Slack.getInstance().methods(token);
	}
}
