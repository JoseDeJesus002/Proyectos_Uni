/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "estatus_color")
@NamedQueries({
    @NamedQuery(name = "EstatusColor.findAll", query = "SELECT e FROM EstatusColor e")})
public class EstatusColor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_color")
    private Integer idEstatusColor;
    @Basic(optional = false)
    @Column(name = "estatus_color")
    private String estatusColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusColor", fetch = FetchType.LAZY)
    private Set<Color> colorSet;

    public EstatusColor() {
    }

    public EstatusColor(Integer idEstatusColor) {
        this.idEstatusColor = idEstatusColor;
    }

    public EstatusColor(Integer idEstatusColor, String estatusColor) {
        this.idEstatusColor = idEstatusColor;
        this.estatusColor = estatusColor;
    }

    public Integer getIdEstatusColor() {
        return idEstatusColor;
    }

    public void setIdEstatusColor(Integer idEstatusColor) {
        this.idEstatusColor = idEstatusColor;
    }

    public String getEstatusColor() {
        return estatusColor;
    }

    public void setEstatusColor(String estatusColor) {
        this.estatusColor = estatusColor;
    }

    public Set<Color> getColorSet() {
        return colorSet;
    }

    public void setColorSet(Set<Color> colorSet) {
        this.colorSet = colorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusColor != null ? idEstatusColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusColor)) {
            return false;
        }
        EstatusColor other = (EstatusColor) object;
        if ((this.idEstatusColor == null && other.idEstatusColor != null) || (this.idEstatusColor != null && !this.idEstatusColor.equals(other.idEstatusColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusColor[ idEstatusColor=" + idEstatusColor + " ]";
    }
    
}
