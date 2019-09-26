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
    @Column(name = "saldo_disponible")
    private double saldoDisponible;
    // private String nroCuenta; // (univoco)
    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;
    @OneToMany (mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>(); // (puede necesitar tabla intermedia)

    void dineroPendiente() {

    }

    void ultimosMovimientos() {

    }

    void dineroIngresado() {

    }

    void dineroExtraido() {

    }

    public Cuenta(int cuentaId, String moneda) {
        this.cuentaId = cuentaId;
        this.moneda = moneda;
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

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

}