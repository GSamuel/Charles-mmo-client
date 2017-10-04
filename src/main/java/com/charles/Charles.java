package com.charles;

public class Charles {

	private ClientProxy clientProxy;
	
	public Charles(ClientProxy clientProxy) {
		this.clientProxy = clientProxy;
	}
	
	public void step() {
		pause();
		clientProxy.sendAction("STEP");
	}
	
	public void turnLeft() {
		pause();
		clientProxy.sendAction("TURN_LEFT");
	}
	
	public void turnRight() {
		pause();
		clientProxy.sendAction("TURN_RIGHT");
	}
	
	public void putBall() {
		pause();
		clientProxy.sendAction("PUT_BALL");
	}
	
	public void getBall() {
		pause();
		clientProxy.sendAction("GET_BALL");
	}
	
	public boolean onBall() {
		pause();
		return clientProxy.onBall();
	}
	
	public boolean inFrontOfWall() {
		pause();
		return clientProxy.inFrontOfWall();
	}
	
	public boolean north() {
		pause();
		return clientProxy.north();
	}
	
	private void pause() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
	}
}
