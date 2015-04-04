package com.matrimony.picassotest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainActivity extends ActionBarActivity {


    ImageView imageView1;
    ImageView imageView2;
    private Target target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //imageView1 = (ImageView)findViewById(R.id.image_view_1);
        imageView2 = (ImageView)findViewById(R.id.image_view_2);

        target = new Target(){

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                Log.v("BITMAP BEFORE",Integer.valueOf(bitmap.getRowBytes()).toString());

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.JPEG,0,outputStream);

                Bitmap decodedMap = BitmapFactory.decodeStream(new ByteArrayInputStream(outputStream.toByteArray()));

                imageView2.setImageBitmap(decodedMap);

                Log.v("BITMAP AFTER",Integer.valueOf(decodedMap.getRowBytes()).toString());

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

                Log.v("ON BITMAP FAILED", "ON BITMAP FAILED");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

                Log.v("ON PREPARE LOAD","ON PREPARE LOAD");
            }
        };

        //Picasso.with(this).load(R.drawable.planet).into(imageView1);
        loadImage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadImage(){

        Picasso.with(getApplicationContext()).load(R.drawable.planet).into(target);
    }
}
