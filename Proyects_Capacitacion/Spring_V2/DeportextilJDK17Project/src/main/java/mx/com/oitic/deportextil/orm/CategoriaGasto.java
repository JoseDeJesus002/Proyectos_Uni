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
@Table(name = "categoria_gasto")
@NamedQueries({
    @NamedQuery(name = "CategoriaGasto.findAll", query = "SELECT c FROM CategoriaGasto c")})
public class CategoriaGasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_gasto")
    private Integer idCategoriaGasto;
    @Basic(optional = false)
    @Column(name = "categoria_gasto")
    private String categoriaGasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaGasto", fetch = FetchType.LAZY)
    private Set<TipoGasto> tipoGastoSet;

    public CategoriaGasto() {
    }

    public CategoriaGasto(Integer idCategoriaGasto) {
        this.idCategoriaGasto = idCategoriaGasto;
    }

    public CategoriaGasto(Integer idCategoriaGasto, String categoriaGasto) {
        this.idCategoriaGasto = idCategoriaGasto;
        this.categoriaGasto = categoriaGasto;
    }

    public Integer getIdCategoriaGasto() {
        return idCategoriaGasto;
    }

    public void setIdCategoriaGasto(Integer idCategoriaGasto) {
        this.idCategoriaGasto = idCategoriaGasto;
    }

    public String getCategoriaGasto() {
        return categoriaGasto;
    }

    public void setCategoriaGasto(String categoriaGasto) {
        this.categoriaGasto = categoriaGasto;
    }

    public Set<TipoGasto> getTipoGastoSet() {
        return tipoGastoSet;
    }

    public void setTipoGastoSet(Set<TipoGasto> tipoGastoSet) {
        this.tipoGastoSet = tipoGastoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaGasto != null ? idCategoriaGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaGasto)) {
            return false;
        }
        CategoriaGasto other = (CategoriaGasto) object;
        if ((this.idCategoriaGasto == null && other.idCategoriaGasto != null) || (this.idCategoriaGasto != null && !this.idCategoriaGasto.equals(other.idCategoriaGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.CategoriaGasto[ idCategoriaGasto=" + idCategoriaGasto + " ]";
    }
    
}
