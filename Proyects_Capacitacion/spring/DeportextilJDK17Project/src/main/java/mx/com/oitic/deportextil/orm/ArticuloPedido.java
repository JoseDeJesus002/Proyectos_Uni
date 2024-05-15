/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "articulo_pedido")
@NamedQueries({
    @NamedQuery(name = "ArticuloPedido.findAll", query = "SELECT a FROM ArticuloPedido a")})
public class ArticuloPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticuloPedidoPK articuloPedidoPK;
    @Column(name = "observaciones")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;
    @JoinColumn(name = "id_tipo_articulo", referencedColumnName = "id_tipo_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoArticulo tipoArticulo;

    public ArticuloPedido() {
    }

    public ArticuloPedido(ArticuloPedidoPK articuloPedidoPK) {
        this.articuloPedidoPK = articuloPedidoPK;
    }

    public ArticuloPedido(int idPedido, String idTipoArticulo) {
        this.articuloPedidoPK = new ArticuloPedidoPK(idPedido, idTipoArticulo);
    }

    public ArticuloPedidoPK getArticuloPedidoPK() {
        return articuloPedidoPK;
    }

    public void setArticuloPedidoPK(ArticuloPedidoPK articuloPedidoPK) {
        this.articuloPedidoPK = articuloPedidoPK;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        hash += (articuloPedidoPK != null ? articuloPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloPedido)) {
            return false;
        }
        ArticuloPedido other = (ArticuloPedido) object;
        if ((this.articuloPedidoPK == null && other.articuloPedidoPK != null) || (this.articuloPedidoPK != null && !this.articuloPedidoPK.equals(other.articuloPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.ArticuloPedido[ articuloPedidoPK=" + articuloPedidoPK + " ]";
    }
    
}
