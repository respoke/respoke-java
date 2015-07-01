/**
 * Copyright 2015, Digium, Inc.
 * All rights reserved.
 *
 * This source code is licensed under The MIT License found in the
 * LICENSE file in the root directory of this source tree.
 *
 * For all details and documentation:  https://www.respoke.io
 */
package com.digium.respoke;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

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

/**
 * The top-level wrapper around the Respoke REST API.
 */
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
	
	
	/**
	 *  Respoke Constructor
	 *
	 */
	public Respoke() {
		
	}
	
	/**
	 *  Respoke Constructor
	 *
	 *  @param appId The App Id generated when you create a Respoke app.
	 *  @param appSecret The App Secret generated when you create a Respoke app.
	 *  @param roleId The Role Id you create so your App handle authorization.
	 *  @param endpointId The username for the user being authenticated.
	 */
	public Respoke(String appId, String appSecret, String roleId, String endpointId) {
		this.appId = appId;
		this.appSecret = appSecret;
		this.roleId = roleId;
		this.endpointId = endpointId;
	}
	
	/**
	 *  Respoke Constructor
	 *
	 *  @param properties A HashMap containing values for appId, appSecret, roleId and endpointId.
	 *
	 * <pre>
	 * {@code
	 *   Respoke client = new Respoke(new HashMap<String, String>() {{  
	 *      put("appId", "c10a2075-3f3d-466f-82f9-d2285e64c5d4");
	 *      put("appSecret", "eb327e57-e766-49de-b801-ef612a70509e");
	 *      put("roleId", "371F82D1-E4CE-4BB0-B2BB-79EA3497FC4F");
	 *      put("endpointId", "spock@enterprise.com");
	 *   }});
	 * }
	 * </pre>
	 */
	public Respoke(HashMap<String, String> properties) {
		appId = properties.get("appId");
		appSecret = properties.get("appSecret");
		roleId = properties.get("roleId");
		endpointId = properties.get("endpointId");
	}
	
	/**
	 *  Create a temporary tokenId to use when connecting to Respoke.
	 *
	 *  @return tokenId The temporary tokenId returned from Repoke.
	 */
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
		catch(UnirestException e) {

		}
		
		return tokenId;
	}
}