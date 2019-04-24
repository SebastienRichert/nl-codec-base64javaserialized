package com.neotys.base64javaserialized;

import com.neotys.extensions.codec.functions.Namer;

/**
 * 
 * @author srichert
 * @date 27 avr. 2018
 */
public class MyNamer implements Namer {
	
	private static final String NAME_START_TAG = "<name>";
	private static final String NAME_END_TAG = "</name>";
	private static final int NAME_START_TAG_LENGTH = NAME_START_TAG.length();

	@Override
	public String apply(Object input) {
		if(input instanceof Request){
			return ((Request)input).getName();		
		}		
		if(input instanceof String){
			final String s= (String) input;
			final int startIndex = s.indexOf(NAME_START_TAG);
			final int endIndex = s.indexOf(NAME_END_TAG);
			if(startIndex != -1 && endIndex != -1){
				return s.substring(startIndex+NAME_START_TAG_LENGTH, endIndex);
			}
		}
		return "callServerMethod";		
	}

}
