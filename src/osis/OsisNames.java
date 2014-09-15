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
 * <p>Java class for osisNames.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="osisNames">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="geographic"/>
 *     &lt;enumeration value="holiday"/>
 *     &lt;enumeration value="nonhuman"/>
 *     &lt;enumeration value="person"/>
 *     &lt;enumeration value="ritual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "osisNames")
@XmlEnum
public enum OsisNames {

    @XmlEnumValue("geographic")
    GEOGRAPHIC("geographic"),
    @XmlEnumValue("holiday")
    HOLIDAY("holiday"),
    @XmlEnumValue("nonhuman")
    NONHUMAN("nonhuman"),
    @XmlEnumValue("person")
    PERSON("person"),
    @XmlEnumValue("ritual")
    RITUAL("ritual");
    private final String value;

    OsisNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OsisNames fromValue(String v) {
        for (OsisNames c: OsisNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}