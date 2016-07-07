package com.girish.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.girish.notes.R;
import com.girish.activity.AddNotesActivity;
import com.girish.model.NotesDAO;

import nucleus.presenter.RxPresenter;

/**
 * Created by girish on 06/07/16.
 */

public class AddNotesPresenter extends RxPresenter<AddNotesActivity> {

    private AddNotesActivity addNotesActivity;

    @Override
    protected void onTakeView(AddNotesActivity addNotesActivity) {
        super.onTakeView(addNotesActivity);
        this.addNotesActivity = addNotesActivity;
    }

    /**
     *
     */
    public void saveData(String title , String description){
        NotesDAO notesDAO = new NotesDAO();
        notesDAO.title = title;
        notesDAO.description = description;
        notesDAO.save();
    }
}
