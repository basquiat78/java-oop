package io.basquiat.encapsulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * created by basquiat
 *
 */
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Coupon {

	/**
	 * ���� ���� �ѹ�
	 */
	private String couponId;
	
	/**
	 * ������ �����ϴ� ��Ż�
	 */
	private String mobileCarrier;
	
	/**
	 * ������ �����ϴ� �귣��
	 */
	private String brand;
	
	/**
	 * ���� ��ȿ �Ⱓ
	 */
	private long expiryDate;
	
	/**
	 * �ش� ������ ��ȿ���� �ƴ��� �˷��ִ� ���
	 * @return boolean
	 */
	public boolean isExpiryDate() {
		boolean isExpiryDate = true;
		
		if(this.getExpiryDate() != 0 && this.getExpiryDate() < 1000000000) {
			isExpiryDate = true;
		} else {
			isExpiryDate = false;
		}
		
		return isExpiryDate;
	}
}
