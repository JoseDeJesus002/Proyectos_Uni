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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "cancelado")
    private int cancelado;
    @Lob
    @Column(name = "condicion")
    private String condicion;
    @Basic(optional = false)
    @Column(name = "credito")
    private int credito;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "fecha_cancelacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCancelacion;
    @Basic(optional = false)
    @Column(name = "no_factura")
    private int noFactura;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "uuid")
    private String uuid;
    @Lob
    @Column(name = "info_sap")
    private String infoSap;
    @JoinTable(name = "ticket_factura", joinColumns = {
        @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")}, inverseJoinColumns = {
        @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Ticket> ticketSet;
    @JoinColumn(name = "id_estatus_factura", referencedColumnName = "id_estatus_factura")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstatusFactura estatusFactura;
    @JoinColumn(name = "id_metodo_pago", referencedColumnName = "id_metodo_pago")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MetodoPago metodoPago;
    @JoinColumn(name = "id_uso_cfdi", referencedColumnName = "id_uso_cfdi")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UsoCfdi usoCfdi;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, int cancelado, int credito, Date fecha, int noFactura) {
        this.idFactura = idFactura;
        this.cancelado = cancelado;
        this.credito = credito;
        this.fecha = fecha;
        this.noFactura = noFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public int getCancelado() {
        return cancelado;
    }

    public void setCancelado(int cancelado) {
        this.cancelado = cancelado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public int getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getInfoSap() {
        return infoSap;
    }

    public void setInfoSap(String infoSap) {
        this.infoSap = infoSap;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    public EstatusFactura getEstatusFactura() {
        return estatusFactura;
    }

    public void setEstatusFactura(EstatusFactura estatusFactura) {
        this.estatusFactura = estatusFactura;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public UsoCfdi getUsoCfdi() {
        return usoCfdi;
    }

    public void setUsoCfdi(UsoCfdi usoCfdi) {
        this.usoCfdi = usoCfdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
