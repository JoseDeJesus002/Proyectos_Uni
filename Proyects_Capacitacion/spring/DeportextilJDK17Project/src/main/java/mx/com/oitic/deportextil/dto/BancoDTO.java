
package mx.com.oitic.deportextil.dto;
  
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

  
  /**
   *
   * Objeto de transferencia de datos para la clase Banco 
   */
   
   @SuppressWarnings("serial")
   @JsonInclude(Include.NON_NULL)
    @Getter
    @Setter
   public class BancoDTO  implements java.io.Serializable  { 
   
   public  BancoDTO(){
   }

    /**
     * Este codigo se genero con Arquitecto MVC.
     * Constructor con todas las propiedades del DTO
     *
     */
   public  BancoDTO(Integer idBanco,String banco){
    
     this.idBanco=idBanco;
    
     this.banco=banco;
        
}
   
    
    /**
     * Este codigo se genero con Arquitecto MVC.
     * Esta propiedad corresponde con el mapeo en base de datos 
     * de la columna banco.IdBanco
     *
     */
     
     protected Integer idBanco;
    
    /**
     * Este codigo se genero con Arquitecto MVC.
     * Esta propiedad corresponde con el mapeo en base de datos 
     * de la columna banco.Banco
     *
     */
     @NotEmpty(message = "required.banco.banco" )@Size(max=255, message = "validator.banco.banco" )
     protected String banco;
    

 }
  