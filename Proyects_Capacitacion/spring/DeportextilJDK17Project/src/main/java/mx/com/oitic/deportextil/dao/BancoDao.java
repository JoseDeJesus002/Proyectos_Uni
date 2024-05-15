package mx.com.oitic.deportextil.dao;

import mx.com.oitic.deportextil.orm.Banco;
import mx.com.oitic.deportextil.dto.BancoDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

/**
 *
 * interface BancoDao que especifica el contrato de persistencia y consulta de
 * la clase Banco
 */
interface BancoDao extends JpaRepository<Banco, Integer> {

    /**
     * Este codigo se genero con Arquitecto MVC. Este método selecciona un
     * registro en la clase Banco mediante la llave primaria
     *
     * @param pBanco con los campos que componen la llave primaria
     * @return Registro coincidente de la clase Banco
     */
    @Query("select new mx.com.oitic.deportextil.dto.BancoDTO("
            + " banco.idBanco as idBanco, "
            + " banco.banco as banco "
            + ") from  Banco  as banco "
            + " WHERE "
            + " banco.idBanco = :#{#banco.idBanco}"
            + " "
    )
    Optional<BancoDTO> getById(@Param("banco") BancoDTO pBanco) throws DataAccessException;

    /**
     * Este codigo se genero con Arquitecto MVC. Este método selecciona un
     * registro en la clase Banco que coincidan con el criterio de busqueda
     *
     * @param pCriterio Criterio de busqueda
     * @return Registros coincidentes de la clase Banco
     */
    @Query("select new mx.com.oitic.deportextil.dto.BancoDTO("
            + " banco.idBanco as idBanco, "
            + " banco.banco as banco "
            + ") from  Banco  as banco "
            + " where :#{#criterio} is null or ("
            + " lower( banco.banco) like lower(:#{#criterio})   "
            + " )"
    )
    List<BancoDTO> selectByExample(@Param("criterio") String pCriterio) throws DataAccessException;

    /**
     * Este codigo se genero con Arquitecto MVC. Este método actualiza un
     * registro en la tabla banco mediante la llave primaria
     */
    @Modifying
    @Query(" UPDATE Banco banco  "
            + " SET "
            + " banco.banco = :#{#banco.banco} "
            + " WHERE "
            + " banco.idBanco = :#{#banco.idBanco}"
    )
    int update(@Param("banco") BancoDTO pBanco) throws DataAccessException;

}
