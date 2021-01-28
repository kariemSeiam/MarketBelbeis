package com.erots.marketbelbeis.ui.main.home.test_frag;

public class HotAdModel {
    String hot_ad_price, hot_ad_title, hot_ad_image_uri, hot_ad_market_name;
    int hot_ad_id;
    int test_image;

    public HotAdModel() {

    }

    public HotAdModel(String hot_ad_price, String hot_ad_title, String hot_ad_image_uri, String hot_ad_market_name, int hot_ad_id, int test_image) {
        this.hot_ad_price = hot_ad_price;
        this.hot_ad_title = hot_ad_title;
        this.hot_ad_image_uri = hot_ad_image_uri;
        this.hot_ad_market_name = hot_ad_market_name;
        this.hot_ad_id = hot_ad_id;
        this.test_image = test_image;
    }

    public int getTest_image() {
        return test_image;
    }

    public void setTest_image(int test_image) {
        this.test_image = test_image;
    }

    public String getHot_ad_market_name() {
        return hot_ad_market_name;
    }

    public void setHot_ad_market_name(String hot_ad_market_name) {
        this.hot_ad_market_name = hot_ad_market_name;
    }

    public String getHot_ad_price() {
        return hot_ad_price;
    }

    public void setHot_ad_price(String hot_ad_price) {
        this.hot_ad_price = hot_ad_price;
    }

    public String getHot_ad_title() {
        return hot_ad_title;
    }

    public void setHot_ad_title(String hot_ad_title) {
        this.hot_ad_title = hot_ad_title;
    }

    public String getHot_ad_image_uri() {
        return hot_ad_image_uri;
    }

    public void setHot_ad_image_uri(String hot_ad_image_uri) {
        this.hot_ad_image_uri = hot_ad_image_uri;
    }

    public int getHot_ad_id() {
        return hot_ad_id;
    }

    public void setHot_ad_id(int hot_ad_id) {
        this.hot_ad_id = hot_ad_id;
    }
}
