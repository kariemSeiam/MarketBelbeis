package com.erots.marketbelbeis.ui.main.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.ui.main.home.hot_ad.HotAdModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private final List<HotAdModel> modelList = new ArrayList<>();
    public MutableLiveData<List<HotAdModel>> modelLiveData = new MutableLiveData<>();

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


}