/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.oitic.deportextil.orm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private String idCliente;
    @Column(name = "curp")
    private String curp;
    @Lob
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "email")
    private String email;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite_credito")
    private Double limiteCredito;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Basic(optional = false)
    @Column(name = "rfc")
    private String rfc;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Lob
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "tipo_persona")
    private short tipoPersona;
    @Lob
    @Column(name = "info_sap")
    private String infoSap;
    @JoinColumn(name = "id_dias_credito", referencedColumnName = "id_dias_credito")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DiasCredito diasCredito;
    @JoinColumn(name = "id_estatus_cliente", referencedColumnName = "id_estatus_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstatusCliente estatusCliente;
    @JoinColumn(name = "id_regimen_fiscal", referencedColumnName = "id_regimen_fiscal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RegimenFiscal regimenFiscal;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursal;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Ticket> ticketSet;

    public Cliente() {
    }

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String idCliente, String nombre, String rfc, short tipoPersona) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.rfc = rfc;
        this.tipoPersona = tipoPersona;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public short getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(short tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getInfoSap() {
        return infoSap;
    }

    public void setInfoSap(String infoSap) {
        this.infoSap = infoSap;
    }

    public DiasCredito getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(DiasCredito diasCredito) {
        this.diasCredito = diasCredito;
    }

    public EstatusCliente getEstatusCliente() {
        return estatusCliente;
    }

    public void setEstatusCliente(EstatusCliente estatusCliente) {
        this.estatusCliente = estatusCliente;
    }

    public RegimenFiscal getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(RegimenFiscal regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.oitic.deportextil.orm.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
