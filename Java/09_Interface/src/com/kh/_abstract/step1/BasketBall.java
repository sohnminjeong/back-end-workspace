package com.kh._abstract.step1;

public class BasketBall extends Sports {
	
	
	public BasketBall(int numberOfPlayers) {
		super(numberOfPlayers);
		
	}
	// 오버라이딩 -> 일반 클래스 상속 때와 달리 추상 클래스는 반드시 자식들이 구현해야 함! (부모는 구현부가 없음)
	// 추상 메서드! -> 자식 클래스에서 무조건 재정의 해주어야 한다!!
	public void rule() {
		System.out.println("BasketBall의 선수의 수는 " + this.numberOfPlayers + "명, 공을 던져서 링에 넣어야한다.");
		// Sports에서 numberOfPlayer가 protected(동일 패키지까지 가능)이기 때문에 접근 가능
	}
	
}
