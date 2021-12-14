package android.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView filmListView;
    LinkedList<String> titles = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmListView =  findViewById(R.id.recyclerview);

        getFilms();
    }


    private void getFilms() {
        Call<List<Detailed_Results>> call = RetrofitClient.getInstance().getMyApi().getFilmDetails();
        call.enqueue(new Callback<List<Detailed_Results>>() {
            @Override
            public void onResponse(Call<List<Detailed_Results>> call, Response<List<Detailed_Results>> response) {
                List<Detailed_Results> myFilmList = response.body();

                for (int i = 0; i < myFilmList.size(); i++) {
                    titles.add(myFilmList.get(i).getDetails()[0]);
                }

                filmListView.setAdapter(new filmsListAdapter(getApplicationContext(), titles));
                filmListView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                filmListView.addOnItemTouchListener(new CustomRVOnItemTouchListener(MainActivity.this, filmListView, new RecyclerViewItemClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                        intent.putExtra("title", myFilmList.get(position).getDetails()[0]);
                        intent.putExtra("japanese_title", myFilmList.get(position).getDetails()[1]);
                        intent.putExtra("kanji_title", myFilmList.get(position).getDetails()[2]);
                        intent.putExtra("image_url", myFilmList.get(position).getDetails()[3]);
                        intent.putExtra("description", myFilmList.get(position).getDetails()[4]);
                        intent.putExtra("director", myFilmList.get(position).getDetails()[5]);
                        intent.putExtra("release_date", myFilmList.get(position).getDetails()[6]);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                    }
                }));
            }

            @Override
            public void onFailure(Call<List<Detailed_Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An Error Has Occurred", Toast.LENGTH_LONG).show();
                Log.d("MainActivity", "Failure to respond: " + t.getMessage());
            }

        });
    }
}