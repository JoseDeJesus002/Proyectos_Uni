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
@Table(name = "estatus_tipo_articulo")
@NamedQueries({
    @NamedQuery(name = "EstatusTipoArticulo.findAll", query = "SELECT e FROM EstatusTipoArticulo e")})
public class EstatusTipoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_tipo_articulo")
    private Integer idEstatusTipoArticulo;
    @Basic(optional = false)
    @Column(name = "estatus_tipo_articulo")
    private String estatusTipoArticulo;
    @OneToMany(mappedBy = "estatusTipoArticulo", fetch = FetchType.LAZY)
    private Set<TipoArticulo> tipoArticuloSet;

    public EstatusTipoArticulo() {
    }

    public EstatusTipoArticulo(Integer idEstatusTipoArticulo) {
        this.idEstatusTipoArticulo = idEstatusTipoArticulo;
    }

    public EstatusTipoArticulo(Integer idEstatusTipoArticulo, String estatusTipoArticulo) {
        this.idEstatusTipoArticulo = idEstatusTipoArticulo;
        this.estatusTipoArticulo = estatusTipoArticulo;
    }

    public Integer getIdEstatusTipoArticulo() {
        return idEstatusTipoArticulo;
    }

    public void setIdEstatusTipoArticulo(Integer idEstatusTipoArticulo) {
        this.idEstatusTipoArticulo = idEstatusTipoArticulo;
    }

    public String getEstatusTipoArticulo() {
        return estatusTipoArticulo;
    }

    public void setEstatusTipoArticulo(String estatusTipoArticulo) {
        this.estatusTipoArticulo = estatusTipoArticulo;
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
        hash += (idEstatusTipoArticulo != null ? idEstatusTipoArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusTipoArticulo)) {
            return false;
        }
        EstatusTipoArticulo other = (EstatusTipoArticulo) object;
        if ((this.idEstatusTipoArticulo == null && other.idEstatusTipoArticulo != null) || (this.idEstatusTipoArticulo != null && !this.idEstatusTipoArticulo.equals(other.idEstatusTipoArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusTipoArticulo[ idEstatusTipoArticulo=" + idEstatusTipoArticulo + " ]";
    }
    
}
