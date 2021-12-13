package android.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://ghibliapi.herokuapp.com";
    @GET("films")
    Call<List<Results>> getGhibliFilms();
}
