package android.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class Title_Results {

    @SerializedName("title")
    private String filmName;


    public Title_Results(String title) {
        this.filmName = title;
    }

    public String getTitle() {
        return filmName;
    }
}
