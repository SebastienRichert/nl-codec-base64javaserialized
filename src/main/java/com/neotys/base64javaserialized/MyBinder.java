package com.neotys.base64javaserialized;

import static com.google.common.base.Predicates.alwaysTrue;
import static com.google.common.base.Predicates.and;
import static com.neotys.extensions.codec.predicates.MorePredicates.isRequestEntity;
import static com.neotys.extensions.codec.predicates.MorePredicates.isResponseEntity;
import static com.neotys.extensions.codec.predicates.MorePredicates.urlContains;

import com.neotys.extensions.codec.AbstractBinder;

/**
 * 
 * @author srichert
 * @date 27 avr. 2018
 */
public class MyBinder extends AbstractBinder {

	@Override
	protected void configure() {
		whenEntity(and(isRequestEntity(), urlContains("/services/application/server/callServerMethod"))).decodeWith(MyRequestDecoder.class);		
		whenEntity(and(isResponseEntity(), urlContains("/services/application/server/callServerMethod"))).decodeWith(MyResponseDecoder.class);
		whenObject(alwaysTrue()).encodeWith(MyEncoder.class).nameWith(MyNamer.class);
	}

}
