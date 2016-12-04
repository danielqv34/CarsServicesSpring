package com.rest.services;

import com.rest.model.Autos;
import com.rest.repositories.AutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ezequ on 12/3/2016.
 */
//
@Service("autoService")
@Transactional
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepo autoRepo;

    @Override
    public Autos buscarPorId(int id) throws SQLException {
        return autoRepo.buscarPorId(id);
    }

    @Override
    public Autos buscarPorMarca(String matricula) throws SQLException {
        return autoRepo.buscarPorMatricula(matricula);
    }

    @Override
    public void guardarAuto(Autos autos) throws SQLException {
       autoRepo.guardarAuto(autos);
    }

    @Override
    public void actualizarAuto(Autos autos) throws SQLException {
      autoRepo.actualizarAuto(autos);
    }

    @Override
    public void borrarAuto(int id) throws SQLException {
        autoRepo.borrarAuto(id);
    }

    @Override
    public List<Autos> listaAutos() throws SQLException {
        return autoRepo.listaAutos();
    }

    @Override
    public void borrarTodos() throws SQLException {
     autoRepo.borrarTodos();
    }

    @Override
    public boolean existeAuto(Autos autos) throws SQLException {
        return autoRepo.existeAuto(autos);
    }
}
