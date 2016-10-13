//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.15 at 01:39:48 PM KST 
//

package org.oliot.model.epcis;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.mongodb.core.mapping.Document;
import org.w3c.dom.Element;

/**
 * 
 * Transformation Event captures an event in which inputs are consumed and
 * outputs are produced
 * 
 * 
 * <p>
 * Java class for TransformationEventType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TransformationEventType">
 *   &lt;complexContent>
 *     &lt;extension base="{axis.epcis.oliot.org}EPCISEventType">
 *       &lt;sequence>
 *         &lt;element name="inputEPCList" type="{axis.epcis.oliot.org}EPCListType" minOccurs="0"/>
 *         &lt;element name="inputQuantityList" type="{axis.epcis.oliot.org}QuantityListType" minOccurs="0"/>
 *         &lt;element name="outputEPCList" type="{axis.epcis.oliot.org}EPCListType" minOccurs="0"/>
 *         &lt;element name="outputQuantityList" type="{axis.epcis.oliot.org}QuantityListType" minOccurs="0"/>
 *         &lt;element name="transformationID" type="{axis.epcis.oliot.org}TransformationIDType" minOccurs="0"/>
 *         &lt;element name="bizStep" type="{axis.epcis.oliot.org}BusinessStepIDType" minOccurs="0"/>
 *         &lt;element name="disposition" type="{axis.epcis.oliot.org}DispositionIDType" minOccurs="0"/>
 *         &lt;element name="readPoint" type="{axis.epcis.oliot.org}ReadPointType" minOccurs="0"/>
 *         &lt;element name="bizLocation" type="{axis.epcis.oliot.org}BusinessLocationType" minOccurs="0"/>
 *         &lt;element name="bizTransactionList" type="{axis.epcis.oliot.org}BusinessTransactionListType" minOccurs="0"/>
 *         &lt;element name="sourceList" type="{axis.epcis.oliot.org}SourceListType" minOccurs="0"/>
 *         &lt;element name="destinationList" type="{axis.epcis.oliot.org}DestinationListType" minOccurs="0"/>
 *         &lt;element name="ilmd" type="{axis.epcis.oliot.org}ILMDType" minOccurs="0"/>
 *         &lt;element name="extension" type="{axis.epcis.oliot.org}TransformationEventExtensionType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformationEventType", propOrder = { "inputEPCList",
		"inputQuantityList", "outputEPCList", "outputQuantityList",
		"transformationID", "bizStep", "disposition", "readPoint",
		"bizLocation", "bizTransactionList", "sourceList", "destinationList",
		"ilmd", "extension", "any" })
@Document(collection = "TransformationEvent")
public class TransformationEventType extends EPCISEventType {

	protected EPCListType inputEPCList;

	public void setAny(List<Object> any) {
		this.any = any;
	}

	protected QuantityListType inputQuantityList;
	protected EPCListType outputEPCList;
	protected QuantityListType outputQuantityList;
	protected String transformationID;
	protected String bizStep;
	protected String disposition;
	protected ReadPointType readPoint;
	protected BusinessLocationType bizLocation;
	protected BusinessTransactionListType bizTransactionList;
	protected SourceListType sourceList;
	protected DestinationListType destinationList;
	protected ILMDType ilmd;
	protected TransformationEventExtensionType extension;
	@XmlAnyElement(lax = true)
	protected List<Object> any;

	/**
	 * Gets the value of the inputEPCList property.
	 * 
	 * @return possible object is {@link EPCListType }
	 * 
	 */
	public EPCListType getInputEPCList() {
		return inputEPCList;
	}

	/**
	 * Sets the value of the inputEPCList property.
	 * 
	 * @param value
	 *            allowed object is {@link EPCListType }
	 * 
	 */
	public void setInputEPCList(EPCListType value) {
		this.inputEPCList = value;
	}

	/**
	 * Gets the value of the inputQuantityList property.
	 * 
	 * @return possible object is {@link QuantityListType }
	 * 
	 */
	public QuantityListType getInputQuantityList() {
		return inputQuantityList;
	}

	/**
	 * Sets the value of the inputQuantityList property.
	 * 
	 * @param value
	 *            allowed object is {@link QuantityListType }
	 * 
	 */
	public void setInputQuantityList(QuantityListType value) {
		this.inputQuantityList = value;
	}

	/**
	 * Gets the value of the outputEPCList property.
	 * 
	 * @return possible object is {@link EPCListType }
	 * 
	 */
	public EPCListType getOutputEPCList() {
		return outputEPCList;
	}

	/**
	 * Sets the value of the outputEPCList property.
	 * 
	 * @param value
	 *            allowed object is {@link EPCListType }
	 * 
	 */
	public void setOutputEPCList(EPCListType value) {
		this.outputEPCList = value;
	}

	/**
	 * Gets the value of the outputQuantityList property.
	 * 
	 * @return possible object is {@link QuantityListType }
	 * 
	 */
	public QuantityListType getOutputQuantityList() {
		return outputQuantityList;
	}

	/**
	 * Sets the value of the outputQuantityList property.
	 * 
	 * @param value
	 *            allowed object is {@link QuantityListType }
	 * 
	 */
	public void setOutputQuantityList(QuantityListType value) {
		this.outputQuantityList = value;
	}

	/**
	 * Gets the value of the transformationID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransformationID() {
		return transformationID;
	}

	/**
	 * Sets the value of the transformationID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransformationID(String value) {
		this.transformationID = value;
	}

	/**
	 * Gets the value of the bizStep property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBizStep() {
		return bizStep;
	}

	/**
	 * Sets the value of the bizStep property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBizStep(String value) {
		this.bizStep = value;
	}

	/**
	 * Gets the value of the disposition property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDisposition() {
		return disposition;
	}

	/**
	 * Sets the value of the disposition property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDisposition(String value) {
		this.disposition = value;
	}

	/**
	 * Gets the value of the readPoint property.
	 * 
	 * @return possible object is {@link ReadPointType }
	 * 
	 */
	public ReadPointType getReadPoint() {
		return readPoint;
	}

	/**
	 * Sets the value of the readPoint property.
	 * 
	 * @param value
	 *            allowed object is {@link ReadPointType }
	 * 
	 */
	public void setReadPoint(ReadPointType value) {
		this.readPoint = value;
	}

	/**
	 * Gets the value of the bizLocation property.
	 * 
	 * @return possible object is {@link BusinessLocationType }
	 * 
	 */
	public BusinessLocationType getBizLocation() {
		return bizLocation;
	}

	/**
	 * Sets the value of the bizLocation property.
	 * 
	 * @param value
	 *            allowed object is {@link BusinessLocationType }
	 * 
	 */
	public void setBizLocation(BusinessLocationType value) {
		this.bizLocation = value;
	}

	/**
	 * Gets the value of the bizTransactionList property.
	 * 
	 * @return possible object is {@link BusinessTransactionListType }
	 * 
	 */
	public BusinessTransactionListType getBizTransactionList() {
		return bizTransactionList;
	}

	/**
	 * Sets the value of the bizTransactionList property.
	 * 
	 * @param value
	 *            allowed object is {@link BusinessTransactionListType }
	 * 
	 */
	public void setBizTransactionList(BusinessTransactionListType value) {
		this.bizTransactionList = value;
	}

	/**
	 * Gets the value of the sourceList property.
	 * 
	 * @return possible object is {@link SourceListType }
	 * 
	 */
	public SourceListType getSourceList() {
		return sourceList;
	}

	/**
	 * Sets the value of the sourceList property.
	 * 
	 * @param value
	 *            allowed object is {@link SourceListType }
	 * 
	 */
	public void setSourceList(SourceListType value) {
		this.sourceList = value;
	}

	/**
	 * Gets the value of the destinationList property.
	 * 
	 * @return possible object is {@link DestinationListType }
	 * 
	 */
	public DestinationListType getDestinationList() {
		return destinationList;
	}

	/**
	 * Sets the value of the destinationList property.
	 * 
	 * @param value
	 *            allowed object is {@link DestinationListType }
	 * 
	 */
	public void setDestinationList(DestinationListType value) {
		this.destinationList = value;
	}

	/**
	 * Gets the value of the ilmd property.
	 * 
	 * @return possible object is {@link ILMDType }
	 * 
	 */
	public ILMDType getIlmd() {
		return ilmd;
	}

	/**
	 * Sets the value of the ilmd property.
	 * 
	 * @param value
	 *            allowed object is {@link ILMDType }
	 * 
	 */
	public void setIlmd(ILMDType value) {
		this.ilmd = value;
	}

	/**
	 * Gets the value of the extension property.
	 * 
	 * @return possible object is {@link TransformationEventExtensionType }
	 * 
	 */
	public TransformationEventExtensionType getExtension() {
		return extension;
	}

	/**
	 * Sets the value of the extension property.
	 * 
	 * @param value
	 *            allowed object is {@link TransformationEventExtensionType }
	 * 
	 */
	public void setExtension(TransformationEventExtensionType value) {
		this.extension = value;
	}

	/**
	 * Gets the value of the any property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the any property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAny().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Object }
	 * {@link Element }
	 * 
	 * 
	 */
	public List<Object> getAny() {
		if (any == null) {
			any = new ArrayList<Object>();
		}
		return this.any;
	}

}
