package com.girish.activity;

import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.girish.notes.R;
import com.girish.model.NotesDAO;
import com.girish.notes.BaseActivity;
import com.girish.presenter.AddNotesPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNotesActivity extends BaseActivity<AddNotesPresenter> {

    @BindView(R.id.title)
    EditText title = null;
    @BindView(R.id.description)
    EditText description = null;
    AddNotesPresenter addNotesPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        ButterKnife.bind(this);
        setToolbar();
        addStatusBarColor();
        setupData();

        setTitle("Add Notes");
    }

    /**
     *
     */
    private void setupData(){
        addNotesPresenter = new AddNotesPresenter();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }


    /**
     *
     */
    public void saveData(){
        String title = this.title.getText().toString();
        String description = this.description.getText().toString();

        if(TextUtils.isEmpty(title.trim())){
            this.title.setError(getResources().getString(R.string.error_title));
        }else {
            addNotesPresenter.saveData(title , description);
            showToast(R.string.store_success);
            finish();
        }
    }
}
