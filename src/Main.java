public class Main {
    public static void main(String[] args) {

        CuentaBancaria cuenta1 = new CuentaAhorros("AH-001", "Ana Gómez", 1000000.0, 0.5, 500000.0);
        CuentaBancaria cuenta2 = new CuentaCorriente("CC-002", "Distribuidora XYZ", 800000.0, 5000.0, 300000.0);
        CuentaBancaria cuenta3 = new CuentaInversion("IN-003", "Carlos Ruiz", 2000000.0, 8.0, 12, 50000.0);

        // describir() - cada una imprime su propia versión
        System.out.println(cuenta1.describir());
        System.out.println(cuenta2.describir());
        System.out.println(cuenta3.describir());

        System.out.println("-----");

        // calcularComision() - Java elige la versión correcta según el tipo REAL del objeto
        System.out.println("Comisión cuenta1: " + cuenta1.calcularComision());
        System.out.println("Comisión cuenta2: " + cuenta2.calcularComision());
        System.out.println("Comisión cuenta3: " + cuenta3.calcularComision());

        System.out.println("-----");

        // realizarRetiro(500000.0) - cada una aplica su propia regla
        cuenta1.realizarRetiro(500000.0);
        System.out.println("Saldo cuenta1 tras retiro: " + cuenta1.getSaldo());

        cuenta2.realizarRetiro(500000.0);
        System.out.println("Saldo cuenta2 tras retiro: " + cuenta2.getSaldo());

        cuenta3.realizarRetiro(500000.0);
        System.out.println("Saldo cuenta3 tras retiro: " + cuenta3.getSaldo());

        /*
         * ¿Por qué usar CuentaBancaria como tipo de variable en vez del tipo específico?
         *
         * Porque así el código de Main no necesita saber (ni preocuparse por) qué tipo
         * exacto de cuenta tiene cada variable. Yo trato a las tres cuentas de la misma
         * forma - llamo los mismos métodos (describir, calcularComision, realizarRetiro) -
         * y es Java, en tiempo de ejecución, quien decide automáticamente qué versión de
         * cada método ejecutar según el tipo REAL del objeto (CuentaAhorro, CuentaCorriente
         * o CuentaInversion). Esto se llama polimorfismo.
         *
         * La ventaja concreta es que si mañana el banco crea una cuarta clase hija
         * (por ejemplo, CuentaEmpresarial), yo puedo agregarla a este arreglo o lista de
         * CuentaBancaria y todo el código de Main sigue funcionando SIN MODIFICAR NADA,
         * porque nunca dependí del tipo específico. Esto hace el código más flexible,
         * más fácil de mantener y más fácil de extender.
         */
    }
}