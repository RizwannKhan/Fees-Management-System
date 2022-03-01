/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system.helper;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rijwank
 */
@Entity
@Table(name = "course", catalog = "fees_management_system", schema = "")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByCName", query = "SELECT c FROM Course c WHERE c.cName = :cName")
    , @NamedQuery(name = "Course.findByCost", query = "SELECT c FROM Course c WHERE c.cost = :cost")})
public class Course implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cName")
    private String cName;
    @Basic(optional = false)
    @Column(name = "cost")
    private String cost;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String cName, String cost) {
        this.id = id;
        this.cName = cName;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        String oldCName = this.cName;
        this.cName = cName;
        changeSupport.firePropertyChange("CName", oldCName, cName);
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        String oldCost = this.cost;
        this.cost = cost;
        changeSupport.firePropertyChange("cost", oldCost, cost);
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fees_management_system.frames.Course[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
