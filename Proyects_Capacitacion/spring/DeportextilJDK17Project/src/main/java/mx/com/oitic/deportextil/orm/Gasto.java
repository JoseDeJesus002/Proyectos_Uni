/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "gasto")
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g")})
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GastoPK gastoPK;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "num_factura")
    private String numFactura;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_estatus_tipo_gasto", referencedColumnName = "id_estatus_tipo_gasto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstatusTipoGasto estatusTipoGasto;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursal;
    @JoinColumn(name = "id_tipo_gasto", referencedColumnName = "id_tipo_gasto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoGasto tipoGasto;

    public Gasto() {
    }

    public Gasto(GastoPK gastoPK) {
        this.gastoPK = gastoPK;
    }

    public Gasto(GastoPK gastoPK, Date fecha) {
        this.gastoPK = gastoPK;
        this.fecha = fecha;
    }

    public Gasto(long idGasto, String idSucursal) {
        this.gastoPK = new GastoPK(idGasto, idSucursal);
    }

    public GastoPK getGastoPK() {
        return gastoPK;
    }

    public void setGastoPK(GastoPK gastoPK) {
        this.gastoPK = gastoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstatusTipoGasto getEstatusTipoGasto() {
        return estatusTipoGasto;
    }

    public void setEstatusTipoGasto(EstatusTipoGasto estatusTipoGasto) {
        this.estatusTipoGasto = estatusTipoGasto;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TipoGasto getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(TipoGasto tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gastoPK != null ? gastoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.gastoPK == null && other.gastoPK != null) || (this.gastoPK != null && !this.gastoPK.equals(other.gastoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Gasto[ gastoPK=" + gastoPK + " ]";
    }
    
}
