package bp.springbootcassandrabp.controller;

import bp.springbootcassandrabp.model.Film;
import bp.springbootcassandrabp.model.FilmsByAuthor;
import bp.springbootcassandrabp.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    //create este
    @RequestMapping("/create")
    public Film create(@RequestParam String filmName, @RequestParam int price, @RequestParam String releaseDate, @RequestParam String genre,@RequestParam int rating, @RequestParam String authorFirstName, @RequestParam String authorLastName, @RequestParam int age) {
        Film film = filmService.create(filmName, price, releaseDate, genre,rating, authorFirstName, authorLastName, age);
        return film;
    }

    @RequestMapping("/getAll")
    public List<Film> getAll() {
        return filmService.getAll();
    }
    @RequestMapping("/getById")
    public Film getFilmById(@RequestParam UUID id) {
        Film film = filmService.getById(id);
        return film;
    }

    @RequestMapping("/getFilmByName")
    public Film getFilmByName(@RequestParam String name) {
        Film film = filmService.getByName(name);
        return film;
    }
    @RequestMapping("/getFilmReleaseDate")
    public Film getFilmByReleaseDate(@RequestParam String releaseDate) {
        Film film = filmService.getByReleaseDate(releaseDate);
        return film;
    }

    @RequestMapping("/getFilmsByGenre")
    public List<Film> getFilmsByGenre(@RequestParam String genre) {
        List<Film> films = filmService.getFilmsByGenre(genre);
        return films;
    }

    @RequestMapping("/createN")
    public void createN(@RequestParam int n){
        this.filmService.createN(n);
    }

    @RequestMapping("/getFilmsByPrice")
    public List<Film> getFilmsByPrice(@RequestParam int price) {
        List<Film> films = filmService.getByPrice(price);
        return films;
    }
    @GetMapping("/getFilmsByPriceLessThan")
    public List<Film> getFilmsByPriceLessThan(@RequestParam int price) {
        List<Film> films = this.filmService.getByPriceLessThan(price);
        return films;
    }
    @GetMapping("/getFilmsByPriceGreaterThan")
    public List<Film> getFilmsByPriceGreaterThan(@RequestParam int price) {
        List<Film> films = this.filmService.getByPriceGreaterThan(price);
        return films;
    }
    @RequestMapping("/getFilmsByRating")
    public List<Film> getFilmsByRating(@RequestParam int rating) {
        List<Film> films = filmService.getByRating(rating);
        return films;
    }
    @GetMapping("/getFilmsByRatingLessThan")
    public List<Film> getFilmsByRatingLessThan(@RequestParam int rating) {
        List<Film> films = this.filmService.getByRatingLessThan(rating);
        return films;
    }
    @GetMapping("/getFilmsByRatingGreaterThan")
    public List<Film> getFilmsByRatingGreaterThan(@RequestParam int rating) {
        List<Film> films = this.filmService.getByRatingGreaterThan(rating);
        return films;
    }

    @GetMapping("/getFilmsByRatingGreaterThanAndPriceLessThan")
    public List<Film> getFilmsByRatingGreaterThanAndPriceLessThan(@RequestParam int rating,@RequestParam int price) {
        List<Film> films = this.filmService.getByRatingGreaterThanAndPriceLessThan(rating,price);
        return films;
    }

    @GetMapping("/getByAuthorAgeAndGenreAndRatingGreaterThan")
    public List<FilmsByAuthor> getByAgeAndGenreAndRatingGreaterThan(@RequestParam int age,@RequestParam String genre,@RequestParam int rating) {
        List<FilmsByAuthor> films = filmService.getByAgeAndGenreAndRatingGreaterThan(age,genre,rating);
        return films;
    }
    @RequestMapping("/getByAuthorID")
    public FilmsByAuthor getFilmByAuthorID(@RequestParam UUID id) {
        FilmsByAuthor film = filmService.getFilmByAuthorID(id);
        return film;
    }




    @RequestMapping("/updatePrice")
    public void updatePrice(@RequestParam String name, @RequestParam int price) {
        filmService.updatePrice(name, price);
    }
    @RequestMapping("/deleteAll")
    public void deleteAll() {
        filmService.deleteAll();
    }

    @RequestMapping("/deleteByName")
    public void deleteByName(@RequestParam String name) {
        filmService.delete(name);
    }
    @RequestMapping("/deleteById")
    public void deleteById(@RequestParam UUID id) {
        filmService.deleteById(id);
    }

}
