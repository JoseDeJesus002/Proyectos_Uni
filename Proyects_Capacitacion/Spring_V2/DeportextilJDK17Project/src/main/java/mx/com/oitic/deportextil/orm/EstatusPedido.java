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
@Table(name = "estatus_pedido")
@NamedQueries({
    @NamedQuery(name = "EstatusPedido.findAll", query = "SELECT e FROM EstatusPedido e")})
public class EstatusPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus_pedido")
    private Integer idEstatusPedido;
    @Basic(optional = false)
    @Column(name = "estatus_pedido")
    private String estatusPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusPedido", fetch = FetchType.LAZY)
    private Set<Pedido> pedidoSet;

    public EstatusPedido() {
    }

    public EstatusPedido(Integer idEstatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
    }

    public EstatusPedido(Integer idEstatusPedido, String estatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
        this.estatusPedido = estatusPedido;
    }

    public Integer getIdEstatusPedido() {
        return idEstatusPedido;
    }

    public void setIdEstatusPedido(Integer idEstatusPedido) {
        this.idEstatusPedido = idEstatusPedido;
    }

    public String getEstatusPedido() {
        return estatusPedido;
    }

    public void setEstatusPedido(String estatusPedido) {
        this.estatusPedido = estatusPedido;
    }

    public Set<Pedido> getPedidoSet() {
        return pedidoSet;
    }

    public void setPedidoSet(Set<Pedido> pedidoSet) {
        this.pedidoSet = pedidoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusPedido != null ? idEstatusPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusPedido)) {
            return false;
        }
        EstatusPedido other = (EstatusPedido) object;
        if ((this.idEstatusPedido == null && other.idEstatusPedido != null) || (this.idEstatusPedido != null && !this.idEstatusPedido.equals(other.idEstatusPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.EstatusPedido[ idEstatusPedido=" + idEstatusPedido + " ]";
    }
    
}
