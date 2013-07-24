/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.lop2.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author Chris
 */
@Entity
public class Lop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @OneToMany (mappedBy = "lop")
    @OrderBy ("dueDate")
    private List<LopItem> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LopItem> getItems() {
        return items;
    }

    public void setItems(List<LopItem> items) {
        this.items = items;
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
        if (!(object instanceof Lop)) {
            return false;
        }
        Lop other = (Lop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.cpit.coffeepit.lop2.entities.Lop[ id=" + id + " ]";
    }
    
}
