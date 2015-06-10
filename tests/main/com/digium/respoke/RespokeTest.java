import com.digium.respoke.*;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RespokeTest {
	private Respoke client;
	
	@Before
	public void initObjects() {
		client = new Respoke();
	}
	
	@Test
	public void testCreateClientWithOutArgs() {
		assertEquals(true, (client instanceof Respoke));
	}
}