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
@Table(name = "sat_producto")
@NamedQueries({
    @NamedQuery(name = "SatProducto.findAll", query = "SELECT s FROM SatProducto s")})
public class SatProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sat_producto")
    private Integer idSatProducto;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "satProducto", fetch = FetchType.LAZY)
    private Set<TipoArticulo> tipoArticuloSet;

    public SatProducto() {
    }

    public SatProducto(Integer idSatProducto) {
        this.idSatProducto = idSatProducto;
    }

    public SatProducto(Integer idSatProducto, String clave, String descripcion) {
        this.idSatProducto = idSatProducto;
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public Integer getIdSatProducto() {
        return idSatProducto;
    }

    public void setIdSatProducto(Integer idSatProducto) {
        this.idSatProducto = idSatProducto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<TipoArticulo> getTipoArticuloSet() {
        return tipoArticuloSet;
    }

    public void setTipoArticuloSet(Set<TipoArticulo> tipoArticuloSet) {
        this.tipoArticuloSet = tipoArticuloSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSatProducto != null ? idSatProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SatProducto)) {
            return false;
        }
        SatProducto other = (SatProducto) object;
        if ((this.idSatProducto == null && other.idSatProducto != null) || (this.idSatProducto != null && !this.idSatProducto.equals(other.idSatProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.SatProducto[ idSatProducto=" + idSatProducto + " ]";
    }
    
}
