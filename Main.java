import java.util.Scanner;

class Pagos {
    public void procesarPago() {
        System.out.println("Procesando pago");
    }

    public void procesarPago(double monto, double descuento) {
        double montoFinal = monto - (monto * (descuento / 100));
        System.out.println("Procesando pago con descuento: " + montoFinal);
    }

    public void procesarPago(double monto, int cuotas) {
        if (cuotas == 1) {
            System.out.println("Procesando pago en una sola cuota: " + monto);
        } else {
            System.out.println("Procesando pago en " + cuotas + " cuotas");
        }
    }
}

class PagoConEfectivo extends Pagos {
    @Override
    public void procesarPago() {
        System.out.println("Procesando pago en efectivo con 5% de descuento");
    }

    @Override
    public void procesarPago(double monto, double descuento) {
        double descuentoEfectivo = 5.0;
        double montoFinal = monto - (monto * (descuentoEfectivo / 100));
        System.out.println("Monto final con descuento: " + montoFinal);
    }
}

class PagoConTarjeta extends Pagos{
    @Override
    public void procesarPago() {
        System.out.println("Elija una forma de pago:");
        System.out.println("1. Pago en una sola cuota sin interés");
        System.out.println("2. Pago en 3 cuotas con 7.5% de interés");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.println("Procesando pago en una sola cuota sin interés");
        } else if (opcion == 2) {
            System.out.print("Ingrese el monto: ");
            double monto = scanner.nextDouble();
            double montoFinal = monto + (monto * 0.075);
            System.out.println("Monto final en 3 cuotas: " + montoFinal);
        } else {
            System.out.println("Opción no válida");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pagos miPago = new Pagos();
        miPago.procesarPago();
        
        PagoConEfectivo pagoEfectivo = new PagoConEfectivo();
        pagoEfectivo.procesarPago();
        pagoEfectivo.procesarPago(100, 5);

        PagoConTarjeta pagoTarjeta = new PagoConTarjeta();
        pagoTarjeta.procesarPago();
        pagoTarjeta.procesarPago(100, 3);
    }
}
