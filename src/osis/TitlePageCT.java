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
 * <p>Java class for titlePageCT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="titlePageCT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="title" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}titleCT"/>
 *         &lt;element name="contributor" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}contributorCT"/>
 *         &lt;element name="creator" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}creatorCT"/>
 *         &lt;element name="subject" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}subjectCT"/>
 *         &lt;element name="date" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}dateCT"/>
 *         &lt;element name="description" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}descriptionCT"/>
 *         &lt;element name="publisher" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}publisherCT"/>
 *         &lt;element name="type" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}typeCT"/>
 *         &lt;element name="format" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}formatCT"/>
 *         &lt;element name="identifier" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}identifierCT"/>
 *         &lt;element name="source" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}sourceCT"/>
 *         &lt;element name="language" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}languageCT"/>
 *         &lt;element name="relation" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}relationCT"/>
 *         &lt;element name="coverage" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}coverageCT"/>
 *         &lt;element name="p" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}pCT"/>
 *         &lt;element name="figure" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}figureCT"/>
 *         &lt;element name="milestone" type="{http://www.bibletechnologies.net/2003/OSIS/namespace}milestoneCT"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.bibletechnologies.net/2003/OSIS/namespace}globalWithType"/>
 *       &lt;attribute name="canonical" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "titlePageCT", propOrder = {
    "titleOrContributorOrCreator"
})
public class TitlePageCT {

    @XmlElements({
        @XmlElement(name = "identifier", type = IdentifierCT.class),
        @XmlElement(name = "subject", type = SubjectCT.class),
        @XmlElement(name = "description", type = DescriptionCT.class),
        @XmlElement(name = "relation", type = RelationCT.class),
        @XmlElement(name = "date", type = DateCT.class),
        @XmlElement(name = "publisher", type = PublisherCT.class),
        @XmlElement(name = "milestone", type = MilestoneCT.class),
        @XmlElement(name = "contributor", type = ContributorCT.class),
        @XmlElement(name = "figure", type = FigureCT.class),
        @XmlElement(name = "creator", type = CreatorCT.class),
        @XmlElement(name = "type", type = TypeCT.class),
        @XmlElement(name = "coverage", type = CoverageCT.class),
        @XmlElement(name = "title", type = TitleCT.class),
        @XmlElement(name = "p", type = PCT.class),
        @XmlElement(name = "language", type = LanguageCT.class),
        @XmlElement(name = "source", type = SourceCT.class),
        @XmlElement(name = "format", type = FormatCT.class)
    })
    protected List<Object> titleOrContributorOrCreator;
    @XmlAttribute
    protected Boolean canonical;
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
     * Gets the value of the titleOrContributorOrCreator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the titleOrContributorOrCreator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitleOrContributorOrCreator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierCT }
     * {@link SubjectCT }
     * {@link DescriptionCT }
     * {@link RelationCT }
     * {@link DateCT }
     * {@link PublisherCT }
     * {@link MilestoneCT }
     * {@link ContributorCT }
     * {@link FigureCT }
     * {@link CreatorCT }
     * {@link TypeCT }
     * {@link CoverageCT }
     * {@link TitleCT }
     * {@link PCT }
     * {@link LanguageCT }
     * {@link SourceCT }
     * {@link FormatCT }
     * 
     * 
     */
    public List<Object> getTitleOrContributorOrCreator() {
        if (titleOrContributorOrCreator == null) {
            titleOrContributorOrCreator = new ArrayList<Object>();
        }
        return this.titleOrContributorOrCreator;
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