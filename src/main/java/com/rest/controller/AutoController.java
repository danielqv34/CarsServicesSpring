package com.rest.controller;

import com.rest.model.Autos;
import com.rest.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ezequ on 12/3/2016.
 */
@RestController
public class AutoController {


    @Autowired
    private AutoService service;


    /*Agregar auto*/
    @RequestMapping(value = "/auto/nuevo", method = RequestMethod.POST)
    public ResponseEntity<Void> agregarAuto(@RequestBody Autos autos, UriComponentsBuilder builder) throws SQLException {

       try{
           if (service.existeAuto(autos)) {
               return new ResponseEntity<Void>(HttpStatus.CONFLICT);
           } else {
               service.guardarAuto(autos);
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/autos/{id}").buildAndExpand(autos.getId()).toUri());

           }
       }catch (Exception e){
           e.printStackTrace();
           System.out.println(e);
       }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /*Obtener por ID*/
    @RequestMapping(value = "/auto/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autos> obtenerPorId(@PathVariable("id") int id) throws SQLException {
        Autos autos = service.buscarPorId(id);
        if (autos == null){
            System.out.println("No existe este autos");
            return new ResponseEntity<Autos>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Autos>(autos , HttpStatus.OK);
        }
    }

   /*Obtener Lista de Autos*/
   @RequestMapping(value = "/autos",method = RequestMethod.GET)
   public ResponseEntity<List<Autos>> listaDeAutos() throws SQLException {
       List<Autos> listaAutos = service.listaAutos();
       if (listaAutos.isEmpty()){
           System.out.println("No existe Vehiculos");
           return new ResponseEntity<List<Autos>>(listaAutos,HttpStatus.NOT_FOUND);
       }else {
           return new ResponseEntity<List<Autos>>(listaAutos,HttpStatus.OK);
       }
   }

   /*Actualizar Auto*/
   @RequestMapping(value = "/auto/{id}",method = RequestMethod.PUT)
   public ResponseEntity<Autos> actulizarAuto(@PathVariable("id") int id, @RequestBody Autos autos) throws SQLException {

       Autos autosActulizar = service.buscarPorId(id);

       if (autosActulizar == null){
           return new ResponseEntity<Autos>(HttpStatus.NOT_FOUND);
       }else {
           autosActulizar.setMarca(autos.getMarca());
           autosActulizar.setModelo(autos.getModelo());
           autosActulizar.setMatricula(autos.getMatricula());
           autosActulizar.setAnio(autos.getAnio());
           autosActulizar.setColor(autos.getColor());
           autosActulizar.setCombustible(autos.getCombustible());

           service.actualizarAuto(autosActulizar);
           return new ResponseEntity<Autos>(autosActulizar,HttpStatus.OK);
       }
   }

   /*Borrar Auto*/
   @RequestMapping(value = "/auto/{id}",method = RequestMethod.DELETE)
   public ResponseEntity<Autos> borrarAuto(@PathVariable("id") int id) throws SQLException {
       Autos autos = service.buscarPorId(id);
       if (autos == null){
           System.out.println("auto no encontrado");
           return new ResponseEntity<Autos>(HttpStatus.NOT_FOUND);
       }else {
           service.borrarAuto(id);
           return new ResponseEntity<Autos>(autos,HttpStatus.OK);
       }
   }

   /*Borrar Todos*/
   @RequestMapping(value = "/autos/borrarTodos",method = RequestMethod.DELETE)
   public ResponseEntity<Autos> borrarTodos() throws SQLException {
       service.borrarTodos();
       return new ResponseEntity<Autos>(HttpStatus.NO_CONTENT);
   }


    /*Setter del servicio*/
    public void setService(AutoService service) {
        this.service = service;
    }
}
