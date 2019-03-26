package io.basquiat.solid.c.lsp.model;

/**
 * 
 * created by basquiat
 *
 */
public class Cat extends Animal {

	@Override
	public void cry() {
		System.out.println("고양이가 냐옹~ 하고 울고 있습니다.");
	}

	@Override
	public void eat() {
		System.out.println("고양이가 먹이를 맛있게 냠냠!");
	}

}
