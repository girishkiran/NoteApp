package com.girish.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.activeandroid.query.Update;
import com.example.girish.notes.R;
import com.girish.model.NotesDAO;
import com.girish.notes.BaseActivity;
import com.girish.presenter.NotesViewPresenter;
import com.girish.utils.Constant;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesViewActivity extends BaseActivity<NotesViewPresenter> {

    @BindView(R.id.view_switcher)
    ViewSwitcher viewSwitcher;
    @BindView(R.id.contentTextview)
    TextView contentTextview;
    @BindView(R.id.contentEditTextview)
    EditText contentEditTextview;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    NotesDAO currentNoteDAO = null;
    String currentEditedText = null;
    long currentId = 0;

    NotesViewPresenter notesViewPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);
        ButterKnife.bind(this);
        setToolbar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleView();
            }
        });

        setupData();

    }

    /**
     *
     */
    private void setupData(){
        notesViewPresenter = new NotesViewPresenter();
        currentNoteDAO = (NotesDAO) getIntent().getSerializableExtra(Constant.A_NOTE_DATA);
        currentId = Long.parseLong(getIntent().getStringExtra(Constant.NOTE_ID));
        setTitle(currentNoteDAO.getTitle());
        contentEditTextview.setText(currentNoteDAO.getDescription());
        contentTextview.setText(currentNoteDAO.getDescription());
    }
    /**
     *
     */
    public void toggleView() {
        if(viewSwitcher.getCurrentView().getId() == R.id.contentTextview){
            viewSwitcher.showNext();
            floatingActionButton.setImageResource(android.R.drawable.ic_menu_save);
        }else if(viewSwitcher.getCurrentView().getId() == R.id.contentEditTextview) {
            viewSwitcher.showPrevious();
            floatingActionButton.setImageResource(android.R.drawable.ic_menu_edit);

            // savedata
            currentEditedText = contentEditTextview.getText().toString().trim();

            if(!currentNoteDAO.description.trim().equalsIgnoreCase(currentEditedText)){
                contentTextview.setText(currentEditedText);
                notesViewPresenter.updateData(currentId , currentEditedText);
                finish();
            }

        }

    }


}
