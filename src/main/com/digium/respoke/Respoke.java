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
		appId = args.get("appId");
		appSecret = args.get("appSecret");
		roleId = args.get("roleId");
		endpointId = args.get("endpointId");
	}
	
	public String getTokenId() {
		String tokenId = "";
			
		try {
			HttpResponse<JsonNode> tokenRespoke = Unirest.post("https://api.respoke.io/v1/tokens")
				.header("Content-type", "application/json")
				.header("App-Secret", appSecret)
				.body(new JSONObject()
					.put("appId", appId)
					.put("endpointId", endpointId)
					.put("roleId", roleId)
					.put("ttl", "3600")
					.toString())
				.asJson();
				
			tokenId = tokenRespoke.getBody().getObject().getString("tokenId");
		} 
		catch(Exception e) {
			System.out.println(e.toString());
		}
		finally {
			System.out.println(tokenId);
		}
		
		return tokenId;
	}
}