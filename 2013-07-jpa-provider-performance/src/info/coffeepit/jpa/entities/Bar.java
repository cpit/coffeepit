/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.coffeepit.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Chris
 */
@Entity
public class Bar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Foo foo;
    private String someText;
    private BigDecimal someNumber;

    public Bar() {
    }

    /**
     * Konstruktor mit allen Properties.
     *
     * @param foo Foo-Objekt
     * @param someText Test-String 1
     * @param someNumber Test-Zahl 1
     */
    public Bar(Foo foo, String aString, BigDecimal aNumber) {
        this.someText = aString;
        this.someNumber = aNumber;

    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public void setSomeNumber(BigDecimal someNumber) {
        this.someNumber = someNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Bar)) {
            return false;
        }
        Bar other = (Bar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.coffeepit.jpa.entities.Bar[ id=" + id + " ]";
    }
}
