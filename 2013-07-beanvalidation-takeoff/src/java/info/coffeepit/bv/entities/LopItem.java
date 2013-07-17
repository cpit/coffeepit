/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.coffeepit.bv.entities;

import info.coffeepit.bv.listener.LopChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Chris
 */
@Entity
public class LopItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Transient
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 2, max = 100)
    private String text;
    @Temporal(TemporalType.DATE)
    private Calendar faelligkeit;
    private Status status;
    
    @ManyToMany(mappedBy = "items")
    private Collection<Lop> lops;

    public LopItem() {
        changes.addPropertyChangeListener(new LopChangeListener());
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        Status oldStatus = this.status;
        this.status = status;
        changes.firePropertyChange("status", oldStatus, status);
    }

    public Collection<Lop> getLops() {
        return lops;
    }

    public void setLops(Collection<Lop> lops) {
        this.lops = lops;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getFaelligkeit() {
        return faelligkeit;
    }

    public void setFaelligkeit(Calendar faelligkeit) {
        this.faelligkeit = faelligkeit;
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
        if (!(object instanceof LopItem)) {
            return false;
        }
        LopItem other = (LopItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.cpit.coffeepit.bv.entities.LopItem[ id=" + id + " ]";
    }
}
