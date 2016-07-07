package com.girish.presenter;

import android.content.Context;

import com.activeandroid.query.Select;
import com.example.girish.notes.R;
import com.girish.activity.NotesActivity;
import com.girish.model.NotesDAO;

import java.util.ArrayList;
import java.util.List;

import nucleus.presenter.RxPresenter;

public class NotesPresenter extends RxPresenter<NotesActivity> {

    private NotesActivity context;

    @Override
    protected void onTakeView(NotesActivity notesActivity) {
        super.onTakeView(notesActivity);
        context = notesActivity;
    }

    /**
     *
     * @return
     */
    public List<NotesDAO> getNotesData(){
        return new Select().from(NotesDAO.class).orderBy("Id ASC").execute();
    }


}
