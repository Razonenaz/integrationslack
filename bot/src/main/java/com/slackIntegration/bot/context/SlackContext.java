package com.slackIntegration.bot.context;

import org.springframework.stereotype.Component;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;

@Component
public class SlackContext {

	public static MethodsClient getMethods(String token) {

		return Slack.getInstance().methods(token);
	}
}
