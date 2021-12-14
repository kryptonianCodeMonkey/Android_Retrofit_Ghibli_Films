package android.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class Detailed_Results {

    @SerializedName("title")
    private String filmName;

    @SerializedName("original_title")
    private String kanjiTitle;

    @SerializedName("original_title_romanised")
    private String japaneseTitle;

    @SerializedName("image")
    private String imageURL;

    @SerializedName("description")
    private String description;

    @SerializedName("director")
    private String director;

    @SerializedName("release_date")
    private String release_date;


    public Detailed_Results(String filmName, String kanjiTitle,
                       String japaneseTitle, String imageURL,
                       String description, String director, String release_date) {
        this.filmName = filmName;
        this.kanjiTitle = kanjiTitle;
        this.japaneseTitle = japaneseTitle;
        this.imageURL = imageURL;
        this.description = description;
        this.director = director;
        this.release_date = release_date;
    }

    public String[] getDetails() {
        String all[] = {filmName, japaneseTitle, kanjiTitle, imageURL, description, director, release_date};
        return all;
    }
}
