public class CuentaInversion extends CuentaBancaria {

    private double tasaAnual;
    private int plazoMeses;
    private double penalizacionRetiroAnticipado;

    public CuentaInversion(String numeroCuenta, String titular, double saldo,
                            double tasaAnual, int plazoMeses, double penalizacionRetiroAnticipado) {
        super(numeroCuenta, titular, saldo);
        this.tasaAnual = tasaAnual;
        this.plazoMeses = plazoMeses;
        this.penalizacionRetiroAnticipado = penalizacionRetiroAnticipado;
    }

    @Override
    public String describir() {
        return super.describir() + "  Plazo: " + this.plazoMeses + " meses. Tasa anual: " + this.tasaAnual + "%";
    }

    @Override
    public double calcularComision() {
        return this.penalizacionRetiroAnticipado;
    }

    // sobrecarga: mismo nombre, distinta firma
    public double calcularComision(int mesesTranscurridos) {
        if (mesesTranscurridos >= this.plazoMeses) {
            return 0.0;
        } else {
            return this.penalizacionRetiroAnticipado;
        }
    }

    @Override
    public void realizarRetiro(double monto) {
        double saldoResultante = this.getSaldo() - monto - this.penalizacionRetiroAnticipado;
        setSaldo(saldoResultante);
    }
}