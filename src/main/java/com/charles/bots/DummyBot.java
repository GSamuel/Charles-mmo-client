package com.charles.bots;

import com.charles.Charles;

public class DummyBot implements CharlesBot {
	
	private Charles charles;

	@Override
	public void execute() {
		//Do Nothing
	}

	@Override
	public void setCharles(Charles charles) {
		this.charles = charles;
	}

}
