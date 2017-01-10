package com.wsw.gankinfo.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by wsw on 2016/12/12.
 */

public class BindingUtils {

    @BindingAdapter({"image"})
    public static void imageLoader(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
