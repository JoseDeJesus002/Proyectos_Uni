
package mx.com.oitic.deportextil.usecase;
  
import mx.com.oitic.deportextil.dto.BancoDTO;
import org.springframework.dao.DataAccessException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
  



  /**
   *
   * Interface BancoUseCase que declara el contrato de
 negocio para la entidad Banco
   */
   
   public interface BancoUseCase  { 

    /**
     * Este codigo se genero con Arquitecto MVC.
     * Este metodo declara las reglas de negocio  
     * de creacion de un registro Banco
     * @param pBanco 	
     * @return  	
     */

    Serializable insertBanco(BancoDTO pBanco) throws DataAccessException;
    
    /**
     * Este codigo se genero con Arquitecto MVC.
     * Este metodo declara las reglas de negocio 
     * para seleccion de un registro en  
     * la clase Banco
     * mediante la llave primaria 	
     * @param pBanco 	
     * @return  	
     */
    BancoDTO getByIdBanco(BancoDTO pBanco) throws DataAccessException;



    /**
     * Este codigo se genero con Arquitecto MVC.
     * Este método ejecuta las reglas de negocio 
     * para dar de baja fisicamente un registro en  
     * la clase Banco
     * mediante la llave primaria 	
     * @param pBanco 	
     * @return  	
     */
    void deleteBanco(BancoDTO pBanco) throws DataAccessException;
	
	
    /**
     * Este codigo se genero con Arquitecto MVC.
     * Este método declara las reglas de negocio 
     * para actualizar un registro en  
     * la tabla Banco
     * mediante la llave primaria 	
     * @param pBanco 	
     * @return  	
     */
    int updateBanco(BancoDTO pBanco) throws DataAccessException;
	

    
    /**
     * Este codigo se genero con Arquitecto MVC.
     * Este método declara las reglas de negocio 
     * para seleccion de registros en  
     * la clase Banco 
     * dependiendo de las propiedades del parametro 	
     * @param pCriterio 	
     * @return  	
     */
	List<BancoDTO> selectByExampleBanco(Optional<String> pCriterio) throws DataAccessException;
    
	
    }
  