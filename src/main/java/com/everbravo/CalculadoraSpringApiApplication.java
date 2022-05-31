package com.everbravo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** http://localhost:8080/api/calcula?primero=7&segundo=9&operacion=division
*http://localhost:8080/api/calcula?primero=7&segundo=9&operacion=multiplicacion
*http://localhost:8080/api/calcula?primero=7&segundo=9&operacion=suma
*http://localhost:8080/api/calcula?primero=7&segundo=9&operacion=resta
*/

@Configuration
@ComponentScan(basePackages = "com.everbravo")
@EnableAutoConfiguration
public class CalculadoraSpringApiApplication extends SpringBootServletInitializer {

    /**
     * Añadimos {@link ConfigAplicacion} al resto de archiovos del programa
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CalculadoraSpringApiApplication.class);
    }


    /**
     * Comienzo del programa ejecutando {@link ConfigAplicacion}
     * con los argumentos del programa
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CalculadoraSpringApiApplication.class, args);
    }
}