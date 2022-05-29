package Gateways;

public class GatewayContext {

	private GatewayStratgy gateway;

	public GatewayContext(GatewayStratgy gateway) {
		this.gateway = gateway;
	}

	public void executeStrategy(Object message, String user) {
		gateway.sendMessage(message, user);
	}
}
