package com.neotys.base64javaserialized;

public class Test {

	public Test() {		
	}
	
	public static void main(String[] args) {
		testRequest2();
	}
	
	public static void testRequest1() {
		final String requestContent = "name=connect&statelessGuid=7a78af60-1882-4df5-b733-87c8c0a9122d&guid=GUID063f9061-f47f-46e1-8c45-80a4b07d52bd%7C&params=rO0ABXVyABNbTGphdmEubGFuZy5PYmplY3Q7kM5YnxBzKWwCAAB4cAAAAAJzcgAiY29tLm50c3QucmFkcGx1cy5jb21tb24uQ29ubmVjdGlvbv4AuWanA8xUAgAYWgAJYXV0b0xvZ2luWgATYXV0b0xvZ2luTm9QYXNzd29yZFoAB2lzTGFiZWxJABFsb2NrU2NyZWVuVGltZW91dFoAEW5ld2xvZ2luU3VwcG9ydGVkWgAgc3VwcG9ydGluZ0NsaWVudFNlcnZlclZlcnNpb25pbmdJAA50aW1lT3V0U2Vjb25kc0wAFGFkZGl0aW9uYWxDbGllbnREYXRhdAASTGphdmEvbGFuZy9TdHJpbmc7TAAPYXBwbGljYXRpb25OYW1lcQB%2BAANMAA9jbGllbnRJUEFkZHJlc3NxAH4AA0wAD2N1cnJlbnRPcHRpb25JRHEAfgADTAAIZGF0YWJhc2VxAH4AA0wABGhvc3RxAH4AA0wAAmlkcQB%2BAANMAAlqb2JOdW1iZXJxAH4AA0wAB2xvZ2luSURxAH4AA0wADWxvZ2luUGFzc3dvcmRxAH4AA0wAD2xvZ2luU3lzdGVtQ29kZXEAfgADTAAEbmFtZXEAfgADTAAIb2RiY0hvc3RxAH4AA0wACG9kYmNQb3J0cQB%2BAANMAARwb3J0cQB%2BAANMAAhwcm90b2NvbHEAfgADTAAGdGFyZ2V0cQB%2BAAN4cAAAAAAAAAAAAAAAAABwdAAEQkhJU3QADjEwLjExNC4yNTUuMjI3dAAAdAAEQVZQTXQACFBTQVZQTTE1cHB0AAEtdAABLXQAAS10AA1QU0FWUE0xNS1BVlBNcQB%2BAAl0AAQxOTc1cQB%2BAA50AARqZGJjdAAfamRiYzpDYWNoZTovL1BTQVZQTTE1OjE5NzUvQVZQTXNyABFqYXZhLmxhbmcuQm9vbGVhbs0gcoDVnPruAgABWgAFdmFsdWV4cAE%3D";
		
		final Request request = (Request) (new MyRequestDecoder()).apply(requestContent.getBytes());
		System.out.println("name: " + request.getName());
		System.out.println("statelessGuid: " + request.getStatelessGuid());
		System.out.println("guid: " + request.getGuid());
		System.out.println("params: " + request.getParams());
		
		final String reencodedRequestContent =  new String((new MyEncoder()).apply(request));
		System.out.println(reencodedRequestContent);
	}
	
