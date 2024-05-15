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
public class ArticuloPedidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "id_tipo_articulo")
    private String idTipoArticulo;

    public ArticuloPedidoPK() {
    }

    public ArticuloPedidoPK(int idPedido, String idTipoArticulo) {
        this.idPedido = idPedido;
        this.idTipoArticulo = idTipoArticulo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(String idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (idTipoArticulo != null ? idTipoArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloPedidoPK)) {
            return false;
        }
        ArticuloPedidoPK other = (ArticuloPedidoPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if ((this.idTipoArticulo == null && other.idTipoArticulo != null) || (this.idTipoArticulo != null && !this.idTipoArticulo.equals(other.idTipoArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.ArticuloPedidoPK[ idPedido=" + idPedido + ", idTipoArticulo=" + idTipoArticulo + " ]";
    }
    
}
