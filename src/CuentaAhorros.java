public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteresMensual;
    private double saldoMinimo;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo, double tasaInteresMensual, double saldoMinimo){
        super(numeroCuenta, titular, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
        this.saldoMinimo = saldoMinimo;
    }

    @Override
    public String describir(){
        return super.describir() + " Tasa mensual: " + this.tasaInteresMensual + "%";
    }

    @Override
    public double calcularComision(){
        return this.getSaldo() >= this.saldoMinimo ? 0.0 : 12000.0;
    }

    public void realizarRetiro(double monto, boolean esUrgente){
        double saldoResultante = this.getSaldo() - monto;

        if (esUrgente && saldoResultante < this.saldoMinimo){
            setSaldo(saldoResultante - 12000.0);
        }else {
            setSaldo(saldoResultante);
        }
    }


    public double calcularInteresesDelMes(){
        return getSaldo() * tasaInteresMensual / 100;
    }






}
