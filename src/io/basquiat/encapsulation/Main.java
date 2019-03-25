package io.basquiat.encapsulation;

import java.util.Date;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Coupon coupon = Coupon.builder().couponId(UUID.randomUUID().toString())
										.brand("VIPS")
										.mobileCarrier("SKT")
										.expiryDate(new Date().getTime())
										.build();
		
		System.out.println(coupon);
		if(coupon.isExpiryDate()) {
			System.out.println("유효한 쿠폰");
		} else {
			System.out.println("만료된 쿠폰");
		}
		
	}

}
