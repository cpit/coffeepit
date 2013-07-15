
package info.cpit.lop.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Eintrag in der Liste offener Punkte.
 * @author chris
 */
@Entity (name = "LopItem")
@Table (name = "ITEM")
public class LopItem implements Serializable {
    
    @Id  @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private Date dueDate;
    @Enumerated (EnumType.STRING)
    private Status status;
    @Enumerated (EnumType.ORDINAL)
    private Prio prio;

    public Prio getPrio() {
        return prio;
    }

    public void setPrio(Prio prio) {
        this.prio = prio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
}
