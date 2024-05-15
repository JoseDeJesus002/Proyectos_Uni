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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "banco")
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
    private Integer idBanco;
    @Basic(optional = false)
    @Column(name = "banco")
    private String banco;
    @JoinTable(name = "sucursal_has_banco", joinColumns = {
        @JoinColumn(name = "id_banco", referencedColumnName = "id_banco")}, inverseJoinColumns = {
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Sucursal> sucursalSet;
    @OneToMany(mappedBy = "banco", fetch = FetchType.LAZY)
    private Set<Vendedor> vendedorSet;
    @OneToMany(mappedBy = "banco", fetch = FetchType.LAZY)
    private Set<Proveedor> proveedorSet;

    public Banco() {
    }

    public Banco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Banco(Integer idBanco, String banco) {
        this.idBanco = idBanco;
        this.banco = banco;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Set<Sucursal> getSucursalSet() {
        return sucursalSet;
    }

    public void setSucursalSet(Set<Sucursal> sucursalSet) {
        this.sucursalSet = sucursalSet;
    }

    public Set<Vendedor> getVendedorSet() {
        return vendedorSet;
    }

    public void setVendedorSet(Set<Vendedor> vendedorSet) {
        this.vendedorSet = vendedorSet;
    }

    public Set<Proveedor> getProveedorSet() {
        return proveedorSet;
    }

    public void setProveedorSet(Set<Proveedor> proveedorSet) {
        this.proveedorSet = proveedorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Banco[ idBanco=" + idBanco + " ]";
    }
    
}
