/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.everbravo.model.data;

import com.everbravo.model.operations.Operacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementación básica de la interfaz {@link IServicioCalculadora}
 */
@Service
public class Calculadora implements CalculadoraInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(Calculadora.class);


    /**
     * Intentamos convertir la operación, sino podemos lanzamos un error,
     * y realizamos la operación correspondiente
     * @param primerNumero
     * @param segundoNumero
     * @param opTexto
     * @return
     */
    @Override
    public double calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String opTexto) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calculando resultado para : {} {} {}", primerNumero, segundoNumero, opTexto);
        }

        Operacion operacion = Operacion.desdeValor(opTexto);

        if(operacion == null) {
            throw new RuntimeException("Operación imposible de procesar: " + opTexto);
        }

        switch (operacion) {
            case SUMA:
                return primerNumero.add(segundoNumero).doubleValue();
            case RESTA:
                return primerNumero.subtract(segundoNumero).doubleValue();
            case MULTIPLICACION:
                return primerNumero.multiply(segundoNumero).doubleValue();
            case DIVISION:
                return primerNumero.divide(segundoNumero, 2, RoundingMode.HALF_UP).doubleValue();
            default:
                if(LOGGER.isErrorEnabled()) {
                    LOGGER.error("Operación no soportada para ser calculada: {}", operacion);
                }
                throw new RuntimeException("Operación no soportada para ser calculada: " + operacion.toString());

        }
    }
}
