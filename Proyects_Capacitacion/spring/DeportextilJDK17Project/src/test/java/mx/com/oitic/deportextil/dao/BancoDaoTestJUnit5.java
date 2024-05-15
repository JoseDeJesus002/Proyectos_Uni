
package mx.com.oitic.deportextil.dao; 
  
import java.util.List;
import mx.com.oitic.deportextil.orm.Banco;
import mx.com.oitic.deportextil.dto.BancoDTO;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.EnableTransactionManagement;
    

  /**
   *
   * interface BancoDaoImpl que implementa el contrato de 
   * persistencia y consulta de la entidad banco
   */

@DataJpaTest
//@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
@EnableTransactionManagement 
public class BancoDaoTestJUnit5  { 

    @Autowired
    private BancoDao bancoDao;
	
    private BancoDTO oBancoDTO;

    
    private Banco oBanco;
    
    /**
     * Este codigo se genero con Arquitecto MVC.
     * inicializacion de los datos de pruba de un objeto de la clase Banco
     */
        
    @BeforeEach
    public void setUp() {
     oBanco = new Banco();
     oBancoDTO = new BancoDTO();

    
//            oBanco.setIdBanco(100);
//            oBancoDTO.setIdBanco(100);
        
//            oBancoDTO.setBanco("BBVA Bancomer");
            oBanco.setBanco("BBVA Bancomer");
        
       
    
    }


    /**
     * Este codigo se genero con Arquitecto MVC.
     * Pruebas unitarias de capa de persistencia
     * para creacion de un objeto de la clase Banco
     */
//    @Disabled
    @Rollback(false)
    @Test
    public void inserta(){
        assertNotNull(bancoDao.save(oBanco));
    }

    /**
     * Este codigo se genero con Arquitecto MVC.
     * Pruebas unitarias de capa de persistencia
     * para actualizacion de un objeto de la clase Banco
     */
    @Disabled
    @Test
    public void actualiza(){
        assertTrue (bancoDao.update(oBancoDTO) > 0);
    }

    /**
     * Este codigo se genero con Arquitecto MVC.
     * Pruebas unitarias de capa de persistencia
     * para consulta de un objeto de la clase Banco
     * por llave primaria
     */
    @Disabled
    @Test
    public void getById(){
        assertNotNull(bancoDao.getById(oBancoDTO));
    }
        
        
    
    /**
     * Este codigo se genero con Arquitecto MVC.
     * Pruebas unitarias de capa de persistencia
     * para consulta del total de objetos de la clase Banco
     * que coincidan con el criterio de busqueda proporcionado
     */
    @Disabled
    @Test
    public void selectByExample(){
        assertTrue(bancoDao.selectByExample("cadena").size()  > 0 );
    }
    
    /**
     * Este codigo se genero con Arquitecto MVC.
     * Pruebas unitarias de capa de persistencia
     * para consulta del total de objetos de la clase Banco
     * que coincidan con el criterio de busqueda proporcionado
     */
    @Disabled
    @Test
    public void selectByCatalogo(){
        List<BancoDTO> lstBanco = bancoDao.selectByExample(null);
        
        assertTrue(!lstBanco.isEmpty() );
    }
    
    
            
        
}
  