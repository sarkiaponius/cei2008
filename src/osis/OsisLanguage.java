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
 * <p>Java class for osisLanguage.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="osisLanguage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IANA"/>
 *     &lt;enumeration value="IETF"/>
 *     &lt;enumeration value="ISO-639-1"/>
 *     &lt;enumeration value="ISO-639-2"/>
 *     &lt;enumeration value="ISO-639-2-B"/>
 *     &lt;enumeration value="ISO-639-2-T"/>
 *     &lt;enumeration value="LINGUIST"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="SIL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "osisLanguage")
@XmlEnum
public enum OsisLanguage {

    IANA("IANA"),
    IETF("IETF"),
    @XmlEnumValue("ISO-639-1")
    ISO_639_1("ISO-639-1"),
    @XmlEnumValue("ISO-639-2")
    ISO_639_2("ISO-639-2"),
    @XmlEnumValue("ISO-639-2-B")
    ISO_639_2_B("ISO-639-2-B"),
    @XmlEnumValue("ISO-639-2-T")
    ISO_639_2_T("ISO-639-2-T"),
    LINGUIST("LINGUIST"),
    @XmlEnumValue("other")
    OTHER("other"),
    SIL("SIL");
    private final String value;

    OsisLanguage(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OsisLanguage fromValue(String v) {
        for (OsisLanguage c: OsisLanguage.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
