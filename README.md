# Respoke Java Library 

Respoke Java is the officially supported Java library for [Respoke](https://respoke.io). 

With Respoke, you can add live voice, video, text and data features to your website or mobile app. Check out our [Guides](https://docs.respoke.io/server/php/getting-started.html) to get started using Respoke and Respoke Java now.

Please validate you have Java 7 or greater installed.

## Installation

TODO
    
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

    TODO
    
## Building from source

    gradle build

## Running the tests

    gradle test

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