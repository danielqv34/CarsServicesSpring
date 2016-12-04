package com.rest.services;

import com.rest.model.Autos;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ezequ on 12/3/2016.
 */

public interface AutoService {

    Autos buscarPorId(int id) throws SQLException;

    Autos buscarPorMarca(String marca) throws SQLException;

    void guardarAuto(Autos autos) throws SQLException;

    void actualizarAuto(Autos autos) throws SQLException;

    void borrarAuto(int id) throws SQLException;

    List<Autos> listaAutos() throws SQLException;

    void borrarTodos() throws SQLException;

    boolean existeAuto(Autos autos) throws SQLException;
}
