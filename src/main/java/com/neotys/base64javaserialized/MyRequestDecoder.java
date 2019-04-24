package com.neotys.base64javaserialized;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Base64;
import java.util.StringTokenizer;

import com.neotys.extensions.codec.functions.Decoder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.Sun14ReflectionProvider;

/**
 * 
 * @author srichert
 * @date 27 avr. 2018
 */
public class MyRequestDecoder implements Decoder {
		
//	static {
//		try {
//			final ClassPath cp = ClassPath.from(Thread.currentThread().getContextClassLoader());
//			ImmutableSet<ClassInfo> cis = cp.getTopLevelClassesRecursive("com.ntst");
//			for(final ClassInfo ci : cis){
//				for(final Field field : ci.getClass().getDeclaredFields()){
//					field.setAccessible(true);
//					Field modifiersField = Field.class.getDeclaredField("modifiers");
//					modifiersField.setAccessible(true);
//					modifiersField.setInt(field, field.getModifiers() & ~Modifier.TRANSIENT);
//				}
//			}
//		} catch (IOException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static final XStream XSTREAM;
	
	static {
		Sun14ReflectionProvider pureJavaReflectionProvider = new Sun14ReflectionProvider(){
	        @Override
	        protected boolean fieldModifiersSupported(final Field field) {
	            int modifiers = field.getModifiers();
	            return !(Modifier.isStatic(modifiers));
	        }
	    };
	    XSTREAM = new XStream(pureJavaReflectionProvider);
	    final ReflectionConverter converter = new ReflectionConverter(XSTREAM.getMapper(), XSTREAM.getReflectionProvider()){
            @Override
            protected boolean shouldUnmarshalTransientFields() {
                return true;
            }
        };
        XSTREAM.registerConverter(converter, -19);
	    XSTREAM.setClassLoader(MyRequestDecoder.class.getClassLoader());	    
	}
		
	@Override
	public Object apply(byte[] input) {
		final String requestContent = new String(input);
		final StringTokenizer stringTokenizer = new StringTokenizer(requestContent, "&");
		final String name = stringTokenizer.nextToken().substring("name=".length());
		final String statelessGuid = stringTokenizer.nextToken().substring("statelessGuid=".length());
		final String guid = stringTokenizer.nextToken().substring("guid=".length());
		final String paramsURLEncoded = stringTokenizer.nextToken().substring("params=".length());
		Object params = null;
		String paramsBase64Encoded;		
		final StringBuilder sb = new StringBuilder();
		sb.append("<NLXML>\n");
		try {
			paramsBase64Encoded = java.net.URLDecoder.decode(paramsURLEncoded, "UTF-8");
			final byte[] paramsJavaserialized = Base64.getDecoder().decode(paramsBase64Encoded);
			
			try (final ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(paramsJavaserialized))) {
				params = ois.readObject();					
		   
//				final ClassPath cp = ClassPath.from(((Object[]) params)[1].getClass().getClassLoader());
//				ImmutableSet<ClassInfo> cis = cp.getTopLevelClassesRecursive("com.ntst");
//				for (final ClassInfo ci : cis) {
//					try {
//						final String className = ci.getName();
//						if (!className.startsWith("com.ntst")) {
//							continue;
//						}
//						for (final Field field : Class.forName(className).getDeclaredFields()) {
//							field.setAccessible(true);
//							field.setInt(field, field.getModifiers() & ~Modifier.TRANSIENT);
//						}
//					} catch (final Throwable e) {
//						e.printStackTrace();
//					}
//				}
			} catch (final Throwable t) {	
				sb.append(t.getMessage());
				sb.append("</NLXML>");
				return sb.toString();
			}
		} catch (UnsupportedEncodingException e1) {	
			sb.append(e1.getMessage());
			sb.append("</NLXML>");
			return sb.toString();
		}		
		sb.append("  <name>" + name + "</name>\n");
		sb.append("  <statelessGuid>" + statelessGuid + "</statelessGuid>\n");
		sb.append("  <guid>" + guid + "</guid>\n");
		sb.append("  <params>" + XSTREAM.toXML(params) + "</params>\n");
		sb.append("</NLXML>");
		return sb.toString();
	}
}
