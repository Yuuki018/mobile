package com.example.shiroguevarra.doktogel_fin;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.shiroguevarra.doktogel_fin.task.AsyncProfile;
import com.example.shiroguevarra.doktogel_fin.util.SessionManager;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CallbackManager callbackManager;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.sessionManager = new SessionManager(getApplicationContext());
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        this.callbackManager = CallbackManager.Factory.create();
        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String fbId = loginResult.getAccessToken().getUserId().toString();
                sessionManager.set("fbId", fbId);
                //com.facebook.login.widget.ProfilePictureView profilePictureView = (com.facebook.login.widget.ProfilePictureView)
                        //findViewById(R.id.image);

               // profilePictureView.setProfileId(fbId);
                // loginButton.setVisibility(View.GONE);
                ImageView ivProfilePicture = (ImageView) findViewById(R.id.profile_image);
                new AsyncProfile(getApplicationContext(), ivProfilePicture).execute();
                /*Glide.with(getApplicationContext())
                        .load("https://graph.facebook.com/292661114516908/picture?type=medium&width=200&height=200")
                        .into(ivProfilePicture);*/
                Log.e("FB", "USER : " + fbId);
            }

            @Override
            public void onCancel() {
                sessionManager.set("fbId", null);
                Log.e("FB", "Trigger : onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                sessionManager.set("fbId", null);
                Log.e("FB", "Trigger : onError");
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.GifImage);
        Glide.with(this).load("http://192.169.203.131/images/ads/ligajudi-v4.gif").into(imageView);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.prediksi_togel) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.hasil_togel_sebelumnya) {
            Intent intent = new Intent(getApplicationContext(), HasilTogelSebelumnyaActivity.class);
            startActivity(intent);
        } else if (id == R.id.tafsir_mimpi) {
            Intent intent = new Intent(getApplicationContext(), TafsirMimpiActivity.class);
            startActivity(intent);
        } else if (id == R.id.panduan_togel) {
            Intent intent = new Intent(getApplicationContext(), PanduanTogelActivity.class);
            startActivity(intent);
        } else if (id == R.id.shio_togel) {
            Intent intent = new Intent(getApplicationContext(), ShioTogelActivity.class);
            startActivity(intent);
        } else if (id == R.id.neptu_hari) {
            Intent intent = new Intent(getApplicationContext(), NeptuHariActivity.class);
            startActivity(intent);
        } else if (id == R.id.data_tasyen) {
            Intent intent = new Intent(getApplicationContext(), DataTasyenActivity.class);
            startActivity(intent);
        } else if (id == R.id.tentang_kami) {
            Intent intent = new Intent(getApplicationContext(), TentangKamiActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


