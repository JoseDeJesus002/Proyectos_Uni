
package mx.com.oitic.deportextil.usecase.impl;
  
import mx.com.oitic.deportextil.dto.BancoDTO;
import mx.com.oitic.deportextil.dao.BancoDao;
import mx.com.oitic.deportextil.usecase.BancoUseCase;
    
import mx.com.oitic.deportextil.exception.InexistenteException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import mx.com.oitic.deportextil.orm.Banco;

/**
 *
 * Clase BancoUseCaseImpl que implementa el contrato de 
 * negocio para la entidad Banco
 */
@Service("bancoUseCase")
public class BancoUseCaseImpl implements Serializable, BancoUseCase{ 

    @Autowired
    private BancoDao bancoDao;
	
    /**
     *Constructor vacio por default
     */
    public BancoUseCaseImpl(){}

    /**
     * @see BancoUseCase#insertBanco(mx.com.oitic.deportextil.dto.BancoDTO) 
     */
   @Override
   @Transactional(propagation= Propagation.REQUIRED)
   public Serializable insertBanco(BancoDTO pBanco) throws DataAccessException{
        Banco pojoBanco = copiaDtoPojo( pBanco);
      return this.bancoDao.save( pojoBanco);
    }


    
    /**
     * @see BancoUseCase#getById(mx.com.oitic.deportextil.dto.BancoDTO) 
     */
    @Override
    @Transactional(readOnly=true,propagation= Propagation.REQUIRED)
    public BancoDTO getByIdBanco(BancoDTO pBanco ) throws DataAccessException{
    	return this.bancoDao.getByIdBanco(pBanco ).orElseThrow(() -> new InexistenteException("No existe el banco") );
    }


    /**
     * @see BancoUseCase#deleteBanco(mx.com.oitic.deportextil.dto.BancoDTO) 
     */
   @Override
   @Transactional(propagation= Propagation.REQUIRED)
    public void deleteBanco(BancoDTO pBanco) throws DataAccessException {
        Banco pojoBanco = copiaDtoPojo( pBanco);
        this.bancoDao.deleteById(pojoBanco.getIdBanco());
            
    }
	
    /**
     * @see BancoUseCase#updateBanco(mx.com.oitic.deportextil.dto.BancoDTO) 
     */
   @Override
   @Transactional(propagation= Propagation.REQUIRED)
    public int updateBanco(BancoDTO pBanco) throws DataAccessException{
    	return this.bancoDao.update( pBanco);
    }
	
    
    
    /**
     * @see BancoUseCase#selectByExampleBanco(Optional<String>) 
     */
    @Override
    @Transactional(readOnly=true,propagation= Propagation.REQUIRED)
    public List<BancoDTO> selectByExampleBanco(Optional<String> pCriterio) throws DataAccessException{
         return pCriterio.isPresent() ? this.bancoDao.selectByExample(String.format("%s%s%s", "%", pCriterio.get(),"%")):
          this.bancoDao.selectByExample(null);
    }
              

    /**
     *Copia los datos de un objeto de transferencia de datos a un POJO
     *@param objeto de transferencia de datos de la clase Banco
     *@return POJO de la clase Banco 
     */
          
 private Banco copiaDtoPojo(BancoDTO pBanco){
          Banco pojoBanco = new Banco();
        BeanUtils.copyProperties(pBanco, pojoBanco);
    return pojoBanco;
 }    

            
}
  