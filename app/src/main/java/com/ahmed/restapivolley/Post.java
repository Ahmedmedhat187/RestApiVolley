package com.ahmed.restapivolley;
import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    int ID;

    @SerializedName("date")
    Date dateCreated;
    String title;
    String author;
    String url;

}