	public static void testRequest2() {
		final String requestContent = "name=handleComponentEvent&statelessGuid=432c9695-e28d-46a7-8957-5010dfc8c4b4&guid=GUID306420fa-d062-4652-9764-a73af9031de2%7C&params=rO0ABXVyABNbTGphdmEubGFuZy5PYmplY3Q7kM5YnxBzKWwCAAB4cAAAAAJ0AAlMb3N0Rm9jdXNzcgAqY29tLm50c3QucmFkcGx1cy5jb21tb24uVGV4dEFyZWFEZWZpbml0aW9uCnup%2F1TR7o0CAAFaABBob3Jpem9udGFsU2Nyb2xseHIAK2NvbS5udHN0LnJhZHBsdXMuY29tbW9uLkNvbXBvbmVudERlZmluaXRpb26jiHmro3NopQMABFoAFmlnbm9yZVNhdmVDdXJyZW50VmFsdWVaAA5pc01vZGlmaWVkVGVtcFoAD2lzTW9kaWZpZWRUZW1wMkwADWdsb2JhbENvbnRleHR0ACdMY29tL250c3QvcmFkcGx1cy9jb21tb24vR2xvYmFsQ29udGV4dDt4cHoAAAQAAAAieDA9MXwxPVNUWDEwNzUwfjAxMDEwMzksQ1dTVEFCTEV8ND1Ob3RlcGFkKysgdjcuNS42IGVuaGFuY2VtZW50cyAmIGJ1Zy1maXhlczoNCg0KMS4gIEZpeCBtYWNybyBwbGF5aW5nIGJhY2sgY3Jhc2ggaXNzdWUgb24gbmV3IGFkZGVkICJmaW5kIHByZXZpb3VzIiBhbmQgImZpbmQgbmV4dCIgYnV0dG9ucy4NCjIuICBGdW5jdGlvbiBMaXN0IGVuaGFuY2VtZW50OiBIaWdobGlnaHQgdGhlIGN1cnJlbnQgZnVuY3Rpb24gYmFzZWQgb24gY3Vyc29yIHBvc2l0aW9uLg0KMy4gIEZpeCBjcmFzaCBvbiBzdHlsZXIgZGlhbG9nIG9mIFVzZXIgRGVmaW5lZCBMYW5ndWFnZSBkaWFsb2cuDQo0LiAgRml4IGZpbGUgc3RhdHVzIGRldGVjdGlvbiBpc3N1ZSB1bmRlciBXaW5kb3dzIFhQLg0KNS4gIEdob3N0IHR5cGluZyBlbmhhbmNlbWVudDogVW5pY29kZSwgc3ludGF4IGhpZ2hsaWdodGluZyBhbmQgc3BlZWQgc3VwcG9ydC4NCiAgICAoY2hlY2sgdGhlIHVybCBmb3IgdGhlIHVzYWdlIG9mIGdob3N0IHR5cGluZyBvbiBjb21tYW5kIGxpbmU6IGh0dHBzOi8vbm90ZXBhZC1wbHVzLXBsdXMub3JnL2ZlYXR1cmVzL2dob3N0LXR5cGluZy5odG1sICkNCjYuICBBZGQgYSBtZXNzYWdlIGZyb20gb3V0ZXIgc3BhY2UuDQoNCg0KTm90ZXBhZCsrIDcuNS41IGVuaGFuY2VtZW50cyAmIGJ1Zy1maXhlczoNCg0KMS4gIFJlc3RvcmUgMiBidXR0b25zICI8PCBGaW5kIFByZXZpb3VzIiAmICJGaW5kIE5leHQgPj4iIGluIEZpbmQgZGlhbG9nIChvcHRpb25hbCkuDQoyLiAgRml4IG1vbml0b3JlZCAodGFpbCAtZikgZmlsZSBub3QgYWx3YXlzIHVwZGF0ZWQgaXNzdWUuDQozLiAgS2VlcCBEb2MgU3dpdGNoZXIncyBvcmRlcmluZyBpbiBzeW5jIHdpdGggVGFiIGJhci4NCjQuICBTaG9ydGN1dCBNYXBwZXIgZW5oYW5jZW1lbnRzOiBBZGQgZmlsdGVyIGNhcGFjaXR5IGFuZCBtYWtlIGRpYWxvZyByZXNpemFibGUgYW5kIG1heGltaXphYmxlLg0KNS4gIEZpeCBmb3IgIlRvZ2dsZSBTaW5nbGUgTGluZSBDb21tZW50IiBtYWxmdXoAAAQAbmN0aW9uaW5nIHdpdGggSFRNTC9YTUwuDQo2LiAgTWFrZSBVbml4IHN0eWxlIHBhdGggKHNsYXNoZXMpIHdvcmsgaW4gb3BlbiBmaWxlIGRpYWxvZyAob3B0aW9uYWwpLg0KNy4gIEZpeCB0YWIgc3RpY2tzIHRvIG1vdXNlIHBvaW50ZXIgcHJvYmxlbSBhZnRlciBleHRlcm5hbCB1cGRhdGUgb2YgYSBvcGVuZWQgZmlsZS4NCjguICBGaXggZW5jb2Rpbmcgbm90IHN5bmMgKG9uIHN0YXR1cyBiYXIpIGFmdGVyIHJlbG9hZGluZy4NCjkuICBGaXggbWVudSBpdGVtcycgc3RhdGUgaXMgbm90IG1haW50YWluZWQgZHVlIHRvIHNhdmUgbWFjcm8gY29tbWFuZC4NCjEwLiBGaXggbGluZSBlbmRpbmcgY2hhbmdlcyBhcmUgbm90IGRldGVjdGVkIGluIHJlbG9hZGVkIGNoYW5nZWQgZmlsZXMgaXNzdWUuDQoxMS4gRml4IGhpZ2hsaWdodGluZyBvZiA8c2NyaXB0PiB0YWdzIGluIFhNTCBmaWxlcyBpc3N1ZS4NCjEyLiBGaXggVW5pY29kZSBmaWxlIG5hbWUgY29tcGFyaXNvbiB0byBtYXRjaCBXaW5kb3dzIGJlaGF2aW91ciAoYXMgb3Bwb3NlZCB0byBkb2luZyBhIGxpbmd1aXN0aWMgZmlsZW5hbWUgY29tcGFyaXNvbikuDQoNCg0KSW5jbHVkZWQgcGx1Z2luczoNCg0KMS4gIE5wcEV4cG9ydCB2MC4yLjggKDMyLWJpdCB4ODYgb25seSkNCjIuICBDb252ZXJ0ZXIgNC4yLjENCjMuICBNaW1lIFRvb2wgMi4xDQo0LiAgRFNwZWxsQ2hlY2sgMS4zLjUNCg0KDQpVcGRhdGVyIChJbnN0YWxsZXIgb25seSk6DQoNCiogV2luR3VwIHY0LjINCg0KTm90ZXBhZCsrIHY3LjUuNiBlbmhhbmNlbWVudHMgJiBidWctZml4ZXM6DQoNCjEuICBGaXggbWFjcm8gcGxheWluZyBiYWNrIGNyYXNoIGlzc3VlIG9uIG5ldyBhZGRlZCAiZmluZCBwcmV2aW91cyIgYW5kICJmaW5kIG5leHQiIGJ1dHRvbnMuDQoyLiAgRnVuY3Rpb24gTGlzdCBlbmhhbmNlbWVudDogSGlnaGxpZ2h0IHRoZSBjdXJyZW50IGZ1bmN0aW9uIGJhc2VkIG9uIGN1cnNvciBwb3NpdGlvbi4NCjMuICBGaXggY3Jhc2ggb24gc3R5bGVyIGRpYWxvZyBvZiBVc2VyIERlZnoAAAQAaW5lZCBMYW5ndWFnZSBkaWFsb2cuDQo0LiAgRml4IGZpbGUgc3RhdHVzIGRldGVjdGlvbiBpc3N1ZSB1bmRlciBXaW5kb3dzIFhQLg0KNS4gIEdob3N0IHR5cGluZyBlbmhhbmNlbWVudDogVW5pY29kZSwgc3ludGF4IGhpZ2hsaWdodGluZyBhbmQgc3BlZWQgc3VwcG9ydC4NCiAgICAoY2hlY2sgdGhlIHVybCBmb3IgdGhlIHVzYWdlIG9mIGdob3N0IHR5cGluZyBvbiBjb21tYW5kIGxpbmU6IGh0dHBzOi8vbm90ZXBhZC1wbHVzLXBsdXMub3JnL2ZlYXR1cmVzL2dob3N0LXR5cGluZy5odG1sICkNCjYuICBBZGQgYSBtZXNzYWdlIGZyb20gb3V0ZXIgc3BhY2UuDQoNCg0KTm90ZXBhZCsrIDcuNS41IGVuaGFuY2VtZW50cyAmIGJ1Zy1maXhlczoNCg0KMS4gIFJlc3RvcmUgMiBidXR0b25zICI8PCBGaW5kIFByZXZpb3VzIiAmICJGaW5kIE5leHQgPj4iIGluIEZpbmQgZGlhbG9nIChvcHRpb25hbCkuDQoyLiAgRml4IG1vbml0b3JlZCAodGFpbCAtZikgZmlsZSBub3QgYWx3YXlzIHVwZGF0ZWQgaXNzdWUuDQozLiAgS2VlcCBEb2MgU3dpdGNoZXIncyBvcmRlcmluZyBpbiBzeW5jIHdpdGggVGFiIGJhci4NCjQuICBTaG9ydGN1dCBNYXBwZXIgZW5oYW5jZW1lbnRzOiBBZGQgZmlsdGVyIGNhcGFjaXR5IGFuZCBtYWtlIGRpYWxvZyByZXNpemFibGUgYW5kIG1heGltaXphYmxlLg0KNS4gIEZpeCBmb3IgIlRvZ2dsZSBTaW5nbGUgTGluZSBDb21tZW50IiBtYWxmdW5jdGlvbmluZyB3aXRoIEhUTUwvWE1MLg0KNi4gIE1ha2UgVW5peCBzdHlsZSBwYXRoIChzbGFzaGVzKSB3b3JrIGluIG9wZW4gZmlsZSBkaWFsb2cgKG9wdGlvbmFsKS4NCjcuICBGaXggdGFiIHN0aWNrcyB0byBtb3VzZSBwb2ludGVyIHByb2JsZW0gYWZ0ZXIgZXh0ZXJuYWwgdXBkYXRlIG9mIGEgb3BlbmVkIGZpbGUuDQo4LiAgRml4IGVuY29kaW5nIG5vdCBzeW5jIChvbiBzdGF0dXMgYmFyKSBhZnRlciByZWxvYWRpbmcuDQo5LiAgRml4IG1lbnUgaXRlbXMnIHN0YXRlIGlzIG5vdCBtYWludGFpbmVkIGR1ZSB0byBzYXZlIG1hY3JvIGNvbXoAAAQAbWFuZC4NCjEwLiBGaXggbGluZSBlbmRpbmcgY2hhbmdlcyBhcmUgbm90IGRldGVjdGVkIGluIHJlbG9hZGVkIGNoYW5nZWQgZmlsZXMgaXNzdWUuDQoxMS4gRml4IGhpZ2hsaWdodGluZyBvZiA8c2NyaXB0PiB0YWdzIGluIFhNTCBmaWxlcyBpc3N1ZS4NCjEyLiBGaXggVW5pY29kZSBmaWxlIG5hbWUgY29tcGFyaXNvbiB0byBtYXRjaCBXaW5kb3dzIGJlaGF2aW91ciAoYXMgb3Bwb3NlZCB0byBkb2luZyBhIGxpbmd1aXN0aWMgZmlsZW5hbWUgY29tcGFyaXNvbikuDQoNCg0KSW5jbHVkZWQgcGx1Z2luczoNCg0KMS4gIE5wcEV4cG9ydCB2MC4yLjggKDMyLWJpdCB4ODYgb25seSkNCjIuICBDb252ZXJ0ZXIgNC4yLjENCjMuICBNaW1lIFRvb2wgMi4xDQo0LiAgRFNwZWxsQ2hlY2sgMS4zLjUNCg0KDQpVcGRhdGVyIChJbnN0YWxsZXIgb25seSk6DQoNCiogV2luR3VwIHY0LjINCg0KTm90ZXBhZCsrIHY3LjUuNiBlbmhhbmNlbWVudHMgJiBidWctZml4ZXM6DQoNCjEuICBGaXggbWFjcm8gcGxheWluZyBiYWNrIGNyYXNoIGlzc3VlIG9uIG5ldyBhZGRlZCAiZmluZCBwcmV2aW91cyIgYW5kICJmaW5kIG5leHQiIGJ1dHRvbnMuDQoyLiAgRnVuY3Rpb24gTGlzdCBlbmhhbmNlbWVudDogSGlnaGxpZ2h0IHRoZSBjdXJyZW50IGZ1bmN0aW9uIGJhc2VkIG9uIGN1cnNvciBwb3NpdGlvbi4NCjMuICBGaXggY3Jhc2ggb24gc3R5bGVyIGRpYWxvZyBvZiBVc2VyIERlZmluZWQgTGFuZ3VhZ2UgZGlhbG9nLg0KNC4gIEZpeCBmaWxlIHN0YXR1cyBkZXRlY3Rpb24gaXNzdWUgdW5kZXIgV2luZG93cyBYUC4NCjUuICBHaG9zdCB0eXBpbmcgZW5oYW5jZW1lbnQ6IFVuaWNvZGUsIHN5bnRheCBoaWdobGlnaHRpbmcgYW5kIHNwZWVkIHN1cHBvcnQuDQogICAgKGNoZWNrIHRoZSB1cmwgZm9yIHRoZSB1c2FnZSBvZiBnaG9zdCB0eXBpbmcgb24gY29tbWFuZCBsaW5lOiBodHRwczovL25vdGVwYWQtcGx1cy1wbHVzLm9yZy9mZWF0dXJlcy9naG9zdC10eXBpbmcuaHRtbCApDQo2LiAgQWRkIGEgbWVzc2FnZSBmcm9tIG91dHoAAAQAZXIgc3BhY2UuDQoNCg0KTm90ZXBhZCsrIDcuNS41IGVuaGFuY2VtZW50cyAmIGJ1Zy1maXhlczoNCg0KMS4gIFJlc3RvcmUgMiBidXR0b25zICI8PCBGaW5kIFByZXZpb3VzIiAmICJGaW5kIE5leHQgPj4iIGluIEZpbmQgZGlhbG9nIChvcHRpb25hbCkuDQoyLiAgRml4IG1vbml0b3JlZCAodGFpbCAtZikgZmlsZSBub3QgYWx3YXlzIHVwZGF0ZWQgaXNzdWUuDQozLiAgS2VlcCBEb2MgU3dpdGNoZXIncyBvcmRlcmluZyBpbiBzeW5jIHdpdGggVGFiIGJhci4NCjQuICBTaG9ydGN1dCBNYXBwZXIgZW5oYW5jZW1lbnRzOiBBZGQgZmlsdGVyIGNhcGFjaXR5IGFuZCBtYWtlIGRpYWxvZyByZXNpemFibGUgYW5kIG1heGltaXphYmxlLg0KNS4gIEZpeCBmb3IgIlRvZ2dsZSBTaW5nbGUgTGluZSBDb21tZW50IiBtYWxmdW5jdGlvbmluZyB3aXRoIEhUTUwvWE1MLg0KNi4gIE1ha2UgVW5peCBzdHlsZSBwYXRoIChzbGFzaGVzKSB3b3JrIGluIG9wZW4gZmlsZSBkaWFsb2cgKG9wdGlvbmFsKS4NCjcuICBGaXggdGFiIHN0aWNrcyB0byBtb3VzZSBwb2ludGVyIHByb2JsZW0gYWZ0ZXIgZXh0ZXJuYWwgdXBkYXRlIG9mIGEgb3BlbmVkIGZpbGUuDQo4LiAgRml4IGVuY29kaW5nIG5vdCBzeW5jIChvbiBzdGF0dXMgYmFyKSBhZnRlciByZWxvYWRpbmcuDQo5LiAgRml4IG1lbnUgaXRlbXMnIHN0YXRlIGlzIG5vdCBtYWludGFpbmVkIGR1ZSB0byBzYXZlIG1hY3JvIGNvbW1hbmQuDQoxMC4gRml4IGxpbmUgZW5kaW5nIGNoYW5nZXMgYXJlIG5vdCBkZXRlY3RlZCBpbiByZWxvYWRlZCBjaGFuZ2VkIGZpbGVzIGlzc3VlLg0KMTEuIEZpeCBoaWdobGlnaHRpbmcgb2YgPHNjcmlwdD4gdGFncyBpbiBYTUwgZmlsZXMgaXNzdWUuDQoxMi4gRml4IFVuaWNvZGUgZmlsZSBuYW1lIGNvbXBhcmlzb24gdG8gbWF0Y2ggV2luZG93cyBiZWhhdmlvdXIgKGFzIG9wcG9zZWQgdG8gZG9pbmcgYSBsaW5ndWlzdGljIGZpbGVuYW1lIGNvbXBhcmlzb24pLg0KDQoNCkluY2x1ZGVkIHBsdWdpbnM6DQoNCjEuICBOcHBFeHBvcnQgdjAuMnoAAAQALjggKDMyLWJpdCB4ODYgb25seSkNCjIuICBDb252ZXJ0ZXIgNC4yLjENCjMuICBNaW1lIFRvb2wgMi4xDQo0LiAgRFNwZWxsQ2hlY2sgMS4zLjUNCg0KDQpVcGRhdGVyIChJbnN0YWxsZXIgb25seSk6DQoNCiogV2luR3VwIHY0LjINCg0KTm90ZXBhZCsrIHY3LjUuNiBlbmhhbmNlbWVudHMgJiBidWctZml4ZXM6DQoNCjEuICBGaXggbWFjcm8gcGxheWluZyBiYWNrIGNyYXNoIGlzc3VlIG9uIG5ldyBhZGRlZCAiZmluZCBwcmV2aW91cyIgYW5kICJmaW5kIG5leHQiIGJ1dHRvbnMuDQoyLiAgRnVuY3Rpb24gTGlzdCBlbmhhbmNlbWVudDogSGlnaGxpZ2h0IHRoZSBjdXJyZW50IGZ1bmN0aW9uIGJhc2VkIG9uIGN1cnNvciBwb3NpdGlvbi4NCjMuICBGaXggY3Jhc2ggb24gc3R5bGVyIGRpYWxvZyBvZiBVc2VyIERlZmluZWQgTGFuZ3VhZ2UgZGlhbG9nLg0KNC4gIEZpeCBmaWxlIHN0YXR1cyBkZXRlY3Rpb24gaXNzdWUgdW5kZXIgV2luZG93cyBYUC4NCjUuICBHaG9zdCB0eXBpbmcgZW5oYW5jZW1lbnQ6IFVuaWNvZGUsIHN5bnRheCBoaWdobGlnaHRpbmcgYW5kIHNwZWVkIHN1cHBvcnQuDQogICAgKGNoZWNrIHRoZSB1cmwgZm9yIHRoZSB1c2FnZSBvZiBnaG9zdCB0eXBpbmcgb24gY29tbWFuZCBsaW5lOiBodHRwczovL25vdGVwYWQtcGx1cy1wbHVzLm9yZy9mZWF0dXJlcy9naG9zdC10eXBpbmcuaHRtbCApDQo2LiAgQWRkIGEgbWVzc2FnZSBmcm9tIG91dGVyIHNwYWNlLg0KDQoNCk5vdGVwYWQrKyA3LjUuNSBlbmhhbmNlbWVudHMgJiBidWctZml4ZXM6DQoNCjEuICBSZXN0b3JlIDIgYnV0dG9ucyAiPDwgRmluZCBQcmV2aW91cyIgJiAiRmluZCBOZXh0ID4%2BIiBpbiBGaW5kIGRpYWxvZyAob3B0aW9uYWwpLg0KMi4gIEZpeCBtb25pdG9yZWQgKHRhaWwgLWYpIGZpbGUgbm90IGFsd2F5cyB1cGRhdGVkIGlzc3VlLg0KMy4gIEtlZXAgRG9jIFN3aXRjaGVyJ3Mgb3JkZXJpbmcgaW4gc3luYyB3aXRoIFRhYiBiYXIuDQo0LiAgU2hvcnRjdXQgTWFwcGVyIGVuaGFuY2VtZW50czogQWRkIGZpbHRlciBjYXoAAAQAcGFjaXR5IGFuZCBtYWtlIGRpYWxvZyByZXNpemFibGUgYW5kIG1heGltaXphYmxlLg0KNS4gIEZpeCBmb3IgIlRvZ2dsZSBTaW5nbGUgTGluZSBDb21tZW50IiBtYWxmdW5jdGlvbmluZyB3aXRoIEhUTUwvWE1MLg0KNi4gIE1ha2UgVW5peCBzdHlsZSBwYXRoIChzbGFzaGVzKSB3b3JrIGluIG9wZW4gZmlsZSBkaWFsb2cgKG9wdGlvbmFsKS4NCjcuICBGaXggdGFiIHN0aWNrcyB0byBtb3VzZSBwb2ludGVyIHByb2JsZW0gYWZ0ZXIgZXh0ZXJuYWwgdXBkYXRlIG9mIGEgb3BlbmVkIGZpbGUuDQo4LiAgRml4IGVuY29kaW5nIG5vdCBzeW5jIChvbiBzdGF0dXMgYmFyKSBhZnRlciByZWxvYWRpbmcuDQo5LiAgRml4IG1lbnUgaXRlbXMnIHN0YXRlIGlzIG5vdCBtYWludGFpbmVkIGR1ZSB0byBzYXZlIG1hY3JvIGNvbW1hbmQuDQoxMC4gRml4IGxpbmUgZW5kaW5nIGNoYW5nZXMgYXJlIG5vdCBkZXRlY3RlZCBpbiByZWxvYWRlZCBjaGFuZ2VkIGZpbGVzIGlzc3VlLg0KMTEuIEZpeCBoaWdobGlnaHRpbmcgb2YgPHNjcmlwdD4gdGFncyBpbiBYTUwgZmlsZXMgaXNzdWUuDQoxMi4gRml4IFVuaWNvZGUgZmlsZSBuYW1lIGNvbXBhcmlzb24gdG8gbWF0Y2ggV2luZG93cyBiZWhhdmlvdXIgKGFzIG9wcG9zZWQgdG8gZG9pbmcgYSBsaW5ndWlzdGljIGZpbGVuYW1lIGNvbXBhcmlzb24pLg0KDQoNCkluY2x1ZGVkIHBsdWdpbnM6DQoNCjEuICBOcHBFeHBvcnQgdjAuMi44ICgzMi1iaXQgeDg2IG9ubHkpDQoyLiAgQ29udmVydGVyIDQuMi4xDQozLiAgTWltZSBUb29sIDIuMQ0KNC4gIERTcGVsbENoZWNrIDEuMy41DQoNCg0KVXBkYXRlciAoSW5zdGFsbGVyIG9ubHkpOg0KDQoqIFdpbkd1cCB2NC4yDQoNCk5vdGVwYWQrKyB2Ny41LjYgZW5oYW5jZW1lbnRzICYgYnVnLWZpeGVzOg0KDQoxLiAgRml4IG1hY3JvIHBsYXlpbmcgYmFjayBjcmFzaCBpc3N1ZSBvbiBuZXcgYWRkZWQgImZpbmQgcHJldmlvdXMiIGFuZCAiZmluZCBuZXh0IiBidXR0b25zLg0KMi4gIEZ1bmN0aW9uIExpc3QgZW5oYW5jZW1lbnQ6IEhpZ3oAAAQAaGxpZ2h0IHRoZSBjdXJyZW50IGZ1bmN0aW9uIGJhc2VkIG9uIGN1cnNvciBwb3NpdGlvbi4NCjMuICBGaXggY3Jhc2ggb24gc3R5bGVyIGRpYWxvZyBvZiBVc2VyIERlZmluZWQgTGFuZ3VhZ2UgZGlhbG9nLg0KNC4gIEZpeCBmaWxlIHN0YXR1cyBkZXRlY3Rpb24gaXNzdWUgdW5kZXIgV2luZG93cyBYUC4NCjUuICBHaG9zdCB0eXBpbmcgZW5oYW5jZW1lbnQ6IFVuaWNvZGUsIHN5bnRheCBoaWdobGlnaHRpbmcgYW5kIHNwZWVkIHN1cHBvcnQuDQogICAgKGNoZWNrIHRoZSB1cmwgZm9yIHRoZSB1c2FnZSBvZiBnaG9zdCB0eXBpbmcgb24gY29tbWFuZCBsaW5lOiBodHRwczovL25vdGVwYWQtcGx1cy1wbHVzLm9yZy9mZWF0dXJlcy9naG9zdC10eXBpbmcuaHRtbCApDQo2LiAgQWRkIGEgbWVzc2FnZSBmcm9tIG91dGVyIHNwYWNlLg0KDQoNCk5vdGVwYWQrKyA3LjUuNSBlbmhhbmNlbWVudHMgJiBidWctZml4ZXM6DQoNCjEuICBSZXN0b3JlIDIgYnV0dG9ucyAiPDwgRmluZCBQcmV2aW91cyIgJiAiRmluZCBOZXh0ID4%2BIiBpbiBGaW5kIGRpYWxvZyAob3B0aW9uYWwpLg0KMi4gIEZpeCBtb25pdG9yZWQgKHRhaWwgLWYpIGZpbGUgbm90IGFsd2F5cyB1cGRhdGVkIGlzc3VlLg0KMy4gIEtlZXAgRG9jIFN3aXRjaGVyJ3Mgb3JkZXJpbmcgaW4gc3luYyB3aXRoIFRhYiBiYXIuDQo0LiAgU2hvcnRjdXQgTWFwcGVyIGVuaGFuY2VtZW50czogQWRkIGZpbHRlciBjYXBhY2l0eSBhbmQgbWFrZSBkaWFsb2cgcmVzaXphYmxlIGFuZCBtYXhpbWl6YWJsZS4NCjUuICBGaXggZm9yICJUb2dnbGUgU2luZ2xlIExpbmUgQ29tbWVudCIgbWFsZnVuY3Rpb25pbmcgd2l0aCBIVE1ML1hNTC4NCjYuICBNYWtlIFVuaXggc3R5bGUgcGF0aCAoc2xhc2hlcykgd29yayBpbiBvcGVuIGZpbGUgZGlhbG9nIChvcHRpb25hbCkuDQo3LiAgRml4IHRhYiBzdGlja3MgdG8gbW91c2UgcG9pbnRlciBwcm9ibGVtIGFmdGVyIGV4dGVybmFsIHVwZGF0ZSBvZiBhIG9wZW5lZCBmaWxlLg0KOC4gIEZpeCBlbmNvZGluZyBub3Qgc3luYyAob3oAAAJ8biBzdGF0dXMgYmFyKSBhZnRlciByZWxvYWRpbmcuDQo5LiAgRml4IG1lbnUgaXRlbXMnIHN0YXRlIGlzIG5vdCBtYWludGFpbmVkIGR1ZSB0byBzYXZlIG1hY3JvIGNvbW1hbmQuDQoxMC4gRml4IGxpbmUgZW5kaW5nIGNoYW5nZXMgYXJlIG5vdCBkZXRlY3RlZCBpbiByZWxvYWRlZCBjaGFuZ2VkIGZpbGVzIGlzc3VlLg0KMTEuIEZpeCBoaWdobGlnaHRpbmcgb2YgPHNjcmlwdD4gdGFncyBpbiBYTUwgZmlsZXMgaXNzdWUuDQoxMi4gRml4IFVuaWNvZGUgZmlsZSBuYW1lIGNvbXBhcmlzb24gdG8gbWF0Y2ggV2luZG93cyBiZWhhdmlvdXIgKGFzIG9wcG9zZWQgdG8gZG9pbmcgYSBsaW5ndWlzdGljIGZpbGVuYW1lIGNvbXBhcmlzb24pLg0KDQoNCkluY2x1ZGVkIHBsdWdpbnM6DQoNCjEuICBOcHBFeHBvcnQgdjAuMi44ICgzMi1iaXQgeDg2IG9ubHkpDQoyLiAgQ29udmVydGVyIDQuMi4xDQozLiAgTWltZSBUb29sIDIuMQ0KNC4gIERTcGVsbENoZWNrIDEuMy41DQoNCg0KVXBkYXRlciAoSW5zdGFsbGVyIG9ubHkpOg0KDQoqIFdpbkd1cCB2NC4yDQp8Nj0xfDc9MzZ8OD0xfDk9Mzl8MTI9MC4wOTA2MjV8MTM9My4wMzA5MDI5fDE0PTguMTg2NDU5fDE1PTEuODQyNzA4M3wxOD0xfDIzPTB8MjQ9MHwyNz18Mjg9MHwzMT0weAA%3D";
		
		final String requestXML = (String) (new MyRequestDecoder()).apply(requestContent.getBytes());
		System.out.println(requestXML);
		
		final String reencodedRequestContent =  new String((new MyEncoder()).apply(requestXML));
		System.out.println(reencodedRequestContent);
		
		final String requestXML2 = (String) (new MyRequestDecoder()).apply(reencodedRequestContent.getBytes());
		System.out.println(requestXML2);
		
		final String reencodedRequestContent2 =  new String((new MyEncoder()).apply(requestXML2));
		System.out.println(reencodedRequestContent2);
	}
	
	public static void testResponse() {
		final String responseContent = "rO0ABXNyACJjb20ubnRzdC5yYWRwbHVzLmNvbW1vbi5DbGllbnREYXRhSO08GoZRPvsCAAZMAA1hdXhQcm9wZXJ0aWVzdAAWTGphdmEvdXRpbC9Qcm9wZXJ0aWVzO0wABmlkRGF0YXQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABmlkTmFtZXEAfgACTAAFaWROdW1xAH4AAkwACGlkU3RhdHVzcQB+AAJMAAZpZFR5cGVxAH4AAnhwc3IAFGphdmEudXRpbC5Qcm9wZXJ0aWVzORLQenA2PpgCAAFMAAhkZWZhdWx0c3EAfgABeHIAE2phdmEudXRpbC5IYXNodGFibGUTuw8lIUrkuAMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAIdwgAAAALAAAAAHhwdAAXJU5PR1ZBUklEJXwxfENsaWVudHwgfCB0AAEgdAAKJU5PR1ZBUklEJXQAATF0AAZDbGllbnQ=";
		
		final Object response = (new MyResponseDecoder()).apply(responseContent.getBytes());
		System.out.println(response.toString());
	}
}
