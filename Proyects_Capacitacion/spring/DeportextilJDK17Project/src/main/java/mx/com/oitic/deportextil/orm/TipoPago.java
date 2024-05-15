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
@Table(name = "tipo_pago")
@NamedQueries({
    @NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t")})
public class TipoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_pago")
    private Integer idTipoPago;
    @Basic(optional = false)
    @Column(name = "estatus_tipo_pago")
    private int estatusTipoPago;
    @Column(name = "id_sucursal")
    private String idSucursal;
    @Column(name = "leyenda")
    private String leyenda;
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Column(name = "tipo_pago_sat")
    private String tipoPagoSat;
    @Column(name = "tipo_pago_sap")
    private String tipoPagoSap;
    @ManyToMany(mappedBy = "tipoPagoSet", fetch = FetchType.LAZY)
    private Set<CuentaBancaria> cuentaBancariaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPago", fetch = FetchType.LAZY)
    private Set<TipoPagoTicket> tipoPagoTicketSet;

    public TipoPago() {
    }

    public TipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public TipoPago(Integer idTipoPago, int estatusTipoPago) {
        this.idTipoPago = idTipoPago;
        this.estatusTipoPago = estatusTipoPago;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public int getEstatusTipoPago() {
        return estatusTipoPago;
    }

    public void setEstatusTipoPago(int estatusTipoPago) {
        this.estatusTipoPago = estatusTipoPago;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoPagoSat() {
        return tipoPagoSat;
    }

    public void setTipoPagoSat(String tipoPagoSat) {
        this.tipoPagoSat = tipoPagoSat;
    }

    public String getTipoPagoSap() {
        return tipoPagoSap;
    }

    public void setTipoPagoSap(String tipoPagoSap) {
        this.tipoPagoSap = tipoPagoSap;
    }

    public Set<CuentaBancaria> getCuentaBancariaSet() {
        return cuentaBancariaSet;
    }

    public void setCuentaBancariaSet(Set<CuentaBancaria> cuentaBancariaSet) {
        this.cuentaBancariaSet = cuentaBancariaSet;
    }

    public Set<TipoPagoTicket> getTipoPagoTicketSet() {
        return tipoPagoTicketSet;
    }

    public void setTipoPagoTicketSet(Set<TipoPagoTicket> tipoPagoTicketSet) {
        this.tipoPagoTicketSet = tipoPagoTicketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPago != null ? idTipoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPago)) {
            return false;
        }
        TipoPago other = (TipoPago) object;
        if ((this.idTipoPago == null && other.idTipoPago != null) || (this.idTipoPago != null && !this.idTipoPago.equals(other.idTipoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.TipoPago[ idTipoPago=" + idTipoPago + " ]";
    }
    
}
