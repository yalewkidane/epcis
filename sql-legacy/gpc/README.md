### GS1 Code Parser ###
Copyright (C) 2015 Jaewook Byun

### Introduction ###
> GS1 Code Parser is a utility to deal with GS1 codes (e.g. GS1 Application Identifier, Hex-encoded RFID tag)

> Written in Java

### Method ###
> AICodeParser Class
>> public String fillChecksum(String code,int gcpLength): Fill checksum digit of GS1 AI and Element String

>> e.g. (01)8061414112345* + 7 gcpLength --> (01)80614141123458

>> SSCC, GTIN, GDTI, SGCN, SGLN, GRAI, GSRNP, GSRN supported

>> public HashMap<String, String> parse(String code, int gcpLength): Parse sequence of multiple GS1 AI and Element String

>> e.g. (01)80614141123458(21)6789(10)4222(414)0614141123452(254)333 + 7 gcpLength --> 

>>> Then, HashMap contains

>>>    sgtin = urn:epc:id :sgtin:0614141.812345.6789

>>>   lgtin = urn:epc:class:lgtin:0614141.812345.4222

>>>    gtin = urn:epc:id pat:sgtin:0614141.812345.*

>>>   sgln = urn:epc:id :sgln:0614141.12345.333

>> SSCC, GTIN, SGTIN, LGTIN, GDTI, SGCN, SGLN, GRAI, GIAI, CPI, GSRNP, GSRN,  ai:11, ai:13, ai:30, ai:310n, ai:390n supported 

```java
public void testSgtinAndLgtinAndSgln() {
		AICodeParser codeParser = new AICodeParser();
		String slgtin = "(01)80614141123458(21)6789(10)4222(414)0614141123452(254)333";
		int gcpLength = 7;
		HashMap<String, String> collection = codeParser.parse(slgtin, gcpLength);
		System.out.println("[TEST]" + slgtin + " includes " + collection.get("sgtin"));
		assertTrue(collection.get("sgtin").equals("urn:epc:id:sgtin:0614141.812345.6789"));
		System.out.println("[TEST]" + slgtin + " includes " + collection.get("lgtin"));
		assertTrue(collection.get("lgtin").equals("urn:epc:class:lgtin:0614141.812345.4222"));
		System.out.println("[TEST]" + slgtin + " includes " + collection.get("sgln"));
		assertTrue(collection.get("sgln").equals("urn:epc:id:sgln:0614141.12345.333"));
}
```

Electronic Product Code Information Service (EPCIS) enables to capture and share EPC-based event 
> ( Basically RFID Tag event ).
> With EPCIS, event producer (e.g. RFID middleware) generates and sends events
> complying with EPCIS Document XML schema into EPCIS Repository. 
> Then, these events can be globally shared with given queries 

### Contact ###
> Korea Advanced Institute of Science and Technology (KAIST)

> Real-time and Embedded Systems Laboratory(RESL)

> Auto-ID Labs @ Korea

> Maintainer:

>> Jaewook Byun, Ph.D student : bjw0829@kaist.ac.kr, bjw0829@gmail.com
