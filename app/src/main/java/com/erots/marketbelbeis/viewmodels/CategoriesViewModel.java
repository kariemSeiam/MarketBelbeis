package com.erots.marketbelbeis.viewmodels;

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
        models.add(new CatGridModel("قسم الملابس", R.drawable.ic_electronics, R.drawable.bac_cat_0));
        models.add(new CatGridModel("قسم الادوات المنزليه", R.drawable.ic_kitchen, R.drawable.bac_cat_2));
        models.add(new CatGridModel("قسم الاطفال", R.drawable.ic_fashion, R.drawable.bac_cat_1));
        models.add(new CatGridModel("قسم رضوي الشربيني", R.drawable.ic_televisions, R.drawable.bac_cat_4));
        models.add(new CatGridModel("قسم العربيات", R.drawable.ic_maternity, R.drawable.bac_cat_2));
        models.add(new CatGridModel("قسم التلفونات والتابلتات", R.drawable.ic_mechanic_tools, R.drawable.bac_cat_3));
        models.add(new CatGridModel("قسم التابلتات و التلفونات", R.drawable.ic_mobile_table, R.drawable.bac_cat_0));
        models.add(new CatGridModel("قسم الانسان", R.drawable.ic_televisions, R.drawable.bac_cat_4));
        models.add(new CatGridModel("قسم الالعاب تاني", R.drawable.ic_washing_machine, R.drawable.bac_cat_1));
        models.add(new CatGridModel("قسمك", R.drawable.ic_stationery, R.drawable.bac_cat_5));
        models.add(new CatGridModel("قسم الانسان", R.drawable.ic_stationery, R.drawable.bac_cat_2));
        return models;
    }

    public void addCategoriesToMutableLiveData() {
        listMutableLiveData.setValue(addCategoriesToArrayList());
    }

}