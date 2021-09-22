package com.erots.marketbelbeis.ui.main.marketplace;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts_table")
public class PostModel {

    private final int price;
    private final String title;
    private final String market_name;
    @PrimaryKey(autoGenerate = true)
    int id;

    public PostModel(int price, String title, String market_name) {
        this.price = price;
        this.title = title;
        this.market_name = market_name;
    }


    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getMarket_name() {
        return market_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
