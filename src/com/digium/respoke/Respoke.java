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

import java.net.URI;
import java.util.HashMap;
import java.lang.Package;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

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

    @Getter @Setter
    private String baseUri;

    @Setter
    private String tokenId;

    private String getSDKHeader() {
        Package pkg = getClass().getPackage();
        String javaVersion = String.format("Java/%s", System.getProperty("java.version"));
        String osVersion = String.format("%s %s",
                System.getProperty("os.name"), System.getProperty("os.version"));
        String packageVersion = String.format("%s/%s", pkg.getImplementationTitle(),
                pkg.getImplementationVersion());

        return String.format("%s (%s) %s", packageVersion, osVersion, javaVersion);
    }

    /**
     * Respoke Constructor
     */
    public Respoke() {

    }

    /**
     * Respoke Constructor
     *
     * @param appId The App Id generated when you create a Respoke app.
     * @param appSecret The App Secret generated when you create a Respoke app.
     * @param roleId The Role Id you create so your App handle authorization.
     * @param endpointId The username for the user being authenticated.
     */
    public Respoke(String appId, String appSecret, String roleId, String endpointId) {
        this(appId, appSecret, roleId, endpointId, null);
    }

    /**
     * Respoke Constructor
     *
     * @param appId The App Id generated when you create a Respoke app.
     * @param appSecret The App Secret generated when you create a Respoke app.
     * @param roleId The Role Id you create so your App handle authorization.
     * @param endpointId The username for the user being authenticated.
     * @param baseUri The base uri of the Respoke REST API. Must include the api version in uri.
     *     Defaults to "https://api.respoke.io".
     */
    public Respoke(String appId, String appSecret, String roleId, String endpointId, String baseUri) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.roleId = roleId;
        this.endpointId = endpointId;
        this.baseUri = baseUri;

        if (this.baseUri == null) {
            this.baseUri = "https://api.respoke.io";
        }
    }

    /**
     * Respoke Constructor
     *
     * @param properties A HashMap containing values for appId, appSecret, roleId and endpointId.
     *
     * <pre>
     * {@code
     *   Respoke client = new Respoke(new HashMap<String, String>() {{
     *      put("appId", "c10a2075-3f3d-466f-82f9-d2285e64c5d4");
     *      put("appSecret", "eb327e57-e766-49de-b801-ef612a70509e");
     *      put("roleId", "371F82D1-E4CE-4BB0-B2BB-79EA3497FC4F");
     *      put("endpointId", "spock@enterprise.com");
     *      put("baseUri", "https://api.respoke.io");
     *   }});
     * }
     * </pre>
     */
    public Respoke(HashMap<String, String> properties) {
        appId = properties.get("appId");
        appSecret = properties.get("appSecret");
        roleId = properties.get("roleId");
        endpointId = properties.get("endpointId");
        baseUri = properties.get("baseUri");

        if (baseUri == null) {
            baseUri = "https://api.respoke.io";
        }
    }

    /**
     * Create a temporary tokenId to use when connecting to Respoke.
     *
     * @return tokenId The temporary tokenId returned from Repoke.
     */
    public String getTokenId() {
        String tokenId = "";
        String uri = URI.create(baseUri).resolve("/v1/tokens").toString();

        try {
            HttpResponse<JsonNode> tokenRespoke = Unirest.post(uri)
                .header("Content-type", "application/json")
                .header("App-Secret", appSecret)
                .header("Respoke-SDK", this.getSDKHeader())
                .body(new JSONObject()
                        .put("appId", appId)
                        .put("endpointId", endpointId)
                        .put("roleId", roleId)
                        .put("ttl", "3600")
                        .toString())
                .asJson();

            tokenId = tokenRespoke.getBody().getObject().getString("tokenId");
        } catch(UnirestException e) {

        }

        return tokenId;
    }
}
