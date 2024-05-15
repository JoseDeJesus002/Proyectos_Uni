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
@Table(name = "estatus_tipo_gasto")
@NamedQueries({
    @NamedQuery(name = "EstatusTipoGasto.findAll", query = "SELECT e FROM EstatusTipoGasto e")})
public class EstatusTipoGasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estatus_tipo_gasto")
    private Integer idEstatusTipoGasto;
    @Basic(optional = false)
    @Column(name = "estatus_tipo_gasto")
    private String estatusTipoGasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusTipoGasto", fetch = FetchType.LAZY)
    private Set<Gasto> gastoSet;

    public EstatusTipoGasto() {
    }

    public EstatusTipoGasto(Integer idEstatusTipoGasto) {
        this.idEstatusTipoGasto = idEstatusTipoGasto;
    }

    public EstatusTipoGasto(Integer idEstatusTipoGasto, String estatusTipoGasto) {
        this.idEstatusTipoGasto = idEstatusTipoGasto;
        this.estatusTipoGasto = estatusTipoGasto;
    }

    public Integer getIdEstatusTipoGasto() {
        return idEstatusTipoGasto;
    }

    public void setIdEstatusTipoGasto(Integer idEstatusTipoGasto) {
        this.idEstatusTipoGasto = idEstatusTipoGasto;
    }

    public String getEstatusTipoGasto() {
        return estatusTipoGasto;
    }

    public void setEstatusTipoGasto(String estatusTipoGasto) {
        this.estatusTipoGasto = estatusTipoGasto;
    }

    public Set<Gasto> getGastoSet() {
        return gastoSet;
    }

    public void setGastoSet(Set<Gasto> gastoSet) {
        this.gastoSet = gastoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusTipoGasto != null ? idEstatusTipoGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusTipoGasto)) {
            return false;
        }
        EstatusTipoGasto other = (EstatusTipoGasto) object;
        if ((this.idEstatusTipoGasto == null && other.idEstatusTipoGasto != null) || (this.idEstatusTipoGasto != null && !this.idEstatusTipoGasto.equals(other.idEstatusTipoGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusTipoGasto[ idEstatusTipoGasto=" + idEstatusTipoGasto + " ]";
    }
    
}
