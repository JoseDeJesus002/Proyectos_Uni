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
import jakarta.persistence.JoinColumns;
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
@Table(name = "articulo_ticket")
@NamedQueries({
    @NamedQuery(name = "ArticuloTicket.findAll", query = "SELECT a FROM ArticuloTicket a")})
public class ArticuloTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticuloTicketPK articuloTicketPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Column(name = "descuento")
    private Short descuento;
    @JoinColumns({
        @JoinColumn(name = "id_tipo_articulo", referencedColumnName = "id_tipo_articulo", insertable = false, updatable = false),
        @JoinColumn(name = "id_lista_precio", referencedColumnName = "id_lista_precio", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PrecioArticulo precioArticulo;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticket ticket;

    public ArticuloTicket() {
    }

    public ArticuloTicket(ArticuloTicketPK articuloTicketPK) {
        this.articuloTicketPK = articuloTicketPK;
    }

    public ArticuloTicket(ArticuloTicketPK articuloTicketPK, double cantidad, double costo, double precio) {
        this.articuloTicketPK = articuloTicketPK;
        this.cantidad = cantidad;
        this.costo = costo;
        this.precio = precio;
    }

    public ArticuloTicket(int idTicket, String idTipoArticulo, String idListaPrecio) {
        this.articuloTicketPK = new ArticuloTicketPK(idTicket, idTipoArticulo, idListaPrecio);
    }

    public ArticuloTicketPK getArticuloTicketPK() {
        return articuloTicketPK;
    }

    public void setArticuloTicketPK(ArticuloTicketPK articuloTicketPK) {
        this.articuloTicketPK = articuloTicketPK;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Short getDescuento() {
        return descuento;
    }

    public void setDescuento(Short descuento) {
        this.descuento = descuento;
    }

    public PrecioArticulo getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(PrecioArticulo precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articuloTicketPK != null ? articuloTicketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloTicket)) {
            return false;
        }
        ArticuloTicket other = (ArticuloTicket) object;
        if ((this.articuloTicketPK == null && other.articuloTicketPK != null) || (this.articuloTicketPK != null && !this.articuloTicketPK.equals(other.articuloTicketPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.ArticuloTicket[ articuloTicketPK=" + articuloTicketPK + " ]";
    }
    
}
