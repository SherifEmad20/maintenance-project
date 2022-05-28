package Gateways;

public class gatewayContext {

	private gatewayStratgy gateway;

	public gatewayContext(gatewayStratgy gateway) {
		this.gateway = gateway;
	}

	public void executeStrategy(Object message, String user) {
		gateway.sendMessage(message, user);
	}
}
