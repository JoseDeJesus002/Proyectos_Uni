/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "ticket")
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private Integer idTicket;
    @Basic(optional = false)
    @Column(name = "cancelado")
    private boolean cancelado;
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private int consecutivo;
    @Basic(optional = false)
    @Column(name = "devuelto")
    private boolean devuelto;
    @Basic(optional = false)
    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Column(name = "fecha_cancelacion")
    private LocalDate fechaCancelacion;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "info_sap", columnDefinition = "json")
    private JsonNode infoSap;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "id_tipo_pago")
    private Integer idTipoPago;
    @ManyToMany(mappedBy = "ticketSet", fetch = FetchType.LAZY)
    private Set<Factura> facturaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket", fetch = FetchType.LAZY)
    private Set<ArticuloTicket> articuloTicketSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket", fetch = FetchType.LAZY)
    private Set<TipoPagoTicket> tipoPagoTicketSet;
    @JoinColumn(name = "id_caja", referencedColumnName = "id_caja")
    @ManyToOne(fetch = FetchType.LAZY)
    private Caja caja;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "id_estatus_ticket", referencedColumnName = "id_estatus_ticket")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstatusTicket estatusTicket;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursal;
    @JoinColumn(name = "id_tipo_ticket", referencedColumnName = "id_tipo_ticket")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoTicket tipoTicket;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Integer idTicket, boolean cancelado, int consecutivo, boolean devuelto, LocalDateTime fecha, double total) {
        this.idTicket = idTicket;
        this.cancelado = cancelado;
        this.consecutivo = consecutivo;
        this.devuelto = devuelto;
        this.fecha = fecha;
        this.total = total;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }


    public LocalDate getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(LocalDate fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    
    
    public JsonNode getInfoSap() {
        return infoSap;
    }

    public void setInfoSap(JsonNode infoSap) {
        this.infoSap = infoSap;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public Set<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(Set<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }

    public Set<ArticuloTicket> getArticuloTicketSet() {
        return articuloTicketSet;
    }

    public void setArticuloTicketSet(Set<ArticuloTicket> articuloTicketSet) {
        this.articuloTicketSet = articuloTicketSet;
    }

    public Set<TipoPagoTicket> getTipoPagoTicketSet() {
        return tipoPagoTicketSet;
    }

    public void setTipoPagoTicketSet(Set<TipoPagoTicket> tipoPagoTicketSet) {
        this.tipoPagoTicketSet = tipoPagoTicketSet;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstatusTicket getEstatusTicket() {
        return estatusTicket;
    }

    public void setEstatusTicket(EstatusTicket estatusTicket) {
        this.estatusTicket = estatusTicket;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TipoTicket getTipoTicket() {
        return tipoTicket;
    }

    public void setTipoTicket(TipoTicket tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
