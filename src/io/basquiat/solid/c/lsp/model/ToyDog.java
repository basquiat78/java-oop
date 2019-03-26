package io.basquiat.solid.c.lsp.model;

public class ToyDog extends Dog {

	@Override
	public void cry() {
		System.out.println("강아지 장난감이 멍멍~ 하고 울고 있습니다.");
	}
	
	@Override
	public void eat() {
		System.out.println("강아지 장난감은 먹이를 먹을 수 없습니다.");
	}
	
	@Override
	public void run() {
		System.out.println("강아지 장난감은 뛰어 다닐 수 없습니다.");
	}
	
}
