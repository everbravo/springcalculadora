/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.everbravo.model.data;

/**
 *
 * @author everbravovergara
 */
import java.math.BigDecimal;

public interface CalculadoraInterface {

    /**
     * Method is used for calculation for given numbers and operator type
     * Calcula para los números proporcionados como argumentos el resutlado de
     * la operación
     *
     * @param primerNumero
     * @param segundoNumero
     * @param operacion sumar, restar, multiplicar, dividir...
     * @return el resultado de la operación (depende del tipo de operación). Se ha decidido que valor doble
     *              es más que suficiente para representar la operación
     */
    double calcula(BigDecimal primerNumero, BigDecimal segundoNumero, String operacion);
}

