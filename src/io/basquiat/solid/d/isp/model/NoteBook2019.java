package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public class NoteBook2019 implements NoteBook, TouchableScreen {

	@Override
	public void display() {
		System.out.println("2019년형 최신형 디스플레이");
	}

	@Override
	public void keyboard() {
		System.out.println("2019년형 최신형 감도의 키보드");
	}

	@Override
	public void touchScreen() {
		System.out.println("우아한 터치스크린 장착!");		
	}
	
}
