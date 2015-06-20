package com.digium.respoke;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

/*import org.json.*;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;*/

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Options;
import com.mashape.unirest.request.GetRequest;

public class Respoke {
	@Getter @Setter
	private String appId;
	
	@Getter @Setter
	private String appSecret;
	
	@Getter @Setter
	private String roleId;
	
	@Getter @Setter
	private String endpointId;
	
	@Setter
	private String tokenId;
	
	
	public Respoke() {
		
	}
	
	public Respoke(String appId, String appSecret, String roleId, String endpointId) {
		this.appId = appId;
		this.appSecret = appSecret;
		this.roleId = roleId;
		this.endpointId = endpointId;
	}
	
	public Respoke(HashMap<String, String> args) {
		this.appId = args.get("appId");
		this.appSecret = args.get("appSecret");
		this.roleId = args.get("roleId");
		this.endpointId = args.get("endpointId");
	}
	
	public String getTokenId() {
		String token = "";
			
		try {
			HttpResponse<JsonNode> tokenRespoke = Unirest.post("http://httpbin.org/post")
				.header("accept", "application/json")
				.queryString("apiKey", "123")
				.field("parameter", "value")
				.field("foo", "bar")
				.asJson();
				
			token = tokenRespoke.getBody().toString();
			
			System.out.println(token);
		} 
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return token;
		
		/*return Unirest.post("http://httpbin.org/post")
			  .queryString("name", "Mark")
			  .field("last", "Polo")
			  .asString();*/
		
		/*HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
			  .header("accept", "application/json")
			  .field("param1", "value1")
			  .field("param2","bye")
			  .asJson();

		return jsonResponse.getBody().toString();*/
		
		/*return Unirest.post("http://httpbin.org/post")
					  .queryString("name", "Mark")
					  .field("last", "Polo")
					  .asJson().getBody().toString();*/
	}
}