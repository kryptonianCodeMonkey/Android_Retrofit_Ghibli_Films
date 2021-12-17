package android.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://ghibliapi.herokuapp.com";
    @GET("films")
    Call<List<Title_Results>> getFilms();
    @GET("films")
    Call<List<Detailed_Results>> getFilmDetails(@Query("title") String filmName);
}
