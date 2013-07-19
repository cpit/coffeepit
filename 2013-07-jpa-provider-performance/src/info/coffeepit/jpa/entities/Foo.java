
package info.coffeepit.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;

/**
 * Testklasse "Foo", mit insgesamt 10 Properties und einer one-to-many-Relation zur Klasse "Bar"
 * @author Chris
 */
@Entity
public class Foo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    private BigDecimal decimal1;
    private BigDecimal decimal2;
    private BigDecimal decimal3;
    private BigDecimal decimal4;
    private BigDecimal decimal5;
    
   @OneToMany (cascade = CascadeType.ALL, mappedBy = "foo" )
   //@OrderBy ("bar1") // bezieht sich nur auf Selects
   @OrderColumn (name="reihenfolge")
   private List<Bar> bars;

    public Foo() {
    }

    public Foo(String string1, String string2, String string3, String string4, String string5, BigDecimal decimal1, BigDecimal decimal2, BigDecimal decimal3, BigDecimal decimal4, BigDecimal decimal5) {
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.string5 = string5;
        this.decimal1 = decimal1;
        this.decimal2 = decimal2;
        this.decimal3 = decimal3;
        this.decimal4 = decimal4;
        this.decimal5 = decimal5;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public void setString4(String string4) {
        this.string4 = string4;
    }

    public void setString5(String string5) {
        this.string5 = string5;
    }

    public void setDecimal1(BigDecimal decimal1) {
        this.decimal1 = decimal1;
    }

    public void setDecimal2(BigDecimal decimal2) {
        this.decimal2 = decimal2;
    }

    public void setDecimal3(BigDecimal decimal3) {
        this.decimal3 = decimal3;
    }

    public void setDecimal4(BigDecimal decimal4) {
        this.decimal4 = decimal4;
    }

    public void setDecimal5(BigDecimal decimal5) {
        this.decimal5 = decimal5;
    }

    public void setBars(List<Bar> collectionOfBars) {
        this.bars = collectionOfBars;
    }

    public List<Bar> getBars() {
        return bars;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    public String getString3() {
        return string3;
    }

    public String getString4() {
        return string4;
    }

    public String getString5() {
        return string5;
    }

    public BigDecimal getDecimal1() {
        return decimal1;
    }

    public BigDecimal getDecimal2() {
        return decimal2;
    }

    public BigDecimal getDecimal3() {
        return decimal3;
    }

    public BigDecimal getDecimal4() {
        return decimal4;
    }

    public BigDecimal getDecimal5() {
        return decimal5;
    }
   
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foo)) {
            return false;
        }
        Foo other = (Foo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.coffeepit.jpa.entities.Foo[ id=" + id + " ]";
    }
    
  
}
