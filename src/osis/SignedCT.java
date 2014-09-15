//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.15 at 10:54:55 PM CEST 
//


package osis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for signedCT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signedCT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneable">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="a" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}aCT"/>
 *         &lt;element name="abbr" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}abbrCT"/>
 *         &lt;element name="divineName" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}divineNameCT"/>
 *         &lt;element name="foreign" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}foreignCT"/>
 *         &lt;element name="hi" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}hiCT"/>
 *         &lt;element name="index" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}indexCT"/>
 *         &lt;element name="lb" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}lbCT"/>
 *         &lt;element name="milestone" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneCT"/>
 *         &lt;element name="milestoneEnd" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneEndCT"/>
 *         &lt;element name="milestoneStart" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneStartCT"/>
 *         &lt;element name="name" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}nameCT"/>
 *         &lt;element name="note" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}noteCT"/>
 *         &lt;element name="reference" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}referenceCT"/>
 *         &lt;element name="seg" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}segCT"/>
 *         &lt;element name="w" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}wCT"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.bibletechnologies.net/2003/OSIS/namespace}globalWithType"/>
 *       &lt;attribute name="canonical" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="TEIform" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="signed" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signedCT", propOrder = {
    "content"
})
public class SignedCT {

    @XmlElementRefs({
        @XmlElementRef(name = "name", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "foreign", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "a", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "hi", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "abbr", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "index", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "divineName", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "lb", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "milestone", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "reference", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "seg", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "milestoneStart", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "note", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "milestoneEnd", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "w", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute
    protected Boolean canonical;
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
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link JAXBElement }{@code <}{@link NameCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ForeignCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ACT }{@code >}
     * {@link JAXBElement }{@code <}{@link HiCT }{@code >}
     * {@link JAXBElement }{@code <}{@link AbbrCT }{@code >}
     * {@link JAXBElement }{@code <}{@link IndexCT }{@code >}
     * {@link JAXBElement }{@code <}{@link DivineNameCT }{@code >}
     * {@link JAXBElement }{@code <}{@link LbCT }{@code >}
     * {@link JAXBElement }{@code <}{@link MilestoneCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ReferenceCT }{@code >}
     * {@link JAXBElement }{@code <}{@link SegCT }{@code >}
     * {@link JAXBElement }{@code <}{@link MilestoneStartCT }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteCT }{@code >}
     * {@link JAXBElement }{@code <}{@link MilestoneEndCT }{@code >}
     * {@link JAXBElement }{@code <}{@link WCT }{@code >}
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
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
     * Gets the value of the teIform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEIform() {
        if (teIform == null) {
            return "signed";
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