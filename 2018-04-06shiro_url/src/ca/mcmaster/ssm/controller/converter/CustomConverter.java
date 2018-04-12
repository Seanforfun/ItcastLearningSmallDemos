package ca.mcmaster.ssm.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 2, 2018 9:55:48 PM
 * @version 1.0
 */
public class CustomConverter implements Converter<String, Date> {

	@Override
	public Date convert(String string) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
