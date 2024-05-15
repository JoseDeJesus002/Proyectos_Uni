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
@Table(name = "lista_precio")
@NamedQueries({
    @NamedQuery(name = "ListaPrecio.findAll", query = "SELECT l FROM ListaPrecio l")})
public class ListaPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lista_precio")
    private String idListaPrecio;
    @Column(name = "lista_precio")
    private String listaPrecio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaPrecio", fetch = FetchType.LAZY)
    private Set<PrecioArticulo> precioArticuloSet;
    @OneToMany(mappedBy = "listaPrecio", fetch = FetchType.LAZY)
    private Set<Sucursal> sucursalSet;

    public ListaPrecio() {
    }

    public ListaPrecio(String idListaPrecio) {
        this.idListaPrecio = idListaPrecio;
    }

    public String getIdListaPrecio() {
        return idListaPrecio;
    }

    public void setIdListaPrecio(String idListaPrecio) {
        this.idListaPrecio = idListaPrecio;
    }

    public String getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(String listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public Set<PrecioArticulo> getPrecioArticuloSet() {
        return precioArticuloSet;
    }

    public void setPrecioArticuloSet(Set<PrecioArticulo> precioArticuloSet) {
        this.precioArticuloSet = precioArticuloSet;
    }

    public Set<Sucursal> getSucursalSet() {
        return sucursalSet;
    }

    public void setSucursalSet(Set<Sucursal> sucursalSet) {
        this.sucursalSet = sucursalSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaPrecio != null ? idListaPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPrecio)) {
            return false;
        }
        ListaPrecio other = (ListaPrecio) object;
        if ((this.idListaPrecio == null && other.idListaPrecio != null) || (this.idListaPrecio != null && !this.idListaPrecio.equals(other.idListaPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.ListaPrecio[ idListaPrecio=" + idListaPrecio + " ]";
    }
    
}
