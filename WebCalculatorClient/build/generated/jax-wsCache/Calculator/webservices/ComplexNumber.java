
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para complexNumber complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="complexNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="i" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="j" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complexNumber", propOrder = {
    "i",
    "j"
})
public class ComplexNumber {

    protected double i;
    protected double j;

    /**
     * Obtiene el valor de la propiedad i.
     * 
     */
    public double getI() {
        return i;
    }

    /**
     * Define el valor de la propiedad i.
     * 
     */
    public void setI(double value) {
        this.i = value;
    }

    /**
     * Obtiene el valor de la propiedad j.
     * 
     */
    public double getJ() {
        return j;
    }

    /**
     * Define el valor de la propiedad j.
     * 
     */
    public void setJ(double value) {
        this.j = value;
    }

}
