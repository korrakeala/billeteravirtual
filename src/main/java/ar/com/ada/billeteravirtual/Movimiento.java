package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;

/**
 * Movimiento
 */
public class Movimiento {

    @Id
    @Column(name = "movimiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movimientoId;
    private Date fechaMov;
    //private Coordenada ubicacion (fase 2);

    private String tipoOp; //"Entrada" "Salida"
    private String conceptoOp; //"Pagos" "Deposito" "Transferencia" "Cobro"
    private String detalle;
    private int estado; //"Aprobado" "Pendiente" "Rechazado"
    private Usuario deUsuario;
    private Usuario aUsuario;
    private int deUsuarioId;
    private int aUsuarioId;
    private Cuenta cuentaDestino;
    private Cuenta cuentaOrigen;
    private int cuentaDestinoId;
    private int cuentaOrigenId;

    public Movimiento() {
    }

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(String tipoOp) {
        this.tipoOp = tipoOp;
    }

    public String getConceptoOp() {
        return conceptoOp;
    }

    public void setConceptoOp(String conceptoOp) {
        this.conceptoOp = conceptoOp;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getDeUsuario() {
        return deUsuario;
    }

    public void setDeUsuario(Usuario deUsuario) {
        this.deUsuario = deUsuario;
    }

    public Usuario getaUsuario() {
        return aUsuario;
    }

    public void setaUsuario(Usuario aUsuario) {
        this.aUsuario = aUsuario;
    }

    public int getDeUsuarioId() {
        return deUsuarioId;
    }

    public void setDeUsuarioId(int deUsuarioId) {
        this.deUsuarioId = deUsuarioId;
    }

    public int getaUsuarioId() {
        return aUsuarioId;
    }

    public void setaUsuarioId(int aUsuarioId) {
        this.aUsuarioId = aUsuarioId;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(int cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public int getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(int cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    @Override
    public String toString() {
        return "Movimiento [aUsuario=" + aUsuario + ", aUsuarioId=" + aUsuarioId + ", conceptoOp=" + conceptoOp
                + ", cuentaDestino=" + cuentaDestino + ", cuentaDestinoId=" + cuentaDestinoId + ", cuentaOrigen="
                + cuentaOrigen + ", cuentaOrigenId=" + cuentaOrigenId + ", deUsuario=" + deUsuario + ", deUsuarioId="
                + deUsuarioId + ", detalle=" + detalle + ", estado=" + estado + ", fechaMov=" + fechaMov
                + ", movimientoId=" + movimientoId + ", tipoOp=" + tipoOp + "]";
    }

}