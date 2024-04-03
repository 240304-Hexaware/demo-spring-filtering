package com.revature.demospringfiltering.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Arrays;
import java.util.Objects;

@Document("movies")
public class Movie {

    @MongoId(FieldType.OBJECT_ID)
    @Field(name = "_id")
    private ObjectId id;

    @Field("title")
    private String title;

    @Field("genre")
    private String[] genre;

    @Field("runtime")
    private String runtime;

    @Field("plot")
    private String plot;

    @Field("year")
    private String year;

    public Movie() {
    }

    public Movie(String title, String[] genre, String runtime, String plot, String year) {
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
        this.plot = plot;
        this.year = year;
    }

    public Movie(ObjectId id, String title, String[] genre, String runtime, String plot, String year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
        this.plot = plot;
        this.year = year;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Arrays.equals(genre, movie.genre) && Objects.equals(runtime, movie.runtime) && Objects.equals(plot, movie.plot) && Objects.equals(year, movie.year);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, runtime, plot, year);
        result = 31 * result + Arrays.hashCode(genre);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("Movie{")
                .append("id=")
                .append(id)
                .append(", title='")
                .append(title)
                .append('\'')
                .append(", genre=")
                .append(Arrays.toString(genre))
                .append(", runtime=")
                .append(runtime)
                .append(", plot='")
                .append(plot)
                .append('\'')
                .append(", year=")
                .append(year)
                .append('}')
                .toString();
    }
}
