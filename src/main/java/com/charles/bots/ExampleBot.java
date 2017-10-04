package com.charles.bots;
import com.charles.Charles;

public class ExampleBot implements CharlesBot {

	private Charles charles;

	@Override
	public void setCharles(Charles charles) {
		this.charles = charles;
	}
	
	private void steps(int n) {
		for(int i = 0; i < n ; i++) {
			charles.step();
		}
	}
	
	@Override
	public void execute() {
		while(true) {
			if(charles.inFrontOfWall()) {
				charles.turnRight();
			}
			charles.step();
			if(!charles.onBall()) {
				charles.putBall();
			} else {
				charles.getBall();
			}
			
		}
	}

}
