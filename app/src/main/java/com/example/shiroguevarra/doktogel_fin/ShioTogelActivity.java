package com.example.shiroguevarra.doktogel_fin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ShioTogelActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shio_togel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Shio Togel");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
