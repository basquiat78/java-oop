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
		System.out.println("�������� �۸�~ �ϰ� ��� �ֽ��ϴ�.");
	}

	@Override
	public void eat() {
		System.out.println("�������� ���̸� ���ְ� �ȳ�!");
	}

	public void run() {
		isJoyful = true;
		System.out.println("�������� �پ� ��ϴ�.");
	}
}
