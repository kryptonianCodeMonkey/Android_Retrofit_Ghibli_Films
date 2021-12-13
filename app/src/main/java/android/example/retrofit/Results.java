package android.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("title")
    private String filmName;


    public Results(String name) {
        this.filmName = name;
    }

    public String getName() {
        return filmName;
    }
}
