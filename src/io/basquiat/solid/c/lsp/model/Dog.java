package io.basquiat.solid.c.lsp.model;

import lombok.Getter;

/**
 * 
 * created by basquiat
 *
 */
public class Dog extends Animal {

	@Getter
	private boolean isJoyful;

	@Override
	public void cry() {
		System.out.println("강아지가 멍멍~ 하고 울고 있습니다.");
	}

	@Override
	public void eat() {
		System.out.println("강아지가 먹이를 맛있게 냠냠!");
	}

	public void run() {
		isJoyful = true;
		System.out.println("강아지가 뛰어 놉니다.");
	}
}
