/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "cuenta_bancaria")
@NamedQueries({
    @NamedQuery(name = "CuentaBancaria.findAll", query = "SELECT c FROM CuentaBancaria c")})
public class CuentaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cuenta_bancaria")
    private String idCuentaBancaria;
    @Column(name = "id_sap")
    private String idSap;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "cuenta_bancaria")
    private String cuentaBancaria;
    @Column(name = "cuenta_mayor")
    private String cuentaMayor;
    @JoinTable(name = "cuenta_bancaria_tipo_pago", joinColumns = {
        @JoinColumn(name = "id_cuenta_bancaria", referencedColumnName = "id_cuenta_bancaria")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<TipoPago> tipoPagoSet;
    @OneToMany(mappedBy = "cuentaBancaria", fetch = FetchType.LAZY)
    private Set<TipoPagoTicket> tipoPagoTicketSet;
    @OneToMany(mappedBy = "cuentaBancaria", fetch = FetchType.LAZY)
    private Set<Sucursal> sucursalSet;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(String idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getIdSap() {
        return idSap;
    }

    public void setIdSap(String idSap) {
        this.idSap = idSap;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getCuentaMayor() {
        return cuentaMayor;
    }

    public void setCuentaMayor(String cuentaMayor) {
        this.cuentaMayor = cuentaMayor;
    }

    public Set<TipoPago> getTipoPagoSet() {
        return tipoPagoSet;
    }

    public void setTipoPagoSet(Set<TipoPago> tipoPagoSet) {
        this.tipoPagoSet = tipoPagoSet;
    }

    public Set<TipoPagoTicket> getTipoPagoTicketSet() {
        return tipoPagoTicketSet;
    }

    public void setTipoPagoTicketSet(Set<TipoPagoTicket> tipoPagoTicketSet) {
        this.tipoPagoTicketSet = tipoPagoTicketSet;
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
        hash += (idCuentaBancaria != null ? idCuentaBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria other = (CuentaBancaria) object;
        if ((this.idCuentaBancaria == null && other.idCuentaBancaria != null) || (this.idCuentaBancaria != null && !this.idCuentaBancaria.equals(other.idCuentaBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.CuentaBancaria[ idCuentaBancaria=" + idCuentaBancaria + " ]";
    }
    
}
