package ca.mcmaster.utils;

import java.util.UUID;

public class RandomUtils {
	public static String getRandomName(String name){
		int index = name.lastIndexOf(".");
		return UUID.randomUUID()+name.substring(index);
	}
}
