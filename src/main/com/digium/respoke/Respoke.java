package com.digium.respoke;

import org.apache.commons.lang3.StringUtils;

public class Respoke {
	private String tokenId;
	
	public Respoke() {
		System.out.println("Hello World!");
		
		tokenId = new String();
	}
	
	public String getTokenId() {
		return tokenId;
	}
}