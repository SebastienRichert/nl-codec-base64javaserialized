package com.neotys.base64javaserialized;

/**
 * 
 * @author srichert
 * @date 27 avr. 2018
 */
public class Request {
	
	private final String name;
	private final String statelessGuid;
	private final String guid;
	private final Object params;

	public Request(final String name, final String statelessGuid, final String guid, final Object params) {
		this.name = name;
		this.statelessGuid = statelessGuid;
		this.guid = guid;
		this.params = params;		
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatelessGuid() {
		return statelessGuid;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public Object getParams() {
		return params;
	}

}
