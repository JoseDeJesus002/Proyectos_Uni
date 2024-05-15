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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "tipo_pago_ticket")
@NamedQueries({
    @NamedQuery(name = "TipoPagoTicket.findAll", query = "SELECT t FROM TipoPagoTicket t")})
public class TipoPagoTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_pago_factura")
    private Integer idTipoPagoFactura;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @Column(name = "num_referencia")
    private String numReferencia;
    @JoinColumn(name = "id_cuenta_bancaria", referencedColumnName = "id_cuenta_bancaria")
    @ManyToOne(fetch = FetchType.LAZY)
    private CuentaBancaria cuentaBancaria;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticket ticket;
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoPago tipoPago;

    public TipoPagoTicket() {
    }

    public TipoPagoTicket(Integer idTipoPagoFactura) {
        this.idTipoPagoFactura = idTipoPagoFactura;
    }

    public TipoPagoTicket(Integer idTipoPagoFactura, double cantidad) {
        this.idTipoPagoFactura = idTipoPagoFactura;
        this.cantidad = cantidad;
    }

    public Integer getIdTipoPagoFactura() {
        return idTipoPagoFactura;
    }

    public void setIdTipoPagoFactura(Integer idTipoPagoFactura) {
        this.idTipoPagoFactura = idTipoPagoFactura;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(String numReferencia) {
        this.numReferencia = numReferencia;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPagoFactura != null ? idTipoPagoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPagoTicket)) {
            return false;
        }
        TipoPagoTicket other = (TipoPagoTicket) object;
        if ((this.idTipoPagoFactura == null && other.idTipoPagoFactura != null) || (this.idTipoPagoFactura != null && !this.idTipoPagoFactura.equals(other.idTipoPagoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.TipoPagoTicket[ idTipoPagoFactura=" + idTipoPagoFactura + " ]";
    }
    
}
