package com.revature.demospringfiltering.beans;

import com.revature.demospringfiltering.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Movie> getMongoFilteredMovies(String year) {
        return this.myRepository.findMoviesByYear(year);
    }

    public List<Movie> getFilteredMovies(Map<String, String> queryMap) {
        List<Movie> resultsList = myRepository.findAll();

        /*
        Finally, this is the part we're here for!
        filteriing by: genre, year, runtime, title
         */
        List<Movie> temp1 = new LinkedList<>();
        if(queryMap.containsKey("year")) {
            for (Movie movie:resultsList) {
                if(movie.getYear().equals(queryMap.get("year"))) {
                    temp1.add(movie);
                }
            }
        } else {
            temp1 = resultsList;
        }

        List<Movie> temp2 = new LinkedList<>();
        if(queryMap.containsKey("runtime")) {
            for (Movie movie:temp1) {
                if(movie.getRuntime().equals(queryMap.get("runtime"))) {
                    temp2.add(movie);
                }
            }
        } else {
            temp2 = temp1;
        }

        List<Movie> temp3 = new LinkedList<>();
        if(queryMap.containsKey("title")) {
            for (Movie movie:temp2) {
                if(movie.getTitle().equals(queryMap.get("title"))) {
                    temp3.add(movie);
                }
            }
        } else {
            temp3 = temp2;
        }

        List<Movie> temp4 = new LinkedList<>();
        if(queryMap.containsKey("genre")) {
            for (Movie movie:temp3) {
                for(String genre:movie.getGenre()) {
                    if(genre.equals(queryMap.get("genre"))) {
                        temp4.add(movie);
                    }
                }
            }
        } else {
            temp4 = temp3;
        }

        return temp4;

    }


}


