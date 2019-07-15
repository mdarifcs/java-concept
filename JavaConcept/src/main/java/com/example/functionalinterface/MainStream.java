package com.example.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainStream {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("l", 10);
		map.put("b", 40);
		map.put("a", 5);
		map.put("z", 100);
		
		map.forEach((key,val)->System.out.println("key: "+key+" val: "+val));
		System.out.println("Using entry set");
		map.entrySet().forEach(obj->System.out.println("key: "+obj.getKey()+" val: "+obj.getValue()));
		System.out.println("Using entry stream");
		map.entrySet().stream().filter(obj->obj.getValue()>15).forEach(obj->System.out.println("key: "+obj.getKey()+" val: "+obj.getValue()));
		
		//sort list using stream
		List<Integer> list = Arrays.asList(7,4,6,8,9,1,2,3,5);
		list.stream().sorted(Comparator.reverseOrder()).forEach(e->System.out.print(e+" "));
		System.out.println();
		
		//sort list using stream
		System.out.println("###############################by Key##########################################");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(obj->System.out.println("key: "+obj.getKey()+" val: "+obj.getValue()));
		System.out.println("###############################by Value##########################################");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(obj->System.out.println("key: "+obj.getKey()+" val: "+obj.getValue()));
		
	}

}
