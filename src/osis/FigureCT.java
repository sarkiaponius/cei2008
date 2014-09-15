//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.15 at 10:54:55 PM CEST 
//


package osis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for figureCT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="figureCT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="caption" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}captionCT"/>
 *         &lt;element name="index" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}indexCT"/>
 *         &lt;element name="note" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}noteCT"/>
 *         &lt;element name="reference" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}referenceCT"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.bibletechnologies.net/2003/OSIS/namespace}globalWithType"/>
 *       &lt;attribute name="alt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="canonical" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="catalog" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="location" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="osisRef" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}osisRefType" />
 *       &lt;attribute name="rights" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="src" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TEIform" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="figure" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "figureCT", propOrder = {
    "captionOrIndexOrNote"
})
public class FigureCT {

    @XmlElements({
        @XmlElement(name = "reference", type = ReferenceCT.class),
        @XmlElement(name = "index", type = IndexCT.class),
        @XmlElement(name = "caption", type = CaptionCT.class),
        @XmlElement(name = "note", type = NoteCT.class)
    })
    protected List<Object> captionOrIndexOrNote;
    @XmlAttribute
    protected String alt;
    @XmlAttribute
    protected Boolean canonical;
    @XmlAttribute
    protected String catalog;
    @XmlAttribute
    protected String location;
    @XmlAttribute
    protected List<String> osisRef;
    @XmlAttribute
    protected String rights;
    @XmlAttribute
    protected String size;
    @XmlAttribute
    protected String src;
    @XmlAttribute(name = "TEIform")
    @XmlSchemaType(name = "anySimpleType")
    protected String teIform;
    @XmlAttribute
    protected List<String> annotateRef;
    @XmlAttribute
    protected String annotateWork;
    @XmlAttribute
    protected String annotateType;
    @XmlAttribute
    @XmlSchemaType(name = "NMTOKENS")
    protected List<String> editions;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute
    protected List<String> osisID;
    @XmlAttribute
    protected String resp;
    @XmlAttribute
    protected String subType;
    @XmlAttribute
    protected String n;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    protected String lang;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String space;
    @XmlAttribute
    protected String script;

    /**
     * Gets the value of the captionOrIndexOrNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the captionOrIndexOrNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaptionOrIndexOrNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceCT }
     * {@link IndexCT }
     * {@link CaptionCT }
     * {@link NoteCT }
     * 
     * 
     */
    public List<Object> getCaptionOrIndexOrNote() {
        if (captionOrIndexOrNote == null) {
            captionOrIndexOrNote = new ArrayList<Object>();
        }
        return this.captionOrIndexOrNote;
    }

    /**
     * Gets the value of the alt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlt() {
        return alt;
    }

    /**
     * Sets the value of the alt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlt(String value) {
        this.alt = value;
    }

    /**
     * Gets the value of the canonical property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanonical() {
        return canonical;
    }

    /**
     * Sets the value of the canonical property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanonical(Boolean value) {
        this.canonical = value;
    }

    /**
     * Gets the value of the catalog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * Sets the value of the catalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalog(String value) {
        this.catalog = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the osisRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the osisRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOsisRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOsisRef() {
        if (osisRef == null) {
            osisRef = new ArrayList<String>();
        }
        return this.osisRef;
    }

    /**
     * Gets the value of the rights property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRights() {
        return rights;
    }

    /**
     * Sets the value of the rights property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRights(String value) {
        this.rights = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Gets the value of the src property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrc() {
        return src;
    }

    /**
     * Sets the value of the src property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrc(String value) {
        this.src = value;
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
            return "figure";
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

    /**
     * Gets the value of the annotateRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the annotateRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnotateRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAnnotateRef() {
        if (annotateRef == null) {
            annotateRef = new ArrayList<String>();
        }
        return this.annotateRef;
    }

    /**
     * Gets the value of the annotateWork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnotateWork() {
        return annotateWork;
    }

    /**
     * Sets the value of the annotateWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnotateWork(String value) {
        this.annotateWork = value;
    }

    /**
     * Gets the value of the annotateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnotateType() {
        return annotateType;
    }

    /**
     * Sets the value of the annotateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnotateType(String value) {
        this.annotateType = value;
    }

    /**
     * Gets the value of the editions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the editions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEditions() {
        if (editions == null) {
            editions = new ArrayList<String>();
        }
        return this.editions;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the osisID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the osisID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOsisID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOsisID() {
        if (osisID == null) {
            osisID = new ArrayList<String>();
        }
        return this.osisID;
    }

    /**
     * Gets the value of the resp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResp() {
        return resp;
    }

    /**
     * Sets the value of the resp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResp(String value) {
        this.resp = value;
    }

    /**
     * Gets the value of the subType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * Gets the value of the n property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN() {
        return n;
    }

    /**
     * Sets the value of the n property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN(String value) {
        this.n = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the space property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpace() {
        return space;
    }

    /**
     * Sets the value of the space property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpace(String value) {
        this.space = value;
    }

    /**
     * Gets the value of the script property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScript() {
        return script;
    }

    /**
     * Sets the value of the script property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScript(String value) {
        this.script = value;
    }

}