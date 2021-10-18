package com.example.NotflixServer.services;

import com.example.NotflixServer.models.Movie;
import com.example.NotflixServer.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        List<Movie> movies = (List<Movie>)this.movieRepository.findAll();

        if (movies.size() == 0) {
            this.movieRepository.save(new Movie("herRuccntNE",
                    "Inception",
                    "science fiction",
                    5,
                    "Your mind is the scene of the crime. Box-office superstar Leonardo DiCaprio stars in this contemporary science fiction action film set within the architecture of the mind. Written, directed and produced by Oscar® and Golden Globe nominee Christopher Nolan (The Dark Knight Trilogy, Interstellar, The Prestige), this eagerly awaited follow-up to 2008's billion-dollar blockbuster is yet another visionary tale from a startingly original filmmaker who continually raises the bar with every film he makes. Shooting in London, Paris, Tangiers, Calgary and Los Angeles, Nolan's mind-bending film also stars Academy Award® winners Michael Caine and Marion Cotillard, in addition to Juno's Elliot Page, Batman Begins' Cillian Murphy and Oscar® nominees Ken Watanabe (The Last Samurai) and Tom Berenger (Platoon)."
            ));
            this.movieRepository.save(new Movie("NyRD_8HKRMY",
                    "The Revenant",
                    "action",
                    4,
                    "Leonardo DiCaprio stars in this critically acclaimed epic adventure inspired by true events from writer-director Alejandro G. . While on a hunting expedition in the American wilderness, Hugh Glass (DiCaprio) is attacked by a bear and left for dead. Despite unimaginable grief and betrayal by his confidant (Tom Hardy), Glass must navigate a vicious winter in a relentless pursuit to live."
            ));
            this.movieRepository.save(new Movie("hvAL_RMwWfE",
                    "Saving Private Ryan",
                    "action",
                    3,
                    "Based on a World War II drama. US soldiers try to save their comrade, paratrooper Private Ryan, who's stationed behind enemy lines."
            ));
            this.movieRepository.save(new Movie("8Pf8BkFLBRw",
                    "The Godfather",
                    "drama",
                    5,
                    "Director Coppola paints a chilling portrait of the Sicilian clan's rise and near fall from power in America, masterfully balancing the story between the Corleone's family life and the ugly crime business in which they are engaged."
            ));
            this.movieRepository.save(new Movie("hf_lCA-T99c",
                    "Forrest Gump",
                    "comedy",
                    4,
                    "Stupid is as stupid does, says Forrest Gump (played by Tom Hanks in an Oscar-winning performance) as he discusses his relative level of intelligence with a stranger while waiting for a bus."
            ));
            this.movieRepository.save(new Movie("3rd1L6vMcsM",
                    "Finding Nemo",
                    "animation",
                    3,
                    "Duik mee in Finding Nemo, een hilarisch avontuur vol kleurrijke figuren, dat je meeneemt naar de adembenemende onderwaterwereld van het Groot Barrièrerif voor de kust van Australië. Als de avontuurlijke, jonge clown vis Nemo gevangen wordt door een duiker, gaat zijn over-beschermende vader Marlin samen met Dory, een lieve maar nogal vergeetachtige doktersvis, op een onvergetelijke zoektocht om Nemo weer thuis te brengen."
            ));
        }
    }

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        if (movie.getId() != "" && movie.getId() != null) {
            if (!movieRepository.existsById(movie.getId())) {
                return movieRepository.save(movie);
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Movie is already exist!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie doesn't have necessary attribute!");
        }
    }

    public Movie updateMovie(Movie movie) {
        if (movie.getId() != "" && movie.getId() != null) {
            if (movieRepository.existsById(movie.getId())) {
                return movieRepository.save(movie);
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Movie Id doesn't match to update!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie is not found!");
        }
    }

    public Optional<Movie> deleteMovieById(String id) {
        if (movieRepository.existsById(id)) {
            Optional<Movie> deletedMovie = movieRepository.findById(id);
            movieRepository.deleteById(id);
            return deletedMovie;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie is not found!");
        }
    }
}
