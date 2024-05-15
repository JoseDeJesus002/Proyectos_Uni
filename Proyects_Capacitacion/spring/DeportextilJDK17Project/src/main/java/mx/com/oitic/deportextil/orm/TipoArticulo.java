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
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tipo_articulo")
@NamedQueries({
    @NamedQuery(name = "TipoArticulo.findAll", query = "SELECT t FROM TipoArticulo t")})
public class TipoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_articulo")
    private String idTipoArticulo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "factor")
    private Double factor;
    @Basic(optional = false)
    @Column(name = "tipo_articulo")
    private String tipoArticulo;
    @Basic(optional = false)
    @Column(name = "fiscal")
    private boolean fiscal;
    @JoinTable(name = "articulo_auditoria", joinColumns = {
        @JoinColumn(name = "id_tipo_articulo", referencedColumnName = "id_tipo_articulo")}, inverseJoinColumns = {
        @JoinColumn(name = "id_auditoria", referencedColumnName = "id_auditoria")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Auditoria> auditoriaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoArticulo", fetch = FetchType.LAZY)
    private Set<PrecioArticulo> precioArticuloSet;
    @JoinColumn(name = "id_categoria_articulo", referencedColumnName = "id_categoria_articulo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaArticulo categoriaArticulo;
    @JoinColumn(name = "id_dias_entrega", referencedColumnName = "id_dias_entrega")
    @ManyToOne(fetch = FetchType.LAZY)
    private DiasEntrega diasEntrega;
    @JoinColumn(name = "id_estatus_tipo_articulo", referencedColumnName = "id_estatus_tipo_articulo")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstatusTipoArticulo estatusTipoArticulo;
    @JoinColumn(name = "id_sat_producto", referencedColumnName = "id_sat_producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private SatProducto satProducto;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadMedida unidadMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoArticulo", fetch = FetchType.LAZY)
    private Set<ArticuloPedido> articuloPedidoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoArticulo", fetch = FetchType.LAZY)
    private Set<Pieza> piezaSet;

    public TipoArticulo() {
    }

    public TipoArticulo(String idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public TipoArticulo(String idTipoArticulo, String tipoArticulo, boolean fiscal) {
        this.idTipoArticulo = idTipoArticulo;
        this.tipoArticulo = tipoArticulo;
        this.fiscal = fiscal;
    }

    public String getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(String idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public boolean getFiscal() {
        return fiscal;
    }

    public void setFiscal(boolean fiscal) {
        this.fiscal = fiscal;
    }

    public Set<Auditoria> getAuditoriaSet() {
        return auditoriaSet;
    }

    public void setAuditoriaSet(Set<Auditoria> auditoriaSet) {
        this.auditoriaSet = auditoriaSet;
    }

    public Set<PrecioArticulo> getPrecioArticuloSet() {
        return precioArticuloSet;
    }

    public void setPrecioArticuloSet(Set<PrecioArticulo> precioArticuloSet) {
        this.precioArticuloSet = precioArticuloSet;
    }

    public CategoriaArticulo getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

    public DiasEntrega getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(DiasEntrega diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public EstatusTipoArticulo getEstatusTipoArticulo() {
        return estatusTipoArticulo;
    }

    public void setEstatusTipoArticulo(EstatusTipoArticulo estatusTipoArticulo) {
        this.estatusTipoArticulo = estatusTipoArticulo;
    }

    public SatProducto getSatProducto() {
        return satProducto;
    }

    public void setSatProducto(SatProducto satProducto) {
        this.satProducto = satProducto;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Set<ArticuloPedido> getArticuloPedidoSet() {
        return articuloPedidoSet;
    }

    public void setArticuloPedidoSet(Set<ArticuloPedido> articuloPedidoSet) {
        this.articuloPedidoSet = articuloPedidoSet;
    }

    public Set<Pieza> getPiezaSet() {
        return piezaSet;
    }

    public void setPiezaSet(Set<Pieza> piezaSet) {
        this.piezaSet = piezaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoArticulo != null ? idTipoArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoArticulo)) {
            return false;
        }
        TipoArticulo other = (TipoArticulo) object;
        if ((this.idTipoArticulo == null && other.idTipoArticulo != null) || (this.idTipoArticulo != null && !this.idTipoArticulo.equals(other.idTipoArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.TipoArticulo[ idTipoArticulo=" + idTipoArticulo + " ]";
    }
    
}
