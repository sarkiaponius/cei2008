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
 * <p>Java class for divCT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="divCT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneable">
 *       &lt;sequence>
 *         &lt;element name="titlePage" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}titlePageCT" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="a" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}aCT"/>
 *           &lt;element name="abbr" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}abbrCT"/>
 *           &lt;element name="chapter" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}chapterCT"/>
 *           &lt;element name="closer" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}closerCT"/>
 *           &lt;element name="date" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}dateCT"/>
 *           &lt;element name="div" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}divCT"/>
 *           &lt;element name="divineName" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}divineNameCT"/>
 *           &lt;element name="figure" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}figureCT"/>
 *           &lt;element name="foreign" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}foreignCT"/>
 *           &lt;element name="hi" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}hiCT"/>
 *           &lt;element name="index" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}indexCT"/>
 *           &lt;element name="inscription" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}inscriptionCT"/>
 *           &lt;element name="lb" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}lbCT"/>
 *           &lt;element name="lg" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}lgCT"/>
 *           &lt;element name="list" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}listCT"/>
 *           &lt;element name="mentioned" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}mentionedCT"/>
 *           &lt;element name="milestone" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneCT"/>
 *           &lt;element name="milestoneEnd" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneEndCT"/>
 *           &lt;element name="milestoneStart" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneStartCT"/>
 *           &lt;element name="name" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}nameCT"/>
 *           &lt;element name="note" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}noteCT"/>
 *           &lt;element name="p" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}pCT"/>
 *           &lt;element name="q" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}qCT"/>
 *           &lt;element name="reference" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}referenceCT"/>
 *           &lt;element name="salute" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}saluteCT"/>
 *           &lt;element name="seg" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}segCT"/>
 *           &lt;element name="signed" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}signedCT"/>
 *           &lt;element name="speaker" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}speakerCT"/>
 *           &lt;element name="speech" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}speechCT"/>
 *           &lt;element name="table" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}tableCT"/>
 *           &lt;element name="title" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}titleCT"/>
 *           &lt;element name="transChange" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}transChangeCT"/>
 *           &lt;element name="verse" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}verseCT"/>
 *           &lt;element name="w" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}wCT"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.bibletechnologies.net/2003/OSIS/namespace}globalWithoutType"/>
 *       &lt;attribute name="canonical" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="osisRef" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}osisRefType" />
 *       &lt;attribute name="scope" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}osisRefType" />
 *       &lt;attribute name="type" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}divType" />
 *       &lt;attribute name="TEIform" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="div" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "divCT", propOrder = {
    "content"
})
public class DivCT {

    @XmlElementRefs({
        @XmlElementRef(name = "index", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "w", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "list", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "closer", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "note", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "title", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "name", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "verse", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "signed", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "lb", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "lg", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "titlePage", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "transChange", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "seg", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "mentioned", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "milestoneEnd", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "figure", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "milestoneStart", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "speaker", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "milestone", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "inscription", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "divineName", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "chapter", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "reference", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "div", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "date", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "foreign", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "salute", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "hi", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "q", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "p", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "table", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "speech", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "abbr", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class),
        @XmlElementRef(name = "a", namespace = "http://www.bibletechnologies.net/2003/OSIS/namespace", type = JAXBElement.class)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute
    protected Boolean canonical;
    @XmlAttribute
    protected List<String> osisRef;
    @XmlAttribute
    protected List<String> scope;
    @XmlAttribute
    protected String type;
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
     * {@link JAXBElement }{@code <}{@link IndexCT }{@code >}
     * {@link JAXBElement }{@code <}{@link WCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ListCT }{@code >}
     * {@link JAXBElement }{@code <}{@link CloserCT }{@code >}
     * {@link JAXBElement }{@code <}{@link TitleCT }{@code >}
     * {@link JAXBElement }{@code <}{@link NoteCT }{@code >}
     * {@link JAXBElement }{@code <}{@link NameCT }{@code >}
     * {@link JAXBElement }{@code <}{@link SignedCT }{@code >}
     * {@link JAXBElement }{@code <}{@link VerseCT }{@code >}
     * {@link JAXBElement }{@code <}{@link LbCT }{@code >}
     * {@link JAXBElement }{@code <}{@link LgCT }{@code >}
     * {@link JAXBElement }{@code <}{@link TitlePageCT }{@code >}
     * {@link JAXBElement }{@code <}{@link TransChangeCT }{@code >}
     * {@link JAXBElement }{@code <}{@link MentionedCT }{@code >}
     * {@link JAXBElement }{@code <}{@link SegCT }{@code >}
     * {@link JAXBElement }{@code <}{@link MilestoneEndCT }{@code >}
     * {@link JAXBElement }{@code <}{@link FigureCT }{@code >}
     * {@link JAXBElement }{@code <}{@link MilestoneStartCT }{@code >}
     * {@link JAXBElement }{@code <}{@link InscriptionCT }{@code >}
     * {@link JAXBElement }{@code <}{@link MilestoneCT }{@code >}
     * {@link JAXBElement }{@code <}{@link SpeakerCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ChapterCT }{@code >}
     * {@link JAXBElement }{@code <}{@link DivineNameCT }{@code >}
     * {@link JAXBElement }{@code <}{@link DivCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ReferenceCT }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link DateCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ForeignCT }{@code >}
     * {@link JAXBElement }{@code <}{@link SaluteCT }{@code >}
     * {@link JAXBElement }{@code <}{@link HiCT }{@code >}
     * {@link JAXBElement }{@code <}{@link QCT }{@code >}
     * {@link JAXBElement }{@code <}{@link PCT }{@code >}
     * {@link JAXBElement }{@code <}{@link TableCT }{@code >}
     * {@link JAXBElement }{@code <}{@link SpeechCT }{@code >}
     * {@link JAXBElement }{@code <}{@link AbbrCT }{@code >}
     * {@link JAXBElement }{@code <}{@link ACT }{@code >}
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
    public boolean isCanonical() {
        if (canonical == null) {
            return false;
        } else {
            return canonical;
        }
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
     * Gets the value of the scope property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scope property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScope().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getScope() {
        if (scope == null) {
            scope = new ArrayList<String>();
        }
        return this.scope;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
            return "div";
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
