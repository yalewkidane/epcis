.. _usage:



Usage
========


Capturing 
--------------

Event Data Capture Example(Object Event)
*************************************************
.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/Service/EventCapture
	Header :	Content-Type : application/xml

**Body:**

.. code-block:: XML
	
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<!DOCTYPE project>
	<epcis:EPCISDocument xmlns:epcis="urn:epcglobal:epcis:xsd:1"
		xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:example0="http://ns.example.com/epcis0" xmlns:example1="http://ns.example.com/epcis1"
		xmlns:example2="http://ns.example.com/epcis2" xmlns:example3="http://ns.example.com/epcis3"
		xmlns:example="http://ns.example.com/epcis" creationDate="2005-07-11T11:30:47.0Z"
		schemaVersion="1.2">
		<EPCISBody>
			<EventList>
				<ObjectEvent>
					<eventTime>2005-04-04T20:33:31.116-06:00</eventTime>
					<eventTimeZoneOffset>-06:00</eventTimeZoneOffset>
					<epcList>
						<epc>urn:epc:id:sgtin:0614141.107346.2018</epc>
					</epcList>
					<action>OBSERVE</action>
					<bizStep>urn:epcglobal:cbv:bizstep:receiving</bizStep>
					<disposition>urn:epcglobal:cbv:disp:in_progress</disposition>
					<readPoint>
						<id>urn:epc:id:sgln:0012345.11111.400</id>
					</readPoint>
					<bizLocation>
						<id>urn:epc:id:sgln:0012345.11111.0</id>
					</bizLocation>
					<bizTransactionList>
						<bizTransaction type="urn:epcglobal:cbv:btt:po">http://transaction.acme.com/po/12345678</bizTransaction>
						<bizTransaction type="urn:epcglobal:cbv:btt:desadv">urn:epcglobal:cbv:bt:0614141073467:1152</bizTransaction>
					</bizTransactionList>
					<extension>
						<quantityList>
							<quantityElement>
								<epcClass>urn:epc:class:lgtin:4012345.012345.998877</epcClass>
								<quantity>200</quantity>
								<uom>KGM</uom>
								<!-- Meaning: 200 kg of GTIN '04012345123456' belonging to lot '998877' -->
							</quantityElement>
						</quantityList>
						<sourceList>
							<source type="urn:epcglobal:cbv:sdt:possessing_party">urn:epc:id:sgln:4012345.00001.0</source>
							<!-- Party which had physical possession at the originating endpoint 
								of the business transfer, e.g., a forwarder -->
							<source type="urn:epcglobal:cbv:sdt:location">urn:epc:id:sgln:4012345.00225.0</source>
							<!-- Physical location of the originating endpoint, e.g., a distribution 
								centre of the forwarder -->
						</sourceList>
						<destinationList>
							<destination type="urn:epcglobal:cbv:sdt:owning_party">urn:epc:id:sgln:0614141.00001.0</destination>
							<!-- Party which owns the physical objects at the terminating endpoint, 
								e.g., a retail company -->
							<destination type="urn:epcglobal:cbv:sdt:location">urn:epc:id:sgln:0614141.00777.0</destination>
							<!-- Physical location of the terminating endpoint, e.g., a warehouse 
								of the retail company -->
						</destinationList>
						<ilmd>
							<example0:a xsi:type="xsd:int">16</example0:a>
							<example0:b>
								<example1:c xsi:type="xsd:double">21.5</example1:c>
							</example0:b>
							<example0:h>
								<example1:d xsi:type="xsd:boolean">false</example1:d>
								<example1:e>
									<example2:f xsi:type="xsd:dateTime">2015-06-08T14:58:56.591Z</example2:f>
								</example1:e>
								<example1:g xsi:type="xsd:long">80</example1:g>
							</example0:h>
						</ilmd>
					</extension>
					<example0:a xsi:type="xsd:int">15</example0:a>
					<example0:b>
						<example1:c xsi:type="xsd:double">20.5</example1:c>
					</example0:b>
					<example0:h>
						<example1:d xsi:type="xsd:boolean">true</example1:d>
						<example1:e>
							<example2:f xsi:type="xsd:dateTime">2013-06-08T14:58:56.591Z</example2:f>
						</example1:e>
						<example1:g xsi:type="xsd:long">50</example1:g>
					</example0:h>
				</ObjectEvent>
			</EventList>
		</EPCISBody>
	</epcis:EPCISDocument>


