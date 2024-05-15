package mx.com.oitic.curso;

import mx.com.oitic.curso.utileria.Convertidor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  
class CursoApplicationTests {

    @Autowired
    private Convertidor convertidor;

    @BeforeEach
    public void setuP(){
        
    }
    
	@Test
	void contextLoads() {
           String resultado = convertidor.convierteDecimalBinario(8);
            System.out.println("Resultado : " + resultado);
	}

}
