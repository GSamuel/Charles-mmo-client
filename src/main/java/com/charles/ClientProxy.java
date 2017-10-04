package com.charles;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ClientProxy {
	
	private String url;
	
	public ClientProxy(String url) {
		this.url = url;
	}
	
	public void sendAction(String action) {

		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.post(url)
					  .header("accept", "application/json")
					  .body("{\"action\":\"" + action + "\"}").asString();
		} catch (UnirestException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println(jsonResponse.getBody());
	}
	
	public JSONObject getStatus() {

		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get(url + "/status")
				.header("accept", "application/json")
				.asJson();
		} catch (UnirestException e) {
			throw new RuntimeException(e);
		}
		
		return jsonResponse.getBody().getObject();
	}
	
	public boolean north() {
		return getStatus().getString("facing").equals("N");
	}
	
	public boolean inFrontOfWall() {
		return getStatus().getBoolean("inFrontOfWall");
	}
	
	public boolean onBall() {
		return getStatus().getBoolean("onBall");
	}
	
}