**Response:**

.. code-block:: JSON

	{"eventCaptured":1}


Master data Capture  Example
*************************************************

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/Service/EventCapture
	Header :	Content-Type : application/xml

**Body:**

.. code-block:: XML

	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE project>
	<epcis:EPCISDocument xmlns:epcis="urn:epcglobal:epcis:xsd:1"
		xmlns:p="http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader"
		xmlns:example="http://ns.example.com/epcis" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		creationDate="2005-07-11T11:30:47.0Z" schemaVersion="1.2">
		<EPCISHeader>
			<p:StandardBusinessDocumentHeader>
			    <!-- Required -->
				<p:HeaderVersion>1.2</p:HeaderVersion>
				<p:Sender>
					<p:Identifier Authority="">p:Identifier</p:Identifier>
				</p:Sender>
				<p:Receiver>
					<p:Identifier Authority="">p:Identifier</p:Identifier>
				</p:Receiver>
				<p:DocumentIdentification>
				    <!-- Required -->
					<p:Standard>EPCglobal</p:Standard>
					<!-- Required -->
					<p:TypeVersion>1.2</p:TypeVersion>
					<p:InstanceIdentifier>p:InstanceIdentifier</p:InstanceIdentifier>
					<!-- Required -->
					<p:Type>MasterData</p:Type>
					<p:MultipleType>true</p:MultipleType>
					<p:CreationDateAndTime>2001-12-31T12:00:00</p:CreationDateAndTime>
				</p:DocumentIdentification>
			</p:StandardBusinessDocumentHeader>
			<extension>
				<EPCISMasterData>
					<VocabularyList>
						<Vocabulary type="urn:epcglobal:epcis:vtype:BusinessLocation">
							<VocabularyElementList>
								<VocabularyElement id="urn:epc:id:sgln:0037000.00729.0">
									<attribute id="http://epcis.example.com/mda/latitude">+18.0000</attribute>
									<attribute id="http://epcis.example.com/mda/longitude">-70.0000</attribute>
									<attribute id="http://epcis.example.com/mda/address">
										<example:Address xmlns:example="http://epcis.example.com/ns">
											<Street>100 Nowhere Street</Street>
											<City>Fancy</City>
											<State>DC</State>
											<Zip>99999</Zip>
										</example:Address>
									</attribute>
									<children>
										<id>urn:epc:id:sgln:0037000.00729.8201</id>
										<id>urn:epc:id:sgln:0037000.00729.8202</id>
										<id>urn:epc:id:sgln:0037000.00729.8203</id>
									</children>
								</VocabularyElement>
								<VocabularyElement id="urn:epc:id:sgln:0037000.00729.8201">
									<attribute id="urn:epcglobal:cbv:mda:sst">201</attribute>
								</VocabularyElement>
								<VocabularyElement id="urn:epc:id:sgln:0037000.00729.8202">
									<attribute id="urn:epcglobal:cbv:mda:sst">202</attribute>
									<children>
										<id>urn:epc:id:sgln:0037000.00729.8203</id>
									</children>
								</VocabularyElement>
								<VocabularyElement id="urn:epc:id:sgln:0037000.00729.8203">
									<attribute id="urn:epcglobal:cbv:mda:sst">202</attribute>
									<attribute id="urn:epcglobal:cbv:mda:ssa">402</attribute>
								</VocabularyElement>
							</VocabularyElementList>
						</Vocabulary>
						<Vocabulary type="urn:epcglobal:epcis:vtype:ReadPoint">
							<VocabularyElementList>
								<VocabularyElement id="urn:epc:id:sgln:0037000.00729.8201">
									<attribute id="urn:epcglobal:cbv:mda:site">0037000007296</attribute>
									<attribute id="urn:epcglobal:cbv:mda:sst">201</attribute>
								</VocabularyElement>
								<VocabularyElement id="urn:epc:id:sgln:0037000.00729.8202">
									<attribute id="urn:epcglobal:cbv:mda:site">0037000007296</attribute>
									<attribute id="urn:epcglobal:cbv:mda:sst">202</attribute>
								</VocabularyElement>
								<VocabularyElement id="urn:epc:id:sgln:0037000.00729.8203">
									<attribute id="urn:epcglobal:cbv:mda:site">0037000007296</attribute>
									<attribute id="urn:epcglobal:cbv:mda:sst">203</attribute>
								</VocabularyElement>
							</VocabularyElementList>
						</Vocabulary>
					</VocabularyList>
				</EPCISMasterData>
			</extension>
		</EPCISHeader>
		<EPCISBody>
			<EventList>
			</EventList>
		</EPCISBody>
	</epcis:EPCISDocument>

