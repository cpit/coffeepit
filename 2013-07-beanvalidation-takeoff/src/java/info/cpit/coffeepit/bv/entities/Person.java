/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.bv.entities;

import info.cpit.coffeepit.bv.VolljaehrigConstraint;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris
 */
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    @Temporal (TemporalType.DATE)
    @VolljaehrigConstraint
    private Calendar geburtsdatum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Calendar geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.cpit.coffeepit.bv.entities.Person[ id=" + id + " ]";
    }
    
}
