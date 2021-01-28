package com.erots.marketbelbeis.ui.main.categories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erots.marketbelbeis.R;
import com.erots.marketbelbeis.ui.main.categories.grid.CatGridModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<List<CatGridModel>> listMutableLiveData = new MutableLiveData<>();
    private List<CatGridModel> models;

    List<CatGridModel> addCategoriesToArrayList() {
        models = new ArrayList<>();
        models.add(new CatGridModel("كسم الملابس", R.drawable.ic_electronics, R.drawable.bac_cat_0));
        models.add(new CatGridModel("كسم الادوات المنزليه", R.drawable.ic_kitchen, R.drawable.bac_cat_2));
        models.add(new CatGridModel("كسم الاطفال", R.drawable.ic_fashion, R.drawable.bac_cat_1));
        models.add(new CatGridModel("كسم رضوي الشربيني", R.drawable.ic_televisions, R.drawable.bac_cat_4));
        models.add(new CatGridModel("كسم العربيات", R.drawable.ic_maternity, R.drawable.bac_cat_2));
        models.add(new CatGridModel("كسم التلفونات والتابلتات", R.drawable.ic_mechanic_tools, R.drawable.bac_cat_3));
        models.add(new CatGridModel("كسم التابلتات و التلفونات", R.drawable.ic_mobile_table, R.drawable.bac_cat_0));
        models.add(new CatGridModel("كسم الانسان", R.drawable.ic_televisions, R.drawable.bac_cat_4));
        models.add(new CatGridModel("كسم الالعاب تاني", R.drawable.ic_washing_machine, R.drawable.bac_cat_1));
        models.add(new CatGridModel("كسمك", R.drawable.ic_stationery, R.drawable.bac_cat_5));
        models.add(new CatGridModel("كسم الانسان", R.drawable.ic_stationery, R.drawable.bac_cat_2));
        return models;
    }

    public void addCategoriesToMutableLiveData() {
        listMutableLiveData.setValue(addCategoriesToArrayList());
    }

}