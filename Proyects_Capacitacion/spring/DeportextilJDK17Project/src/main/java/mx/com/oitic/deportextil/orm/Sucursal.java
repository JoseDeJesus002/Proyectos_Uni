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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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
@Table(name = "sucursal")
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private String idSucursal;
    @Column(name = "abreviatura")
    private String abreviatura;
    @Column(name = "ajuste_hora")
    private Integer ajusteHora;
    @Column(name = "color_sucursal")
    private String colorSucursal;
    @Column(name = "diferenciador_factura")
    private String diferenciadorFactura;
    @Lob
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "email")
    private String email;
    @Column(name = "fax")
    private String fax;
    @Column(name = "fecha_aprobacion_sat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacionSat;
    @Column(name = "habilitado_bodega")
    private Integer habilitadoBodega;
    @Lob
    @Column(name = "info_sap")
    private String infoSap;
    @Column(name = "llave")
    private String llave;
    @Column(name = "maximo_folio_sat")
    private Integer maximoFolioSat;
    @Column(name = "no_aprobacion_sat")
    private String noAprobacionSat;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "sucursal")
    private String sucursal;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "telefono_alt")
    private String telefonoAlt;
    @ManyToMany(mappedBy = "sucursalSet", fetch = FetchType.LAZY)
    private Set<Banco> bancoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Pedido> pedidoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Auditoria> auditoriaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Traspaso> traspasoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal1", fetch = FetchType.LAZY)
    private Set<Traspaso> traspasoSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Cliente> clienteSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Usuario> usuarioSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Caja> cajaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Gasto> gastoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal", fetch = FetchType.LAZY)
    private Set<Ticket> ticketSet;
    @JoinColumn(name = "id_cuenta_bancaria", referencedColumnName = "id_cuenta_bancaria")
    @ManyToOne(fetch = FetchType.LAZY)
    private CuentaBancaria cuentaBancaria;
    @JoinColumn(name = "id_lista_precio", referencedColumnName = "id_lista_precio")
    @ManyToOne(fetch = FetchType.LAZY)
    private ListaPrecio listaPrecio;
    @OneToMany(mappedBy = "sucursal1", fetch = FetchType.LAZY)
    private Set<Sucursal> sucursalSet;
    @JoinColumn(name = "id_sucursal_padre", referencedColumnName = "id_sucursal")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursal1;

    public Sucursal() {
    }

    public Sucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursal(String idSucursal, String sucursal) {
        this.idSucursal = idSucursal;
        this.sucursal = sucursal;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getAjusteHora() {
        return ajusteHora;
    }

    public void setAjusteHora(Integer ajusteHora) {
        this.ajusteHora = ajusteHora;
    }

    public String getColorSucursal() {
        return colorSucursal;
    }

    public void setColorSucursal(String colorSucursal) {
        this.colorSucursal = colorSucursal;
    }

    public String getDiferenciadorFactura() {
        return diferenciadorFactura;
    }

    public void setDiferenciadorFactura(String diferenciadorFactura) {
        this.diferenciadorFactura = diferenciadorFactura;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Date getFechaAprobacionSat() {
        return fechaAprobacionSat;
    }

    public void setFechaAprobacionSat(Date fechaAprobacionSat) {
        this.fechaAprobacionSat = fechaAprobacionSat;
    }

    public Integer getHabilitadoBodega() {
        return habilitadoBodega;
    }

    public void setHabilitadoBodega(Integer habilitadoBodega) {
        this.habilitadoBodega = habilitadoBodega;
    }

    public String getInfoSap() {
        return infoSap;
    }

    public void setInfoSap(String infoSap) {
        this.infoSap = infoSap;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public Integer getMaximoFolioSat() {
        return maximoFolioSat;
    }

    public void setMaximoFolioSat(Integer maximoFolioSat) {
        this.maximoFolioSat = maximoFolioSat;
    }

    public String getNoAprobacionSat() {
        return noAprobacionSat;
    }

    public void setNoAprobacionSat(String noAprobacionSat) {
        this.noAprobacionSat = noAprobacionSat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoAlt() {
        return telefonoAlt;
    }

    public void setTelefonoAlt(String telefonoAlt) {
        this.telefonoAlt = telefonoAlt;
    }

    public Set<Banco> getBancoSet() {
        return bancoSet;
    }

    public void setBancoSet(Set<Banco> bancoSet) {
        this.bancoSet = bancoSet;
    }

    public Set<Pedido> getPedidoSet() {
        return pedidoSet;
    }

    public void setPedidoSet(Set<Pedido> pedidoSet) {
        this.pedidoSet = pedidoSet;
    }

    public Set<Auditoria> getAuditoriaSet() {
        return auditoriaSet;
    }

    public void setAuditoriaSet(Set<Auditoria> auditoriaSet) {
        this.auditoriaSet = auditoriaSet;
    }

    public Set<Traspaso> getTraspasoSet() {
        return traspasoSet;
    }

    public void setTraspasoSet(Set<Traspaso> traspasoSet) {
        this.traspasoSet = traspasoSet;
    }

    public Set<Traspaso> getTraspasoSet1() {
        return traspasoSet1;
    }

    public void setTraspasoSet1(Set<Traspaso> traspasoSet1) {
        this.traspasoSet1 = traspasoSet1;
    }

    public Set<Cliente> getClienteSet() {
        return clienteSet;
    }

    public void setClienteSet(Set<Cliente> clienteSet) {
        this.clienteSet = clienteSet;
    }

    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    public Set<Caja> getCajaSet() {
        return cajaSet;
    }

    public void setCajaSet(Set<Caja> cajaSet) {
        this.cajaSet = cajaSet;
    }

    public Set<Gasto> getGastoSet() {
        return gastoSet;
    }

    public void setGastoSet(Set<Gasto> gastoSet) {
        this.gastoSet = gastoSet;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public ListaPrecio getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(ListaPrecio listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public Set<Sucursal> getSucursalSet() {
        return sucursalSet;
    }

    public void setSucursalSet(Set<Sucursal> sucursalSet) {
        this.sucursalSet = sucursalSet;
    }

    public Sucursal getSucursal1() {
        return sucursal1;
    }

    public void setSucursal1(Sucursal sucursal1) {
        this.sucursal1 = sucursal1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Sucursal[ idSucursal=" + idSucursal + " ]";
    }
    
}
