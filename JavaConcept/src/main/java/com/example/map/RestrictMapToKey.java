package com.example.map;

import java.util.HashMap;
import java.util.Map;

public class RestrictMapToKey {

	public static void main(String[] args) {
		Map<AllowedKeys, String> map = new HashMap<>();
		
		map.put(AllowedKeys.KEY_ONE, "Arif");
		map.put(AllowedKeys.KEY_TWO, "Rohit");
		//map.put("kamal", "rohit");
	}

}

enum AllowedKeys{
	KEY_ONE("hello"),
	KEY_TWO("brother");
	private String str;
	private AllowedKeys(String str) {
		this.str = str;
	}
	
	
	public String getValue() {
		return this.str;
	}
	
}
