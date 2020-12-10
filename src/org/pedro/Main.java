package org.pedro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        BigDecimal montoDeseado = new BigDecimal("9000");
        BigDecimal porcentajePayo = new BigDecimal("2");
        BigDecimal porcentajeExchanger = new BigDecimal("2");

        BigDecimal montoAtransferir =
                montoDeseado.divide(
                        BigDecimal.ONE.subtract(
                                porcentajePayo.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)),
                        2,
                        RoundingMode.HALF_UP);

        System.out.println("Monto deseado: " + montoDeseado);

        montoAtransferir =
                montoAtransferir.divide(
                        BigDecimal.ONE.subtract(
                                porcentajeExchanger.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)),
                        2,
                        RoundingMode.HALF_UP);

        System.out.println("Monto a sacar de payo: " + montoAtransferir);

        montoAtransferir = montoAtransferir.subtract(
                montoAtransferir
                        .multiply(porcentajePayo)
                        .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
        System.out.println("Monto despues del 2% de payo: " + montoAtransferir);

        montoAtransferir =  montoAtransferir.subtract(
                montoAtransferir
                        .multiply(porcentajeExchanger)
                        .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
        System.out.println("Monto despues del 2% del exchanger: " + montoAtransferir);    }
}
