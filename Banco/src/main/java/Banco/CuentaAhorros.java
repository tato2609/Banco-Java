package Banco;



import javax.swing.JOptionPane;

public class CuentaAhorros extends Cuenta implements MovimientosCuenta {
    private double tasaInteres;

    public CuentaAhorros(double saldoInicial, double tasaInteres) {
        super(saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public double calcularInteres() {
        return (tasaInteres / 100) * saldo;
    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto > saldo) {
            JOptionPane.showMessageDialog(null, "El valor a retirar excede el saldo de la cuenta", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            saldo -= monto;
        }
    }

    public double consultarSaldo() {
        return saldo + calcularInteres();
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" +
                "numeroCuenta=" + getNumeroCuenta() +
                ", saldo=" + saldo +
                '}';
    }
}




