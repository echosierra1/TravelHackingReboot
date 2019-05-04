package com.example.travelhacking;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

public class yelpDetails extends AppCompatActivity {

    TextView details;
    TextView url;
    TextView address;
    TextView phone;
    TextView reviews;
    TextView rating;
    ImageView imageView;
    yelpDetails myself;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yelp_details);

        this.details = findViewById(R.id.details);
        this.url = findViewById(R.id.url);
        this.address = findViewById(R.id.address);
        this.phone = findViewById(R.id.phone);
        this.reviews = findViewById(R.id.reviewcount);
        this.imageView = findViewById(R.id.imageView);
        this.rating = findViewById(R.id.rating);

        this.details.setText(Core.selectedeatery.name);
        this.address.setText("Address: " + Core.selectedeatery.address);
        this.phone.setText("Telephone: " + Core.selectedeatery.phone);
        this.url.setText("Website: " + Core.selectedeatery.URL);
        this.reviews.setText("Reviews: " + Core.selectedeatery.reviews);
        this.rating.setText("Rating: " + Core.selectedeatery.rating);
        new DownLoadImageTask(imageView).execute(Core.selectedeatery.picture);






    }



    public void onLaunchButtonClick (View V)
    {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Core.selectedeatery.URL));
        startActivity(browserIntent);
    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){
                System.out.println("***error" + e.toString());
            }
            return logo;
        }

        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }
}
