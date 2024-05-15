package org.moquer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.moquer.utileria.Convertidor;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Autowired
    private Convertidor conversor;

    /**
     * Método de inicialización para la prueba.
     */
    @BeforeEach
    public void setUp() {
        // Puedes realizar configuraciones adicionales aquí si es necesario
    }

    /**
     * Prueba para verificar la conversión de binario a decimal.
     */
    @Test
    public void contextLoads() {
        // Caso de prueba 1: "1010" en binario debe ser 10 en decimal
        int resultado1 = conversor.convertToDecimal("1010");
        assertEquals(10, resultado1);

        // Caso de prueba 2: "1101" en binario debe ser 13 en decimal
        int resultado2 = conversor.convertToDecimal("1101");
        assertEquals(13, resultado2);

        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
    }
}
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }