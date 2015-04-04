package com.matrimony.picassotest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by syscon on 4/4/15.
 */
public class CustomImageView extends ImageView implements Target {


    public CustomImageView(Context context) {
        super(context);
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

        Log.v("ON BITMAP LOADED", "ON BITMAP LOADED");
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {

        Log.v("ON BITMAP FAILED", "ON BITMAP FAILED");
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

        Log.v("ON PREPARE LOAD","ON PREPARE LOAD");

    }
}
