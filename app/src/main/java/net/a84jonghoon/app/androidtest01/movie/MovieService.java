package net.a84jonghoon.app.androidtest01.movie;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public interface MovieService {

    public void add(MovieDTO param);
    public int count();
    public MovieDTO findOne();
    public ArrayList<MovieDTO> findBy(MovieDTO param);
    public ArrayList<MovieDTO> list();
    public void update(MovieDTO param);
    public void delete(MovieDTO param);
}
