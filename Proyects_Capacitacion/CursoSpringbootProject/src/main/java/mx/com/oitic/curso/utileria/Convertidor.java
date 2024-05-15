package mx.com.oitic.curso.utileria;

import org.springframework.stereotype.Component;




/**
 *
 * @author Victor Ramirez Leso
 */
@Component
public class Convertidor {
    
    private  int base = 2;

    
    //Sobrecarga de constructores
    public Convertidor() {
//        base = 2;
    }

    public Convertidor(int base) {
        this.base = base;
    }
    
    public String convierteDecimalBinario(int entrada){
        int cociente;
        int residuo;
        StringBuilder  builder = new StringBuilder();
        do {            
            cociente = entrada / base;
            residuo = entrada % base;
            entrada = cociente;
            builder.append(residuo);
        } while (cociente > 0);
        
    
    return builder.reverse().toString();
    }
    
    
}
