package com.mohsenafana.mtit.Data;

import android.content.Context;
import android.content.res.TypedArray;

import androidx.appcompat.content.res.AppCompatResources;

import com.mohsenafana.mtit.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static Random r = new Random();



    public static List<ServicesCategory> getServiceCategory(Context ctx) {
        List<ServicesCategory> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.services_category_icon);
        TypedArray drw_arr_bg = ctx.getResources().obtainTypedArray(R.array.shop_category_bg);
        String[] title_arr = ctx.getResources().getStringArray(R.array.Services_category_title);
        String[] brief_arr = ctx.getResources().getStringArray(R.array.shop_category_brief);
        for (int i = 0; i < drw_arr.length(); i++) {
            ServicesCategory obj = new ServicesCategory();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.image_bg = drw_arr_bg.getResourceId(i, -1);
            obj.title = title_arr[i];
            obj.brief = brief_arr[i];
            obj.imageDrw = AppCompatResources.getDrawable(ctx, obj.image);
            items.add(obj);
        }
        return items;
    }

}
