package ca.mcmaster.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 2, 2018 9:55:48 PM
 * @version 1.0
 */
public class StringTrimConverter implements Converter<String, String> {

	@Override
	public String convert(String string) {
		try {
			if(null != string){
				string =  string.trim();
				if(string.equals("")){
					return null;
				}
				return string;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
