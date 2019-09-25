package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;

/**
 * Movimiento
 */
@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @Column(name = "movimiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movimientoId;
    @Column(name = "fecha_mov")
    private Date fechaMov;
    private double importe;
    // private Coordenada ubicacion (fase 2);
    private String tipo; // "Entrada" "Salida"
    private String concepto; // "Pagos" "Deposito" "Transferencia" "Cobro"
    private String detalle;
    private int estado; // "Aprobado" "Pendiente" "Rechazado"
    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;
    @Column(name = "de_usuario_id")
    private int deUsuarioId;
    @Column(name = "a_usuario_id")
    private int aUsuarioId;
    @Column(name = "cuenta_destino_id")
    private int cuentaDestinoId;
    @Column(name = "cuenta_origen_id")
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.cuenta.getMovimientos().add(this);
    }

    @Override
    public String toString() {
        return "Movimiento [aUsuarioId=" + aUsuarioId + ", concepto=" + concepto + ", cuenta=" + cuenta
                + ", cuentaDestinoId=" + cuentaDestinoId + ", cuentaOrigenId=" + cuentaOrigenId + ", deUsuarioId="
                + deUsuarioId + ", detalle=" + detalle + ", estado=" + estado + ", fechaMov=" + fechaMov + ", importe="
                + importe + ", movimientoId=" + movimientoId + ", tipo=" + tipo + "]";
    }

}