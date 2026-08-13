public class CuentaCorriente extends CuentaBancaria {

    private double comisionPorTransaccion;
    private double limiteSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo,
            double comisionPorTransaccion, double limiteSobregiro) {
        super(numeroCuenta, titular, saldo);
        this.comisionPorTransaccion = comisionPorTransaccion;
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public String describir() {
        return super.describir() + " Comisión por transacción: $" + this.comisionPorTransaccion;
    }

    @Override
    public double calcularComision() {
        return this.comisionPorTransaccion;
    }

    @Override
    public void realizarRetiro(double monto) {
        double saldoResultante = this.getSaldo() - monto - this.comisionPorTransaccion;

        if (saldoResultante < -this.limiteSobregiro) {
            System.out.println("El retiro no es posible.");
        } else {
            setSaldo(saldoResultante);
        }
    }
}