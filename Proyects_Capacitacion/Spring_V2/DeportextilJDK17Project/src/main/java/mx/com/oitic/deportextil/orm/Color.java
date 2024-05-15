/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "color")
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_color")
    private Integer idColor;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "id_estatus_color", referencedColumnName = "id_estatus_color")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstatusColor estatusColor;
    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private Set<Pieza> piezaSet;

    public Color() {
    }

    public Color(Integer idColor) {
        this.idColor = idColor;
    }

    public Color(Integer idColor, String color) {
        this.idColor = idColor;
        this.color = color;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public EstatusColor getEstatusColor() {
        return estatusColor;
    }

    public void setEstatusColor(EstatusColor estatusColor) {
        this.estatusColor = estatusColor;
    }

    public Set<Pieza> getPiezaSet() {
        return piezaSet;
    }

    public void setPiezaSet(Set<Pieza> piezaSet) {
        this.piezaSet = piezaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColor != null ? idColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.idColor == null && other.idColor != null) || (this.idColor != null && !this.idColor.equals(other.idColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Color[ idColor=" + idColor + " ]";
    }
    
}
