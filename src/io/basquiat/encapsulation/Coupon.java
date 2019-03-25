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
	 * 쿠폰 고유 넘버
	 */
	private String couponId;
	
	/**
	 * 쿠폰을 제공하는 통신사
	 */
	private String mobileCarrier;
	
	/**
	 * 쿠폰을 제공하는 브랜드
	 */
	private String brand;
	
	/**
	 * 쿠폰 유효 기간
	 */
	private long expiryDate;
	
	/**
	 * 해당 쿠폰이 유효한지 아닌지 알려주는 기능
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
