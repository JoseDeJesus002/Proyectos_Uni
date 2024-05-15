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
@Table(name = "categoria_articulo")
@NamedQueries({
    @NamedQuery(name = "CategoriaArticulo.findAll", query = "SELECT c FROM CategoriaArticulo c")})
public class CategoriaArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_categoria_articulo")
    private String idCategoriaArticulo;
    @Basic(optional = false)
    @Column(name = "categoria_articulo")
    private String categoriaArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaArticulo", fetch = FetchType.LAZY)
    private Set<TipoArticulo> tipoArticuloSet;

    public CategoriaArticulo() {
    }

    public CategoriaArticulo(String idCategoriaArticulo) {
        this.idCategoriaArticulo = idCategoriaArticulo;
    }

    public CategoriaArticulo(String idCategoriaArticulo, String categoriaArticulo) {
        this.idCategoriaArticulo = idCategoriaArticulo;
        this.categoriaArticulo = categoriaArticulo;
    }

    public String getIdCategoriaArticulo() {
        return idCategoriaArticulo;
    }

    public void setIdCategoriaArticulo(String idCategoriaArticulo) {
        this.idCategoriaArticulo = idCategoriaArticulo;
    }

    public String getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(String categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
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
        hash += (idCategoriaArticulo != null ? idCategoriaArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaArticulo)) {
            return false;
        }
        CategoriaArticulo other = (CategoriaArticulo) object;
        if ((this.idCategoriaArticulo == null && other.idCategoriaArticulo != null) || (this.idCategoriaArticulo != null && !this.idCategoriaArticulo.equals(other.idCategoriaArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.CategoriaArticulo[ idCategoriaArticulo=" + idCategoriaArticulo + " ]";
    }
    
}
