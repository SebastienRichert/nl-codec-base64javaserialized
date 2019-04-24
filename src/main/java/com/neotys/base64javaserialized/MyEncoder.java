package com.neotys.base64javaserialized;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

import com.neotys.extensions.codec.functions.Encoder;

/**
 * 
 * @author srichert
 * @date 27 avr. 2018
 */
public class MyEncoder implements Encoder {

	@Override
	public byte[] apply(Object input) {
		if(input instanceof Request){
			final Request request = (Request) input;
			final StringBuilder sb = new StringBuilder();
			sb.append("name=").append(request.getName());
			sb.append("&statelessGuid=").append(request.getStatelessGuid());
			sb.append("&guid=").append(request.getGuid());
			sb.append("&params=");
			
			final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			try (final ObjectOutputStream objectOut = new ObjectOutputStream(byteOut)) {
				objectOut.writeObject(request.getParams());
			} catch (final IOException e) {
				e.printStackTrace();
			}
			final byte[] paramsJavaserialized = byteOut.toByteArray();
			final byte[] paramsBase64Encoded = Base64.getEncoder().encode(paramsJavaserialized);
			final byte[] firstPart = sb.toString().getBytes();
			final byte[] encodedRequest = new byte[firstPart.length + paramsBase64Encoded.length];
			System.arraycopy(firstPart, 0, encodedRequest, 0, firstPart.length);
			System.arraycopy(paramsBase64Encoded, 0, encodedRequest, firstPart.length, paramsBase64Encoded.length);
			return encodedRequest;
		}
		if(input instanceof String){
			final String request = (String) input;
			final StringBuilder sb = new StringBuilder();
			sb.append("name=").append(getAttributeValue("name", request));
			sb.append("&statelessGuid=").append(getAttributeValue("statelessGuid", request));
			sb.append("&guid=").append(getAttributeValue("guid", request));
			final String paramsString = getAttributeValue("params", request);
			final Object paramsObject = MyRequestDecoder.XSTREAM.fromXML(paramsString);
			sb.append("&params=");
			
			final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			try (final ObjectOutputStream objectOut = new ObjectOutputStream(byteOut)) {
				objectOut.writeObject(paramsObject);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			final byte[] paramsJavaserialized = byteOut.toByteArray();
			final byte[] paramsBase64Encoded = Base64.getEncoder().encode(paramsJavaserialized);
			final String urlEncoded = java.net.URLEncoder.encode(new String(paramsBase64Encoded));
			final String firstPart = sb.toString();			
			return (firstPart + urlEncoded).getBytes();
		}
		return null;
	}

	private static String getAttributeValue(final String attributeName, final String request) {
		final String startTag = "<" + attributeName + ">";
		final String endTag = "</" + attributeName + ">";
		final int startIndex = request.indexOf(startTag);
		final int endIndex = request.indexOf(endTag);
		if(startIndex!=1 && endIndex!=1){
			return request.substring(startIndex + startTag.length(), endIndex);
		}
		return "";
	}

}
