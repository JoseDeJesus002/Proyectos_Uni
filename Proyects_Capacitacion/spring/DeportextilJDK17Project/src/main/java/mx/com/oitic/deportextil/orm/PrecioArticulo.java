/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
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
@Table(name = "precio_articulo")
@NamedQueries({
    @NamedQuery(name = "PrecioArticulo.findAll", query = "SELECT p FROM PrecioArticulo p")})
public class PrecioArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrecioArticuloPK precioArticuloPK;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Column(name = "fecha_carga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;
    @Column(name = "activo")
    private Boolean activo;
    @Lob
    @Column(name = "info_sap")
    private String infoSap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precioArticulo", fetch = FetchType.LAZY)
    private Set<ArticuloTicket> articuloTicketSet;
    @JoinColumn(name = "id_lista_precio", referencedColumnName = "id_lista_precio", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ListaPrecio listaPrecio;
    @JoinColumn(name = "id_tipo_articulo", referencedColumnName = "id_tipo_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoArticulo tipoArticulo;

    public PrecioArticulo() {
    }

    public PrecioArticulo(PrecioArticuloPK precioArticuloPK) {
        this.precioArticuloPK = precioArticuloPK;
    }

    public PrecioArticulo(PrecioArticuloPK precioArticuloPK, double precio) {
        this.precioArticuloPK = precioArticuloPK;
        this.precio = precio;
    }

    public PrecioArticulo(String idTipoArticulo, String idListaPrecio) {
        this.precioArticuloPK = new PrecioArticuloPK(idTipoArticulo, idListaPrecio);
    }

    public PrecioArticuloPK getPrecioArticuloPK() {
        return precioArticuloPK;
    }

    public void setPrecioArticuloPK(PrecioArticuloPK precioArticuloPK) {
        this.precioArticuloPK = precioArticuloPK;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getInfoSap() {
        return infoSap;
    }

    public void setInfoSap(String infoSap) {
        this.infoSap = infoSap;
    }

    public Set<ArticuloTicket> getArticuloTicketSet() {
        return articuloTicketSet;
    }

    public void setArticuloTicketSet(Set<ArticuloTicket> articuloTicketSet) {
        this.articuloTicketSet = articuloTicketSet;
    }

    public ListaPrecio getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(ListaPrecio listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precioArticuloPK != null ? precioArticuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioArticulo)) {
            return false;
        }
        PrecioArticulo other = (PrecioArticulo) object;
        if ((this.precioArticuloPK == null && other.precioArticuloPK != null) || (this.precioArticuloPK != null && !this.precioArticuloPK.equals(other.precioArticuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.PrecioArticulo[ precioArticuloPK=" + precioArticuloPK + " ]";
    }
    
}
