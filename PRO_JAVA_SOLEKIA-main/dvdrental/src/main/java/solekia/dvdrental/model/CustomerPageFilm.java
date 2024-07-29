package solekia.dvdrental.model;

import java.util.List;

import solekia.dvdrental.entities.CustomerFilm;

public class CustomerPageFilm {
    public int film_id;
    public String title;
    public String description;
    public Double replacement_cost;
    public String tmdb_poster_path;
    public String tmdb_backdrop_path;
    public List<CustomerFilm> list;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(Double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getTmdb_poster_path() {
        return tmdb_poster_path;
    }

    public void setTmdb_poster_path(String tmdb_poster_path) {
        this.tmdb_poster_path = tmdb_poster_path;
    }

    public String getTmdb_backdrop_path() {
        return tmdb_backdrop_path;
    }

    public void setTmdb_backdrop_path(String tmdb_backdrop_path) {
        this.tmdb_backdrop_path = tmdb_backdrop_path;
    }
}
