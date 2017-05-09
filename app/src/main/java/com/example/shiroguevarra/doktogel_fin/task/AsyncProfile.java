package com.example.shiroguevarra.doktogel_fin.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * Created by shiro.guevarra on 5/8/2017.
 */

public class AsyncProfile extends AsyncTask<Void, Void, Void> {

    private Context context;
    private ImageView ivProfilePicture;

    public AsyncProfile(Context _context, ImageView _ivProfilePicture) {
        this.context = _context;
        this.ivProfilePicture = _ivProfilePicture;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Picasso.with(this.context).load("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn2/t1.0-1/s200x200/1472865_191408954385576_14109897_n.jpg").into(ivProfilePicture);
        //Glide.with(this.context)
               // .load("http://myrmecos.net/wp-content/uploads/2010/07/formica.jpg")
                //.into(ivProfilePicture);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
       // Glide.with(this.context)
              //  .load("http://myrmecos.net/wp-content/uploads/2010/07/formica.jpg")
              //  .into(ivProfilePicture);
    }

    @Override
    protected Void doInBackground(Void... params) {

        return null;
    }
}
