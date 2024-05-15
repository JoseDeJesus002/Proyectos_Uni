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
@Table(name = "tipo_gasto")
@NamedQueries({
    @NamedQuery(name = "TipoGasto.findAll", query = "SELECT t FROM TipoGasto t")})
public class TipoGasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_gasto")
    private Integer idTipoGasto;
    @Basic(optional = false)
    @Column(name = "tipo_gasto")
    private String tipoGasto;
    @Basic(optional = false)
    @Column(name = "id_estatus_tipo_gasto")
    private int idEstatusTipoGasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoGasto", fetch = FetchType.LAZY)
    private Set<Gasto> gastoSet;
    @JoinColumn(name = "id_categoria_gasto", referencedColumnName = "id_categoria_gasto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaGasto categoriaGasto;

    public TipoGasto() {
    }

    public TipoGasto(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public TipoGasto(Integer idTipoGasto, String tipoGasto, int idEstatusTipoGasto) {
        this.idTipoGasto = idTipoGasto;
        this.tipoGasto = tipoGasto;
        this.idEstatusTipoGasto = idEstatusTipoGasto;
    }

    public Integer getIdTipoGasto() {
        return idTipoGasto;
    }

    public void setIdTipoGasto(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public int getIdEstatusTipoGasto() {
        return idEstatusTipoGasto;
    }

    public void setIdEstatusTipoGasto(int idEstatusTipoGasto) {
        this.idEstatusTipoGasto = idEstatusTipoGasto;
    }

    public Set<Gasto> getGastoSet() {
        return gastoSet;
    }

    public void setGastoSet(Set<Gasto> gastoSet) {
        this.gastoSet = gastoSet;
    }

    public CategoriaGasto getCategoriaGasto() {
        return categoriaGasto;
    }

    public void setCategoriaGasto(CategoriaGasto categoriaGasto) {
        this.categoriaGasto = categoriaGasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoGasto != null ? idTipoGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGasto)) {
            return false;
        }
        TipoGasto other = (TipoGasto) object;
        if ((this.idTipoGasto == null && other.idTipoGasto != null) || (this.idTipoGasto != null && !this.idTipoGasto.equals(other.idTipoGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.TipoGasto[ idTipoGasto=" + idTipoGasto + " ]";
    }
    
}
