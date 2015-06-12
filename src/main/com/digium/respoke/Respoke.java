package com.digium.respoke;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

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
		return tokenId;
	}
}