package com.rest.repositories;

import com.rest.model.Autos;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ezequ on 12/3/2016.
 */
public interface AutoRepo {

    Autos buscarPorId(int id) throws SQLException;

    Autos buscarPorMatricula(String matricula) throws SQLException;

    void guardarAuto(Autos autos) throws SQLException;

    void actualizarAuto(Autos autos) throws SQLException;

    void borrarAuto(int id) throws SQLException;

    List<Autos> listaAutos() throws SQLException;

    void borrarTodos() throws SQLException;

    boolean existeAuto(Autos autos) throws SQLException;
}
