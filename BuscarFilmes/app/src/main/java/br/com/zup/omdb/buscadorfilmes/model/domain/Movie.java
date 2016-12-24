package br.com.zup.omdb.buscadorfilmes.model.domain;



import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1930564835504057515L;

    @DatabaseField(generatedId = true,columnName="id")
    private int id;
    @DatabaseField(columnName = "title")
    private String Title;
//    @DatabaseField(columnName = "year")
//    private String Year;
//    @DatabaseField(columnName = "rated")
//    private String Rated;
//    @DatabaseField(columnName = "released")
//    private String Released;
//    @DatabaseField(columnName = "runtime")
//    private String Runtime;
//    @DatabaseField(columnName = "genre")
//    private String Genre;
//    @DatabaseField(columnName = "director")
//    private String Director;
//    @DatabaseField(columnName = "writer")
//    private String Writer;
//    @DatabaseField(columnName = "actors")
//    private String Actors;
//    @DatabaseField(columnName = "plot")
//    private String Plot;
//    @DatabaseField(columnName = "language")
//    private String Language;
//    @DatabaseField(columnName = "country")
//    private String Country;
//    @DatabaseField(columnName = "awards")
//    private String Awards;
//    @DatabaseField(columnName = "poster")
//    private String Poster;
//    @DatabaseField(columnName = "metascore")
//    private String Metascore;
//    @DatabaseField(columnName = "imdbRating")
//    private String imdbRating;
//    @DatabaseField(columnName = "imdbVotes")
//    private String imdbVotes;
//    @DatabaseField(columnName = "imdbID")
//    private String imdbID;
//    @DatabaseField(columnName = "type")
//    private String Type;


    private String Response;

    public Movie(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

//    public String getYear() {
//        return Year;
//    }
//
//    public void setYear(String year) {
//        Year = year;
//    }
//
//    public String getRated() {
//        return Rated;
//    }
//
//    public void setRated(String rated) {
//        Rated = rated;
//    }
//
//    public String getReleased() {
//        return Released;
//    }
//
//    public void setReleased(String released) {
//        Released = released;
//    }
//
//    public String getRuntime() {
//        return Runtime;
//    }
//
//    public void setRuntime(String runtime) {
//        Runtime = runtime;
//    }
//
//    public String getGenre() {
//        return Genre;
//    }
//
//    public void setGenre(String genre) {
//        Genre = genre;
//    }
//
//    public String getDirector() {
//        return Director;
//    }
//
//    public void setDirector(String director) {
//        Director = director;
//    }
//
//    public String getWriter() {
//        return Writer;
//    }
//
//    public void setWriter(String writer) {
//        Writer = writer;
//    }
//
//    public String getActors() {
//        return Actors;
//    }
//
//    public void setActors(String actors) {
//        Actors = actors;
//    }
//
//    public String getPlot() {
//        return Plot;
//    }
//
//    public void setPlot(String plot) {
//        Plot = plot;
//    }
//
//    public String getLanguage() {
//        return Language;
//    }
//
//    public void setLanguage(String language) {
//        Language = language;
//    }
//
//    public String getCountry() {
//        return Country;
//    }
//
//    public void setCountry(String country) {
//        Country = country;
//    }
//
//    public String getAwards() {
//        return Awards;
//    }
//
//    public void setAwards(String awards) {
//        Awards = awards;
//    }
//
//    public String getPoster() {
//        return Poster;
//    }
//
//    public void setPoster(String poster) {
//        Poster = poster;
//    }
//
//    public String getMetascore() {
//        return Metascore;
//    }
//
//    public void setMetascore(String metascore) {
//        Metascore = metascore;
//    }
//
//    public String getImdbRating() {
//        return imdbRating;
//    }
//
//    public void setImdbRating(String imdbRating) {
//        this.imdbRating = imdbRating;
//    }
//
//    public String getImdbVotes() {
//        return imdbVotes;
//    }
//
//    public void setImdbVotes(String imdbVotes) {
//        this.imdbVotes = imdbVotes;
//    }
//
//    public String getImdbID() {
//        return imdbID;
//    }
//
//    public void setImdbID(String imdbID) {
//        this.imdbID = imdbID;
//    }
//
//    public String getType() {
//        return Type;
//    }
//
//    public void setType(String type) {
//        Type = type;
//    }


    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getId() != movie.getId()) return false;
        if (!getTitle().equals(movie.getTitle())) return false;
        return getResponse() != null ? getResponse().equals(movie.getResponse()) : movie.getResponse() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + (getResponse() != null ? getResponse().hashCode() : 0);
        return result;
    }
}
