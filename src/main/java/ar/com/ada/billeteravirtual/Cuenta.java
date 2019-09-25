package ar.com.ada.billeteravirtual;

import javax.persistence.*;
import java.util.*;

/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;
    private String moneda; // monedaId?
    private double saldo; // (balance)
    private double saldoPendiente;
    private String nroCuenta; // (univoco)
    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;
    @OneToMany (mappedBy = "cuenta")
    private List<Movimiento> movimientos = new ArrayList<Movimiento>(); // (puede necesitar tabla intermedia)

    void dineroPendiente() {

    }

    void ultimosMovimientos() {

    }

    void dineroIngresado() {

    }

    void dineroExtraido() {

    }

    public Cuenta(int cuentaId, String moneda, String nroCuenta) {
        this.cuentaId = cuentaId;
        this.moneda = moneda;
        this.nroCuenta = nroCuenta;
    }

    public Cuenta() {
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
        this.billetera.getCuentas().add(this);
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Cuenta [billetera=" + billetera + ", cuentaId=" + cuentaId + ", moneda=" + moneda + ", movimientos="
                + movimientos + ", nroCuenta=" + nroCuenta + ", saldo=" + saldo + ", saldoPendiente=" + saldoPendiente
                + "]";
    }
}