package com.kh._abstract.step1;

public class FootBall extends Sports {
	
	public FootBall(int numberOfPlayers) {
		super(numberOfPlayers);
	
	}
	// 오버라이딩
	public void rule() {
		System.out.println("FootBall의 선수의 수는 " + this.numberOfPlayers + "명, 손이 아닌 발로 공을 차야한다.");
		// Sports에서 numberOfPlayer가 protected(동일 패키지까지 가능)이기 때문에 접근 가능
	}
}
