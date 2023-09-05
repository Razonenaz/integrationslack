package com.slackIntegration.bot.repository;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;

public class SlackContext {

	public static MethodsClient getMethods(String token) {
		
		return Slack.getInstance().methods(token);
	}
}
