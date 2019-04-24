package com.neotys.base64javaserialized;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

import com.neotys.extensions.codec.functions.Decoder;

/**
 * 
 * @author srichert
 * @date 7 mai 2018
 */
public class MyResponseDecoder implements Decoder {

	@Override
	public Object apply(byte[] input) {
		// 1. Decode response in Base64
		final byte[] responseJavaserialized = Base64.getDecoder().decode(new String(input));
		
		// 2. Deserialize java object 
		try (final ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(responseJavaserialized))) {
			return ois.readObject();
		} catch (final Exception e) {	
			return e;
		}		
	}

}
