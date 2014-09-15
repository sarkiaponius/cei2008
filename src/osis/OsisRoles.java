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
 * <p>Java class for osisRoles.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="osisRoles">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="adp"/>
 *     &lt;enumeration value="ann"/>
 *     &lt;enumeration value="art"/>
 *     &lt;enumeration value="aut"/>
 *     &lt;enumeration value="aqt"/>
 *     &lt;enumeration value="aft"/>
 *     &lt;enumeration value="aui"/>
 *     &lt;enumeration value="bnd"/>
 *     &lt;enumeration value="bdd"/>
 *     &lt;enumeration value="bkd"/>
 *     &lt;enumeration value="bkp"/>
 *     &lt;enumeration value="bjd"/>
 *     &lt;enumeration value="bpd"/>
 *     &lt;enumeration value="ctg"/>
 *     &lt;enumeration value="clb"/>
 *     &lt;enumeration value="cmm"/>
 *     &lt;enumeration value="cwt"/>
 *     &lt;enumeration value="com"/>
 *     &lt;enumeration value="ctb"/>
 *     &lt;enumeration value="cre"/>
 *     &lt;enumeration value="edt"/>
 *     &lt;enumeration value="encoder"/>
 *     &lt;enumeration value="ilu"/>
 *     &lt;enumeration value="ill"/>
 *     &lt;enumeration value="pbl"/>
 *     &lt;enumeration value="trl"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "osisRoles")
@XmlEnum
public enum OsisRoles {

    @XmlEnumValue("adp")
    ADP("adp"),
    @XmlEnumValue("ann")
    ANN("ann"),
    @XmlEnumValue("art")
    ART("art"),
    @XmlEnumValue("aut")
    AUT("aut"),
    @XmlEnumValue("aqt")
    AQT("aqt"),
    @XmlEnumValue("aft")
    AFT("aft"),
    @XmlEnumValue("aui")
    AUI("aui"),
    @XmlEnumValue("bnd")
    BND("bnd"),
    @XmlEnumValue("bdd")
    BDD("bdd"),
    @XmlEnumValue("bkd")
    BKD("bkd"),
    @XmlEnumValue("bkp")
    BKP("bkp"),
    @XmlEnumValue("bjd")
    BJD("bjd"),
    @XmlEnumValue("bpd")
    BPD("bpd"),
    @XmlEnumValue("ctg")
    CTG("ctg"),
    @XmlEnumValue("clb")
    CLB("clb"),
    @XmlEnumValue("cmm")
    CMM("cmm"),
    @XmlEnumValue("cwt")
    CWT("cwt"),
    @XmlEnumValue("com")
    COM("com"),
    @XmlEnumValue("ctb")
    CTB("ctb"),
    @XmlEnumValue("cre")
    CRE("cre"),
    @XmlEnumValue("edt")
    EDT("edt"),
    @XmlEnumValue("encoder")
    ENCODER("encoder"),
    @XmlEnumValue("ilu")
    ILU("ilu"),
    @XmlEnumValue("ill")
    ILL("ill"),
    @XmlEnumValue("pbl")
    PBL("pbl"),
    @XmlEnumValue("trl")
    TRL("trl");
    private final String value;

    OsisRoles(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OsisRoles fromValue(String v) {
        for (OsisRoles c: OsisRoles.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
