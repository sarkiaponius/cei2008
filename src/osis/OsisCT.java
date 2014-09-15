//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.15 at 10:54:55 PM CEST 
//


package osis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for osisCT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="osisCT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="osisCorpus" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}osisCorpusCT" minOccurs="0"/>
 *         &lt;element name="osisText" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}osisTextCT" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="TEIform" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="TEI.2" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "osisCT", propOrder = {
    "osisCorpus",
    "osisText"
})
public class OsisCT {

    protected OsisCorpusCT osisCorpus;
    protected OsisTextCT osisText;
    @XmlAttribute(name = "TEIform")
    @XmlSchemaType(name = "anySimpleType")
    protected String teIform;

    /**
     * Gets the value of the osisCorpus property.
     * 
     * @return
     *     possible object is
     *     {@link OsisCorpusCT }
     *     
     */
    public OsisCorpusCT getOsisCorpus() {
        return osisCorpus;
    }

    /**
     * Sets the value of the osisCorpus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OsisCorpusCT }
     *     
     */
    public void setOsisCorpus(OsisCorpusCT value) {
        this.osisCorpus = value;
    }

    /**
     * Gets the value of the osisText property.
     * 
     * @return
     *     possible object is
     *     {@link OsisTextCT }
     *     
     */
    public OsisTextCT getOsisText() {
        return osisText;
    }

    /**
     * Sets the value of the osisText property.
     * 
     * @param value
     *     allowed object is
     *     {@link OsisTextCT }
     *     
     */
    public void setOsisText(OsisTextCT value) {
        this.osisText = value;
    }

    /**
     * Gets the value of the teIform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEIform() {
        if (teIform == null) {
            return "TEI.2";
        } else {
            return teIform;
        }
    }

    /**
     * Sets the value of the teIform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEIform(String value) {
        this.teIform = value;
    }

}