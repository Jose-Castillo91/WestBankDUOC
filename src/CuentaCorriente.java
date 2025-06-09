public class CuentaCorriente {
    int numeroCuenta;
    int saldo;

    public CuentaCorriente(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "numeroCuenta=" + numeroCuenta +
                ", saldo=" + saldo +
                '}';
    }

    public void depositar(int monto){
        if (monto <= 0){
            System.out.println("Monto inválido");
        } else {
            saldo += monto;
            System.out.println("Deposito realizado de manera exitosa");
            System.out.println("Su saldo actual es de " + saldo);
        }

    }
    public void girar(int monto){
        if (monto <= 0){
            System.out.println("Giro no permitido");
        } else if (monto > saldo){
            System.out.println("Giro excede saldo");
        } else {
            saldo -= monto;
            System.out.println("Giro realizado de manera exitosa");
            System.out.println("Su saldo actual es de " + saldo);
        }
    }

    public void consultarSaldo(){
        System.out.println("El saldo es: " + saldo);
    }

}
