package com.revature.demospringfiltering.beans;

import com.revature.demospringfiltering.entities.Movie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    private MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }


    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getMovies(HttpServletRequest req) {
        String queryString = req.getQueryString();
        String[] pairs = queryString.split("&");
        Map<String, String> queryMap = new HashMap<>();
        for (String str:pairs) {
            String[] pair = str.split("=");
            queryMap.put(pair[0], pair[1]);
        }

        return myService.getFilteredMovies(queryMap);
    }

    @GetMapping("/movies2")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getMovies2(@RequestParam String year) {
        return myService.getMongoFilteredMovies(year);
    }


}