**Response:**

.. code-block:: JSON

	{"vocabularyCaptured":"7"}


Quering 
-------------

SOAP Interface
*************************

Simple Event Query
+++++++++++++++++++++++++


.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/webservice/QueryService
	Header :	Content-Type : application/xml

**Body:**

.. code-block:: XML

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:query="urn:epcglobal:epcis-query:xsd:1">
	   <soapenv:Header/>
	   <soapenv:Body>
	       <query:Poll>
	           <queryName>SimpleEventQuery</queryName>
	           <params>
	    <param><name>eventType</name>
	      <value> <string>ObjectEvent</string> </value>
	    </param>
	    <param><name>MATCH_epc</name>
	      <value><string>urn:epc:id:sgtin:0614141.107346.2020</string></value>
	    </param>
	    <param> <name>eventCountLimit</name>
	      <value><int>1</int></value>
	    </param>
	    <param> <name>orderBy</name>
	      <value><string>eventTime</string>orderDirection</value>
	    </param>
	    <param> <name>orderDirection</name>
	      <value><string>DESC</string></value>
	    </param>
	  </params> 
	       </query:Poll>
	   </soapenv:Body>
	</soapenv:Envelope> 

**Response:**

.. code-block:: XML

	<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	    <soap:Body>
	        <ns3:QueryResults xmlns:ns4="urn:epcglobal:epcis:xsd:1" xmlns:ns3="urn:epcglobal:epcis-query:xsd:1" xmlns:ns2="http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader">
	            <queryName>SimpleEventQuery</queryName>
	            <resultsBody>
	                <EventList>
	                    <ObjectEvent>
	                        <eventTime>2005-04-05T02:33:31.116Z</eventTime>
	                        <recordTime>2020-06-03T12:23:18.469Z</recordTime>
	                        <eventTimeZoneOffset>-06:00</eventTimeZoneOffset>
	                        <baseExtension>
	                            <eventID>5ed79636dd5117154d6fb740</eventID>
	                        </baseExtension>
	                        <epcList>
	                            <epc>urn:epc:id:sgtin:0614141.107346.2020</epc>
	                        </epcList>
	                        <action>OBSERVE</action>
	                        <bizStep>urn:epcglobal:cbv:bizstep:receiving</bizStep>
	                        <disposition>urn:epcglobal:cbv:disp:in_progress</disposition>
	                        <readPoint>
	                            <id>urn:epc:id:sgln:0012345.11111.400</id>
	                        </readPoint>
	                        ---
	                    </ObjectEvent>
	                </EventList>
	            </resultsBody>
	        </ns3:QueryResults>
	    </soap:Body>
	</soap:Envelope>


Simple Master Data Query
+++++++++++++++++++++++++++++

**Get all the vocabularies**  



.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/webservice/QueryService
	Header :	Content-Type : application/xml

Body:

.. code-block:: XML

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:query="urn:epcglobal:epcis-query:xsd:1">
	   <soapenv:Body>
	       <query:Poll>
	           <queryName>SimpleMasterDataQuery</queryName>
		<params>
	    	<param><name>includeAttributes</name>
	    	<value><boolean>true</boolean></value>
	    		</param>
	    		<param><name>includeChildren</name>
	    			<value><boolean>true</boolean></value>
	    		</param>
	    			
		</params>
	       </query:Poll>
	   </soapenv:Body>
	</soapenv:Envelope> 


