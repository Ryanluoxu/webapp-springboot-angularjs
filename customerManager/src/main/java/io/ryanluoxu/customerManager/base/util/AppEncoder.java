package io.ryanluoxu.customerManager.base.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppEncoder {

	public static void main(String[] args) {
		System.out.println(bCryptPasswordEncode("admin"));
	}

	public static String bCryptPasswordEncode(String rawPassword){
		return new BCryptPasswordEncoder().encode(rawPassword);
	}

}
