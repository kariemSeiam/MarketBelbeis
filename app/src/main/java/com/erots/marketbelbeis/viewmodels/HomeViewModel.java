package com.erots.marketbelbeis.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.ui.main.home.home_cat_bar.HomeBarCatsModel;
import com.erots.marketbelbeis.ui.main.home.test_frag.HotAdModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    

    private final List<HotAdModel> modelList = new ArrayList<>();
    private final List<HomeBarCatsModel> modelListCats = new ArrayList<>();

    public MutableLiveData<List<HotAdModel>> modelLiveData = new MutableLiveData<>();
    public MutableLiveData<List<HomeBarCatsModel>> modelLiveDataCats = new MutableLiveData<>();

    public void addItems() {
        modelList.clear();
        modelList.add(new HotAdModel("50ج", "ساعه Hand امريكيه", "ي", "Kataki Store", 1, R.drawable.ad_item_1));
        modelList.add(new HotAdModel("120ج", "محفظه جلد", "ييي", "ال صيام", 2, R.drawable.ad_item_2));
        modelList.add(new HotAdModel("200ج", "خاتم عادي", "ييي", "Unique Store", 3, R.drawable.ad_item_3));
        modelList.add(new HotAdModel("10000ج", "معرفش بس هو كده", "ي", "الزعيم", 4, R.drawable.ad_item_4));
        modelList.add(new HotAdModel("100ج", "تمام", "ي", "Data", 5, R.drawable.ad_item_5));
        modelList.add(new HotAdModel("125ج", "ههه", "ي", "Kataki Store", 6, R.drawable.ad_item_6));
        modelLiveData.setValue(modelList);
    }


    public void addCatsItems() {
        modelListCats.clear();
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_electronics, "الكترونيات"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_kitchen, "المطبخ"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_televisions, "تلفزيونات"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_favorite, "ملابس"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_electronics, "الكترونيات"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_kitchen, "المطبخ"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_televisions, "تلفزيونات"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_favorite, "ملابس"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_electronics, "الكترونيات"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_kitchen, "المطبخ"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_televisions, "تلفزيونات"));
        modelListCats.add(new HomeBarCatsModel(R.drawable.ic_favorite, "ملابس"));
        modelLiveDataCats.setValue(modelListCats);

    }
}