Response:


.. code-block:: XML

	<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	    <soap:Body>
	        <ns3:QueryResults xmlns:ns4="urn:epcglobal:epcis:xsd:1" xmlns:ns3="urn:epcglobal:epcis-query:xsd:1" xmlns:ns2="http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader">
	            <queryName>SimpleMasterDataQuery</queryName>
	            <resultsBody>
	                <EventList/>
	                <VocabularyList>
	                    <Vocabulary type="urn:epcglobal:epcis:vtype:EPCInstance">
	                        <VocabularyElementList>
	                            <VocabularyElement id="urn:epc:id:sgtin:0614141.107346.2018">
	                                <attribute id="@http://ns.example.com/epcis0">example0</attribute>
	                                <attribute id="http://ns.example.com/epcis0#a">16</attribute>
	                                <attribute id="http://ns.example.com/epcis0#b">
	                                    <example1:c xmlns:example1="http://ns.example.com/epcis1">21.5</example1:c>
	                                </attribute>
	                                <attribute id="http://ns.example.com/epcis0#h">
	                                    <example1:d xmlns:example1="http://ns.example.com/epcis1">false</example1:d>
	                                    <example1:e xmlns:example1="http://ns.example.com/epcis1">
	                                        <example2:f xmlns:example2="http://ns.example.com/epcis2">2015-06-08T23:58:56.591+09:00</example2:f>
	                                    </example1:e>
	                                    <example1:g xmlns:example1="http://ns.example.com/epcis1">80</example1:g>
	                                </attribute>
	                                <attribute id="lastUpdated">1590477300570</attribute>
	                            </VocabularyElement>
	                        </VocabularyElementList>
	                    </Vocabulary>
	                    <Vocabulary type="urn:epcglobal:epcis:vtype:QualityGroupProduct">
	                        <VocabularyElementList>
	                            <VocabularyElement id="urn:epc:id:sgln: 880968822.107.QLG11">
	                                <attribute id="http://www.kfri.co.kr/epcis/minTemp">-5.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/maxTemp">25.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/maxTemp">0.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/minHum">0.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/minQval">0.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/initQval">0.000000</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/expDate">90</attribute>
	                                <attribute id="lastUpdated">1591104617569</attribute>
	                            </VocabularyElement>
	                        </VocabularyElementList>
	                    </Vocabulary>
	                    ---
	                </VocabularyList>
	            </resultsBody>
	        </ns3:QueryResults>
	    </soap:Body>
	</soap:Envelope>


**Using Vocabulary Type**




.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/webservice/QueryService
	Header :	Content-Type : application/xml

Body:

.. code-block:: XML

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:query="urn:epcglobal:epcis-query:xsd:1">
	   <soapenv:Body>
	       <query:Poll>
	           <queryName>SimpleMasterDataQuery</queryName>
		<params>
	    	<param><name>includeAttributes</name>
	    	<value><boolean>true</boolean></value>
	    		</param>
	    		<param><name>includeChildren</name>
	    			<value><boolean>true</boolean></value>
	    		</param>
	    		<param><name>vocabularyName</name>
    				<value><string>urn:epcglobal:epcis:vtype:QualityGroupProduct</string></value>
    			</param>
		</params>
	       </query:Poll>
	   </soapenv:Body>
	</soapenv:Envelope> 


Response:


