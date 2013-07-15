/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.lop.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author chris
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
        private Long id;

    @Transient
    public String getName () {
        return getVorname() + " " + getNachname();
    }
    
    public void setName (String name) {
        String [] namen = name.split(" ");
        if (namen.length<2) {
            setNachname(namen[0]);
            setVorname("?");
        } else {
            setNachname(namen[1]);
            setVorname(namen[0]);
        }
    }
    
    
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    private String nachname;
    private String vorname;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        return "("+getId() + ") " + getName();
    }
}
