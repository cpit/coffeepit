/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.lop.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Liste offener Punkte.
 *
 * @author chris
 */
@Entity (name = "Lop")
@Table (name = "LOP")
public class Lop implements Serializable {
    
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column (updatable = false)
    private Date created;

    public Lop () {
    }
    
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    @OneToMany
    private Collection<LopItem> lopitems;

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<LopItem> getLopitems() {
        return lopitems;
    }

    public void setLopitems(Collection<LopItem> lopitems) {
        this.lopitems = lopitems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
