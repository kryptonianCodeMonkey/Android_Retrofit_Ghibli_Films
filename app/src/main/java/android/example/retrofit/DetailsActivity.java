package android.example.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d(TAG, "onCreate() started");

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("title")
                && getIntent().hasExtra("japanese_title")
                && getIntent().hasExtra("kanji_title")
                && getIntent().hasExtra("image_url")
                && getIntent().hasExtra("description")
                && getIntent().hasExtra("director")
                && getIntent().hasExtra("release_date")) {
            String title = getIntent().getStringExtra("title");
            String japanese_title = getIntent().getStringExtra("japanese_title");
            String kanji_title = getIntent().getStringExtra("kanji_title");
            String image_url = getIntent().getStringExtra("image_url");
            String description = getIntent().getStringExtra("description");
            String director = getIntent().getStringExtra("director");
            String release_date = getIntent().getStringExtra("release_date");
            Log.d(TAG, "title: " + title);

            setValues(title, japanese_title, kanji_title, image_url, description, director, release_date);
        } else
            Log.d(TAG, "no Extras");
    }

    private void setValues(String title_txt, String japanese_title_txt, String kanji_title_txt,
                           String image_url_txt, String description_txt, String director_txt,
                           String release_date_txt) {
        TextView title = findViewById(R.id.english_title);
        title.setText(title_txt);
        TextView japanese_title = findViewById(R.id.japanese_title);
        japanese_title.setText(japanese_title_txt);
        TextView kanji_title = findViewById(R.id.kanji);
        kanji_title.setText(kanji_title_txt);
        TextView description = findViewById(R.id.description);
        description.setText(description_txt);
        TextView director = findViewById(R.id.director);
        director.setText(director_txt);
        TextView release_date = findViewById(R.id.release_date);
        release_date.setText(release_date_txt);
        ImageView image = findViewById(R.id.film_image);
        Picasso.get().load(image_url_txt).into(image);
    }
}
