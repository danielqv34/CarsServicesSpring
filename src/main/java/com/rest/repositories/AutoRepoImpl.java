package com.rest.repositories;

import com.rest.dto.SessionFactoryHandler;
import com.rest.model.Autos;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ezequ on 12/3/2016.
 */
@Repository("autoRepo")
@Transactional
public class AutoRepoImpl extends SessionFactoryHandler implements AutoRepo {

    @Override
    public Autos buscarPorId(int id) throws SQLException {
        Autos autos = new Autos();
        try {
            autos = (Autos) getSession().get(Autos.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return autos;
    }

    @Override
    public Autos buscarPorMatricula(String matricula) throws SQLException {

        Autos autos = new Autos();
        try {
            autos = (Autos) getSession()
                    .createQuery("from Autos where matricula = ?")
                    .setParameter(0, matricula)
                    .uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return autos;

    }

    @Override
    public void guardarAuto(Autos autos) throws SQLException {
        if (autos != null) {
            try {
                guardarEnBD(autos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actualizarAuto(Autos autos) throws SQLException {
        if (autos != null) {
            try {
                actulizarObjeto(autos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void borrarAuto(int id) throws SQLException {
        if (id != 0) {
            Autos auto = new Autos();
            try {
                auto = (Autos) getSession().get(Autos.class, id);
                borrarObjeto(auto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Autos> listaAutos() throws SQLException {
        return getSession().createQuery("from Autos ").list();
    }

    @Override
    public void borrarTodos() {
        try {
            getSession().createQuery("delete from Autos ").executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existeAuto(Autos autos) throws SQLException {
        return buscarPorMatricula(autos.getMatricula()) != null;
    }
}
