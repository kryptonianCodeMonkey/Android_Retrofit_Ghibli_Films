package android.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView filmListView;
    LinkedList<String> films = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmListView =  findViewById(R.id.recyclerview);

        getComics();
    }


    private void getComics() {
        Call<List<Title_Results>> call = RetrofitClient.getInstance().getMyApi().getGhibliFilms();
        call.enqueue(new Callback<List<Title_Results>>() {
            @Override
            public void onResponse(Call<List<Title_Results>> call, Response<List<Title_Results>> response) {
                List<Title_Results> myFilmList = response.body();

                for (int i = 0; i < myFilmList.size(); i++) {
                    films.add(myFilmList.get(i).getName());
                }

                filmListView.setAdapter(new filmsListAdapter(getApplicationContext(), films));
                filmListView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Title_Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An Error Has Occurred", Toast.LENGTH_LONG).show();
                Log.d("MainActivity", "Failure to respond: " + t.getMessage());
            }

        });
    }
}