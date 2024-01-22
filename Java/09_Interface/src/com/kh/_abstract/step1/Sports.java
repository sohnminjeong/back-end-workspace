package com.kh._abstract.step1;

// 추상 메서드 쓸려면 해당 클래스도 추상 클래스여야 함!
public abstract class Sports {
	
	protected int numberOfPlayers;    // 참여하는 사람의 수 
	
	public Sports(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	//추상메서드 -> {}구현부 없음
	public abstract void rule();
	// 추상클래스! -> 부모에서는 구현을 하지 않고 자식들에게는 강제성을 부여함!(자식은 무조건 구현있어야 함)
//	{System.out.println("Sports의 선수의 수는 " + numberOfPlayers + "명, Sports규칙을 설명한다.");}
}
