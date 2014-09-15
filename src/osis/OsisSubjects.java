//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.15 at 10:54:55 PM CEST 
//


package osis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for osisSubjects.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="osisSubjects">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ATLA"/>
 *     &lt;enumeration value="BILDI"/>
 *     &lt;enumeration value="DBC"/>
 *     &lt;enumeration value="DDC"/>
 *     &lt;enumeration value="EUT"/>
 *     &lt;enumeration value="FGT"/>
 *     &lt;enumeration value="LCC"/>
 *     &lt;enumeration value="LCSH"/>
 *     &lt;enumeration value="MeSH"/>
 *     &lt;enumeration value="NLSH"/>
 *     &lt;enumeration value="RSWK"/>
 *     &lt;enumeration value="SEARS"/>
 *     &lt;enumeration value="SOG"/>
 *     &lt;enumeration value="SWD_RSWK"/>
 *     &lt;enumeration value="UDC"/>
 *     &lt;enumeration value="VAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "osisSubjects")
@XmlEnum
public enum OsisSubjects {

    ATLA("ATLA"),
    BILDI("BILDI"),
    DBC("DBC"),
    DDC("DDC"),
    EUT("EUT"),
    FGT("FGT"),
    LCC("LCC"),
    LCSH("LCSH"),
    @XmlEnumValue("MeSH")
    ME_SH("MeSH"),
    NLSH("NLSH"),
    RSWK("RSWK"),
    SEARS("SEARS"),
    SOG("SOG"),
    SWD_RSWK("SWD_RSWK"),
    UDC("UDC"),
    VAT("VAT");
    private final String value;

    OsisSubjects(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OsisSubjects fromValue(String v) {
        for (OsisSubjects c: OsisSubjects.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}