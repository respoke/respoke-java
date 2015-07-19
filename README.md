# Respoke Java Library [![Build Status](https://travis-ci.org/respoke/respoke-java.svg)](https://travis-ci.org/respoke/respoke-java)

Respoke Java is the officially supported Java library for [Respoke](https://respoke.io). 

With Respoke, you can add live voice, video, text and data features to your website or mobile app. Check out our [Guides](https://docs.respoke.io/server/java/getting-started.html) to get started using Respoke and Respoke Java now.

Please validate you have Java 7 or greater installed.

## Installation

Install [Respoke's Java Library](http://search.maven.org/#search%7Cga%7C1%7Crespoke) to your project using [Maven](http://search.maven.org/).

    <dependency>
        <groupId>com.digium.respoke</groupId>
        <artifactId>respoke-java</artifactId>
        <version>1.0.0</version>
    </dependency>

Install Respoke's Java Library to your project using [Gradle](https://gradle.org/).

    dependencies {	
    	compile "com.digium.respoke:respoke-java:1.0.0"
    }
    
## Running the library

To use the library, sign up for a FREE [Respoke account](https://portal.respoke.io/#/signup).

    import com.digium.respoke.*;
    
	Respoke client = new Respoke(new HashMap<String, String>() {{
		put("appId", "APP_ID");
		put("appSecret", "APP_SECRET");
		put("roleId", "ROLE_ID");
		put("endpointId", "USER_NAME");
	}});
    
    String tokenId = client.getTokenId();
    
Return this `tokenId` to your front-end and pass it to the `token` property when connecting to Respoke.
    
## Building from source && Running Tests

To build the project from source.

    gradle build
    
To run the tests from source.
    
    gradle check
    
To upload to the maven central respository.

    gradle -b maven.gradle
    gradle -b maven.gradle uploadArchives
    
Then close and release the library.

http://central.sonatype.org/pages/releasing-the-deployment.html

## Contributing

If you wish to submit an issue use the [issue tracker].

[issue tracker]: https://github.com/respoke/respoke-java/issues

1. Fork it ( https://github.com/[my-github-username]/respoke-java/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -a -m 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request

## License

This source code is licensed under The MIT License.