package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public class NoteBook2019 implements NoteBook, TouchableScreen {

	@Override
	public void display() {
		System.out.println("2019���� �ֽ��� ���÷���");
	}

	@Override
	public void keyboard() {
		System.out.println("2019���� �ֽ��� ������ Ű����");
	}

	@Override
	public void touchScreen() {
		System.out.println("����� ��ġ��ũ�� ����!");		
	}
	
}
