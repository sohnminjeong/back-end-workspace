package com.kh._interface.step2;

public interface RemoteControl extends Searchable, Volume{
	// 다른 인터페이스를 상속 받는다!(다수 상속받기 가능)
	
	void turnOn();
	void turnOff();
	
}
