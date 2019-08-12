package ru.rashgild.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.rashgild.dao.FilmDao;
import ru.rashgild.model.Film;

@Component
public class MainController extends AbstractController implements Controller {
    @Autowired
    private FilmDao filmDao;

    public void initialize() {
        List<Film> filmList = filmDao.getList();
        System.out.println(filmList);
    }
}

