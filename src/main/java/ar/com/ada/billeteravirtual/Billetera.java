package ar.com.ada.billeteravirtual;

import java.util.*;

import javax.persistence.*;

/**
 * Billetera
 */
public class Billetera {

    @Id
    @Column(name = "billetera_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billeteraId;
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public Billetera(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public int getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    @Override
    public String toString() {
        return "Billetera [Cuentas=" + cuentas + ", billeteraId=" + billeteraId + "]";
    }

}