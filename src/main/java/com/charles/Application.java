package com.charles;
import com.charles.bots.CharlesBot;
import com.charles.bots.ExampleBot;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Application {
	
	private static final String CLIENT_URL = "http://localhost:8081";

	public static void main(String[] args) throws UnirestException {
		
		Charles charles = new Charles(new ClientProxy(CLIENT_URL));
		CharlesBot bot = new ExampleBot();
		
		bot.setCharles(charles);
		bot.execute();		
	}

}