.. code-block:: XML

	<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	    <soap:Body>
	        <ns3:QueryResults xmlns:ns4="urn:epcglobal:epcis:xsd:1" xmlns:ns3="urn:epcglobal:epcis-query:xsd:1" xmlns:ns2="http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader">
	            <queryName>SimpleMasterDataQuery</queryName>
	            <resultsBody>
	                <EventList/>
	                <VocabularyList>
	                    <Vocabulary type="urn:epcglobal:epcis:vtype:QualityGroupProduct">
	                        <VocabularyElementList>
	                            <VocabularyElement id="urn:epc:id:sgln: 880968822.107.QLG11">
	                                <attribute id="http://www.kfri.co.kr/epcis/minTemp">-5.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/maxTemp">25.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/maxTemp">0.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/minHum">0.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/minQval">0.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/initQval">0.000000</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/expDate">90</attribute>
	                                <attribute id="lastUpdated">1591104617569</attribute>
	                            </VocabularyElement>
	                        </VocabularyElementList>
	                    </Vocabulary>
	                    - - -
	                </VocabularyList>
	            </resultsBody>
	        </ns3:QueryResults>
	    </soap:Body>
	</soap:Envelope>


**By Using VocabularyElement id**

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/webservice/QueryService
	Header :	Content-Type : application/xml

Body:

.. code-block:: XML

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:query="urn:epcglobal:epcis-query:xsd:1">
		   <soapenv:Body>
		       <query:Poll>
		           <queryName>SimpleMasterDataQuery</queryName>
			<params>
		    	<param><name>includeAttributes</name>
		    	<value><boolean>true</boolean></value>
		    		</param>
		    		<param><name>includeChildren</name>
		    			<value><boolean>true</boolean></value>
		    		</param>
		    		<param><name>vocabularyName</name>
	    				<value><string>urn:epcglobal:epcis:vtype:QualityGroupProduct</string></value>
	    			</param>
	    			<param>
	    			<name>EQ_name</name>
	    			<value><string>urn:epc:id:sgln: 880968822.107.QLG01</string></value>    
					</param>
			</params>
		       </query:Poll>
		   </soapenv:Body>
	</soapenv:Envelope> 


Response:


.. code-block:: XML

	<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	    <soap:Body>
	        <ns3:QueryResults xmlns:ns4="urn:epcglobal:epcis:xsd:1" xmlns:ns3="urn:epcglobal:epcis-query:xsd:1" xmlns:ns2="http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader">
	            <queryName>SimpleMasterDataQuery</queryName>
	            <resultsBody>
	                <EventList/>
	                <VocabularyList>
	                    <Vocabulary type="urn:epcglobal:epcis:vtype:QualityGroupProduct">
	                        <VocabularyElementList>
	                            <VocabularyElement id="urn:epc:id:sgln: 880968822.107.QLG01">
	                                <attribute id="http://www.kfri.co.kr/epcis/minTemp">10.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/maxTemp">20.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/maxTemp">90.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/minHum">40.00</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/minQval">8.44</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/initQval">3.741417</attribute>
	                                <attribute id="http://www.kfri.co.kr/epcis/expDate">15</attribute>
	                                <attribute id="lastUpdated">1591104617580</attribute>
	                            </VocabularyElement>
	                        </VocabularyElementList>
	                    </Vocabulary>
	                </VocabularyList>
	            </resultsBody>
	        </ns3:QueryResults>
	    </soap:Body>
	</soap:Envelope>	



**By Using Vocabulary attribute id** 


.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/webservice/QueryService
	Header :	Content-Type : application/xml

Body:

.. code-block:: XML

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:query="urn:epcglobal:epcis-query:xsd:1">
		   <soapenv:Body>
		       <query:Poll>
		           <queryName>SimpleMasterDataQuery</queryName>
			<params>
		    	<param><name>includeAttributes</name>
		    	<value><boolean>true</boolean></value>
		    		</param>
		    		<param><name>includeChildren</name>
		    			<value><boolean>true</boolean></value>
		    		</param>
		    		<param><name>vocabularyName</name>
	    				<value><string>urn:epcglobal:epcis:vtype:QualityGroupProduct</string></value>
	    			</param>
	    			<param>
	    				<name>EQ_name</name>
	    				<value><string>urn:epc:id:sgln: 880968822.107.QLG01</string></value>    
					</param>
					<param>
	    				<name>HASATTR</name>
	    				<value><string>http://www.kfri.co.kr/epcis/minTemp</string></value>    
					</param>
			</params>
		       </query:Poll>
		   </soapenv:Body>
	</soapenv:Envelope> 


