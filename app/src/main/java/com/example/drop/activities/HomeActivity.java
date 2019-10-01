package com.example.drop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.drop.fragment.BookFragment;
import com.example.drop.fragment.ChatFragment;
import com.example.drop.fragment.HomeFragment;
import com.example.drop.R;
import com.example.drop.fragment.WorldFragment;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;

    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        replaceFragment(new WorldFragment());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout) ;
        navView = findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent = new Intent(HomeActivity.this, PlayAudioTest.class);
                startActivity(intent);
                return true;
            }
        });


        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                replaceFragment(new WorldFragment());
                break;
            case R.id.button_2:
                replaceFragment(new ChatFragment());
                break;
            case R.id.button_3:
                replaceFragment(new BookFragment());
                break;
            case R.id.button_4:
                replaceFragment(new HomeFragment());
                break;
            default:
                break;
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.center_fragment,fragment);
        transaction.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    //toolbar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                break;
            case R.id.backup:
                Toast.makeText(this,"you",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"you",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"you",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
        return true;
    }
}