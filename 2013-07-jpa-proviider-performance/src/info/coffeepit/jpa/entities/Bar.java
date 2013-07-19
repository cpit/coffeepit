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
    private String bar1;
    private String bar2;
    private String bar3;
    private String bar4;
    private String bar5;
    private BigDecimal number1;
    private BigDecimal number2;
    private BigDecimal number3;
    private BigDecimal number4;
    private BigDecimal number5;

    public Bar() {
    }

    public Bar(Foo foo, String bar1, String bar2, String bar3, String bar4, String bar5, BigDecimal number1, BigDecimal number2, BigDecimal number3, BigDecimal number4, BigDecimal number5) {
        this.bar1 = bar1;
        this.bar2 = bar2;
        this.bar3 = bar3;
        this.bar4 = bar4;
        this.bar5 = bar5;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public void setBar1(String bar1) {
        this.bar1 = bar1;
    }

    public void setBar2(String bar2) {
        this.bar2 = bar2;
    }

    public void setBar3(String bar3) {
        this.bar3 = bar3;
    }

    public void setBar4(String bar) {
        this.bar4 = bar;
    }

    public void setBar5(String bar5) {
        this.bar5 = bar5;
    }

    public void setNumber1(BigDecimal number1) {
        this.number1 = number1;
    }

    public void setNumber2(BigDecimal number2) {
        this.number2 = number2;
    }

    public void setNumber3(BigDecimal number3) {
        this.number3 = number3;
    }

    public void setNumber4(BigDecimal number4) {
        this.number4 = number4;
    }

    public void setNumber5(BigDecimal number5) {
        this.number5 = number5;
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
