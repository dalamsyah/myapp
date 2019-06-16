package com.stupid.dalamsyah.activity.anggit;

import com.google.gson.annotations.SerializedName;

public class Quotes {

    @SerializedName("id")
    public String id;

    @SerializedName("author")
    public String author;

    @SerializedName("quotes")
    public String quotes;

    public Quotes() {
    }

    public Quotes(String id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quotes = quote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quotes;
    }

    public void setQuote(String quote) {
        this.quotes = quote;
    }
}
