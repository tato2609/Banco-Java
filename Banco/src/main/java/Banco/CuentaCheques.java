package Banco;

import javax.swing.JOptionPane;

public class CuentaCheques extends Cuenta implements MovimientosCuenta {
    private double cuotaPorTransaccion;
    private static int contadorCheques = 0; // Contador para los cheques
    private final int numeroCheque; // Número de cheque único

    public CuentaCheques(double saldoInicial, double cuotaPorTransaccion) {
        super(saldoInicial);
        this.cuotaPorTransaccion = cuotaPorTransaccion;
        contadorCheques++; // Incrementar contador al crear un cheque
        this.numeroCheque = contadorCheques; // Asignar número de cheque
    }

    @Override
    public void depositar(double monto) {
        saldo += (monto - cuotaPorTransaccion);
    }

    @Override
    public void retirar(double monto) {
        if (monto + cuotaPorTransaccion > saldo) {
            JOptionPane.showMessageDialog(null, "El valor a retirar más la comisión excede el saldo de la cuenta", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            saldo -= (monto + cuotaPorTransaccion); // Restar monto y cuota
        }
    }

    public double consultarSaldo() {
        return saldo; // Retornar el saldo actual
    }

    public double getCuota() {
        return cuotaPorTransaccion; // Método para obtener la cuota por transacción
    }

    @Override
    public String toString() {
        return "CuentaCheques{" +
                "numeroCuenta=" + getNumeroCuenta() +
                ", numeroCheque=" + numeroCheque +
                ", saldo=" + saldo +
                '}';
    }
}