**Using Vacabulary attribute value**  

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/webservice/QueryService
	Header :	Content-Type : application/xml

Body:

.. code-block:: XML

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:query="urn:epcglobal:epcis-query:xsd:1">
		   <soapenv:Body>
		       <query:Poll>
		           <queryName>SimpleMasterDataQuery</queryName>
			<params>
		    	<param><name>includeAttributes</name>
		    	<value><boolean>true</boolean></value>
		    		</param>
		    		<param><name>includeChildren</name>
		    			<value><boolean>true</boolean></value>
		    		</param>
					<param>
						
	    			<name>EQATTR_urn:epcglobal:cbv:mda:sst</name>
	    			<value><string>202</string></value>    
					</param>

			</params>
		       </query:Poll>
		   </soapenv:Body>
	</soapenv:Envelope> 


REST Interface 
********************

Simple Event Query
+++++++++++++++++++++++++

MATCH_epc

.. code-block:: RST

	Method :	GET
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleEventQuery?MATCH_epc=urn:epc:id:sgtin:0614141.107346.2020
	Header :	Content-Type : application/xml

**Response:**

.. code-block:: XML

	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<EPCISQueryDocumentType xmlns:ns2="http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader" xmlns:ns4="urn:epcglobal:epcis:xsd:1" xmlns:ns3="urn:epcglobal:epcis-query:xsd:1">
	    <EPCISBody>
	        <ns3:QueryResults>
	            <queryName>SimpleEventQuery</queryName>
	            <resultsBody>
	                <EventList>
	                    <ObjectEvent>
	                        <eventTime>2005-04-05T02:33:31.116Z</eventTime>
	                        <recordTime>2020-06-03T12:23:18.469Z</recordTime>
	                        <eventTimeZoneOffset>-06:00</eventTimeZoneOffset>
	                        <baseExtension>
	                            <eventID>5ed79636dd5117154d6fb740</eventID>
	                        </baseExtension>
	                        <epcList>
	                            <epc>urn:epc:id:sgtin:0614141.107346.2020</epc>
	                        </epcList>
	                        <action>OBSERVE</action>
	                        <bizStep>urn:epcglobal:cbv:bizstep:receiving</bizStep>
	                        <disposition>urn:epcglobal:cbv:disp:in_progress</disposition>
	                          - - -
	                        
	                    </ObjectEvent>
	                </EventList>
	            </resultsBody>
	        </ns3:QueryResults>
	    </EPCISBody>
	</EPCISQueryDocumentType>


MATCH_epc

.. code-block:: RST

	Method :	GET
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleEventQuery?MATCH_epc=urn:epc:id:sgtin:0614141.*
	Header :	Content-Type : application/xml


eventTime and recordTime: | GE_eventTime | GE_recordTime

.. code-block:: RST

	Method :	GET
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleEventQuery?GE_eventTime=2021-06-03T03:33:31.116Z
	Header :	Content-Type : application/xml

Simple Master Data Query
++++++++++++++++++++++++++++

**Get all the vocabularies** 

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleMasterDataQuery?includeAttributes=true&includeChildren=true
	Header :	Content-Type : application/xml

**Using Vocabulary Type**

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleMasterDataQuery?includeAttributes=true&includeChildren=true&vocabularyName=urn:epcglobal:epcis:vtype:EPCInstance
	Header :	Content-Type : application/xml


**By Using VocabularyElement id** 

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleMasterDataQuery?includeAttributes=true&includeChildren=true&EQ_name=urn:epc:id:sgtin:0614141.107346.2020
	Header :	Content-Type : application/xml

**By Using Vocabulary attribute id** 

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleMasterDataQuery?includeAttributes=true&includeChildren=true&HASATTR=http://ns.example.com/epcis0%23a
	Header :	Content-Type : application/xml



**Using Vacabulary attribute value**

.. code-block:: RST

	Method :	POST
	URL :		http://{IP}:{PORT}/epcis/Service/Poll/SimpleMasterDataQuery?includeAttributes=true&includeChildren=true&EQATTR_urn:epcglobal:cbv:mda:site=0037000007296


