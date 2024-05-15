

package mx.com.oitic.deportextil.rest;

import mx.com.oitic.deportextil.dto.BancoDTO;
import mx.com.oitic.deportextil.usecase.BancoUseCase;

import java.util.List;
import java.util.Optional;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import mx.com.oitic.deportextil.orm.Banco;
import org.thymeleaf.util.StringUtils;

  
  /**
   *
   * Clase BancoRest que atiende las peticiones para llevar a cabo 
   *        las operaciones para la entidad banco
   */
@RestController
@RequestMapping("/banco")
@Tag(name = "Banco", description = "Documentación de Banco API  ")
@Log4j2
public class BancoRest{ 

   @Autowired
   protected BancoUseCase bancoUseCase;

@Operation(summary = "Obtiene un  registro de Banco por identificador primario")
@ApiResponses(value = { 
  @ApiResponse(responseCode = "200", description = "Banco existente", 
    content = { @Content(mediaType = "application/json", 
  
      schema = @Schema(implementation = Banco.class)) }),
  @ApiResponse(responseCode = "400", description = "Identificador de Banco inválido", 
    content = @Content), 
  @ApiResponse(responseCode = "404", description = "Banco no cumple con las validaciones y tipos de datos correspondientes", 
    content = @Content) })
    @GetMapping( value="seleccionaBanco/{pIdBanco}",
     produces = "application/json")
   public ResponseEntity<BancoDTO> seleccionaBanco(@PathVariable("pIdBanco")   Integer  pIdBanco ){
       BancoDTO  pBanco  = new BancoDTO(); 
    
        pBanco.setIdBanco(pIdBanco);
        
        pBanco = this.bancoUseCase.getByIdBanco(pBanco);
        return   ResponseEntity.ok().body(pBanco);
   }

    

@Operation(summary = "Busca Banco que tengan coincidencia con el criterio de busqueda")
@ApiResponses(value = { 
  @ApiResponse(responseCode = "200", description = "Banco correctos", 
    content = { @Content(mediaType = "application/json", 
  
      schema = @Schema(implementation = Banco.class)) }),
  @ApiResponse(responseCode = "400", description = "Error en el proceso de búsqueda", 
    content = @Content), 
  @ApiResponse(responseCode = "404", description = "Banco no cumple con las validaciones y tipos de datos correspondientes", 
    content = @Content) })
   @GetMapping( value="buscaBanco/{pCriterio}", produces = "application/json")
   public ResponseEntity<List<BancoDTO>> buscaBanco(@PathVariable String pCriterio ){
   List<BancoDTO> lstResultado = bancoUseCase.selectByExampleBanco( Optional.ofNullable( StringUtils.isEmpty(pCriterio.trim()) ? null: pCriterio  ));
        return ResponseEntity.ok().body(lstResultado);
   }
    
                 
                      
@Operation(summary = "Inserta un registro Banco ")
@ApiResponses(value = { 
  @ApiResponse(responseCode = "200", description = "Banco insertado correctamente", 
    content = { @Content(mediaType = "application/json", 
  
      schema = @Schema(implementation = Banco.class)) }),
  @ApiResponse(responseCode = "400", description = "Inserción incorrecta inválido", 
    content = @Content), 
  @ApiResponse(responseCode = "404", description = "Banco no cumple con las validaciones y tipos de datos correspondientes", 
    content = @Content) })
    @PostMapping( value="agregaBanco", 
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<BancoDTO> agregaBanco(@Valid @RequestBody BancoDTO pBanco){
        this.bancoUseCase.insertBanco( pBanco );
        return   ResponseEntity.ok(pBanco);
    }

@Operation(summary = "Actualiza un registro Banco ")
@ApiResponses(value = { 
  @ApiResponse(responseCode = "200", description = "Banco actualizado correctamente", 
    content = { @Content(mediaType = "application/json", 
  
      schema = @Schema(implementation = Banco.class)) }),
  @ApiResponse(responseCode = "400", description = "Actualización incorrecta", 
    content = @Content), 
  @ApiResponse(responseCode = "404", description = "Banco no cumple con las validaciones y tipos de datos correspondientes", 
    content = @Content) })
    @PutMapping( value="actualizaBanco/{pIdBanco}",
    consumes = "application/json", produces = "application/json")
    public ResponseEntity<BancoDTO> actualizaBanco( @PathVariable("pIdBanco")  Integer  pIdBanco   
    , @Valid @RequestBody BancoDTO pBanco){
    
        if( pBanco.getIdBanco().equals(pIdBanco) ) {
        this.bancoUseCase.updateBanco( pBanco );
          return ResponseEntity.ok(pBanco);
        }
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
                    
@Operation(summary = "Inactiva un registro Banco ")
@ApiResponses(value = { 
  @ApiResponse(responseCode = "200", description = "Banco desactivado correctamente", 
    content = { @Content(mediaType = "application/json", 
  
      schema = @Schema(implementation = Banco.class)) }),
  @ApiResponse(responseCode = "400", description = "Eliminación incorrecta ", 
    content = @Content), 
  @ApiResponse(responseCode = "404", description = "Banco no cumple con las validaciones y tipos de datos correspondientes", 
    content = @Content) })
    @DeleteMapping( value="eliminaBanco/{pIdBanco}",
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<BancoDTO> eliminaBanco(@PathVariable("pIdBanco")  Integer  pIdBanco   
    ,@RequestBody BancoDTO pBanco){
    if( pBanco.getIdBanco().equals(pIdBanco) ) {
        this.bancoUseCase.deleteBanco( pBanco );
          return ResponseEntity.ok(pBanco);
        }
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
                    
                    
}
  