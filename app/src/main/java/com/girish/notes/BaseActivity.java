package com.girish.notes;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.girish.notes.R;

import butterknife.ButterKnife;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

public class BaseActivity<P extends Presenter> extends NucleusAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    /**
     *
     */
    public void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    /**
     *
     */
    public void addStatusBarColor(){
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public void showToast(int resId){
        Toast.makeText(this , resId , Toast.LENGTH_LONG).show();
    }
}
