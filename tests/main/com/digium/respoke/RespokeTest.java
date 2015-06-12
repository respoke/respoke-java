import com.digium.respoke.*;

import java.util.HashMap;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RespokeTest {
	private Respoke client;
	
	@Before
	public void instantiate() {
		
	}
	
	@Test
	public void CreateClientWithOutArgs() {
		client = new Respoke();
		assertEquals((client instanceof Respoke), true);
	}
	
	@Test
	public void CreateClientWithArgs() {
		client = new Respoke("c10a2075-3f3d-466f-82f9-d2285e64c5d4", 
							 "eb327e57-e766-49de-b801-ef612a70509e",
							 "371F82D1-E4CE-4BB0-B2BB-79EA3497FC4F",
							 "spock@enterprise.com");
		
		assertEquals((client instanceof Respoke), true);
		assertEquals(client.getAppId(), "c10a2075-3f3d-466f-82f9-d2285e64c5d4");
		assertEquals(client.getAppSecret(), "eb327e57-e766-49de-b801-ef612a70509e");
		assertEquals(client.getRoleId(), "371F82D1-E4CE-4BB0-B2BB-79EA3497FC4F");
		assertEquals(client.getEndpointId(), "spock@enterprise.com");
	}
	
	@Test
	public void CreateClientWithNamedArgs() {
		client = new Respoke(new HashMap<String, String>() {{
			put("appId", "c10a2075-3f3d-466f-82f9-d2285e64c5d4");
			put("appSecret", "eb327e57-e766-49de-b801-ef612a70509e");
			put("roleId", "371F82D1-E4CE-4BB0-B2BB-79EA3497FC4F");
			put("endpointId", "spock@enterprise.com");
		}});
		
		assertEquals((client instanceof Respoke), true);
		assertEquals(client.getAppId(), "c10a2075-3f3d-466f-82f9-d2285e64c5d4");
		assertEquals(client.getAppSecret(), "eb327e57-e766-49de-b801-ef612a70509e");
		assertEquals(client.getRoleId(), "371F82D1-E4CE-4BB0-B2BB-79EA3497FC4F");
		assertEquals(client.getEndpointId(), "spock@enterprise.com");
	}
}