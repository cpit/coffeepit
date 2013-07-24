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
import javax.persistence.OrderColumn;

/**
 * Testklasse "Foo", mit insgesamt 10 Properties und einer one-to-many-Relation zur Klasse "Bar"
 *
 * @author Chris
 */
@Entity
public class Foo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String someText;
    private BigDecimal someDecimalNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foo")
    @OrderColumn(name = "reihenfolge")
    private List<Bar> bars;
    private static final long serialVersionUID = 1L;

    public Foo() {
    }

    public Foo(String aString, BigDecimal aDecimal) {
        this.someText = aString;
        this.someDecimalNumber = aDecimal;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public void setSomeDecimalNumber(BigDecimal someDecimalNumber) {
        this.someDecimalNumber = someDecimalNumber;
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

    public String getSomeText() {
        return someText;
    }

    public BigDecimal getSomeDecimalNumber() {
        return someDecimalNumber;
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
