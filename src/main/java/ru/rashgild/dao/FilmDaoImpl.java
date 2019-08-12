package ru.rashgild.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import ru.rashgild.model.Film;

@Repository("FilmDao")
public class FilmDaoImpl extends AbstractDao implements FilmDao {

    @Override
    public List<Film> getList(){
        Criteria criteria = getSession().createCriteria(Film.class);
        return (List<Film>) criteria.list();
    }
}
