package com.girish.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.girish.notes.R;
import com.girish.adapters.NotesAdapter;
import com.girish.notes.BaseActivity;
import com.girish.presenter.NotesPresenter;
import com.girish.utils.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesActivity extends BaseActivity<NotesPresenter> {

    @BindView(R.id.recycle_view)
    public RecyclerView recyclerView;

    NotesAdapter notesAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
        setToolbar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this , AddNotesActivity.class));
            }
        });

        setupData();

    }

    /**
     *
     */
    private void setupData(){
        notesAdapter = new NotesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notesAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(null != notesAdapter){
            notesAdapter = new NotesAdapter(this);
            recyclerView.setAdapter(notesAdapter);
        }
    }
}
