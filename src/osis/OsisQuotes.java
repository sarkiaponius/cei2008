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
 * <p>Java class for osisQuotes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="osisQuotes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="block"/>
 *     &lt;enumeration value="citation"/>
 *     &lt;enumeration value="embedded"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "osisQuotes")
@XmlEnum
public enum OsisQuotes {

    @XmlEnumValue("block")
    BLOCK("block"),
    @XmlEnumValue("citation")
    CITATION("citation"),
    @XmlEnumValue("embedded")
    EMBEDDED("embedded");
    private final String value;

    OsisQuotes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OsisQuotes fromValue(String v) {
        for (OsisQuotes c: OsisQuotes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}