package shouty;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServerHooks {

	// TODO: Disable this in domain mode
	private final ShoutyServer server = new ShoutyServer(9988);

	@Before
	public void startServer() throws Exception {
		server.start();
	}
	
	@After
	public void stopServer() throws Exception {
		server.stop();
	}
}
