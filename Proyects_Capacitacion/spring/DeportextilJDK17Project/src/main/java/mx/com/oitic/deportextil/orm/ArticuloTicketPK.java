/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Hp
 */
@Embeddable
public class ArticuloTicketPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_ticket")
    private int idTicket;
    @Basic(optional = false)
    @Column(name = "id_tipo_articulo")
    private String idTipoArticulo;
    @Basic(optional = false)
    @Column(name = "id_lista_precio")
    private String idListaPrecio;

    public ArticuloTicketPK() {
    }

    public ArticuloTicketPK(int idTicket, String idTipoArticulo, String idListaPrecio) {
        this.idTicket = idTicket;
        this.idTipoArticulo = idTipoArticulo;
        this.idListaPrecio = idListaPrecio;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(String idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public String getIdListaPrecio() {
        return idListaPrecio;
    }

    public void setIdListaPrecio(String idListaPrecio) {
        this.idListaPrecio = idListaPrecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTicket;
        hash += (idTipoArticulo != null ? idTipoArticulo.hashCode() : 0);
        hash += (idListaPrecio != null ? idListaPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloTicketPK)) {
            return false;
        }
        ArticuloTicketPK other = (ArticuloTicketPK) object;
        if (this.idTicket != other.idTicket) {
            return false;
        }
        if ((this.idTipoArticulo == null && other.idTipoArticulo != null) || (this.idTipoArticulo != null && !this.idTipoArticulo.equals(other.idTipoArticulo))) {
            return false;
        }
        if ((this.idListaPrecio == null && other.idListaPrecio != null) || (this.idListaPrecio != null && !this.idListaPrecio.equals(other.idListaPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.ArticuloTicketPK[ idTicket=" + idTicket + ", idTipoArticulo=" + idTipoArticulo + ", idListaPrecio=" + idListaPrecio + " ]";
    }
    
}
