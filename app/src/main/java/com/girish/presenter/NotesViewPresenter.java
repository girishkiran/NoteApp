package com.girish.presenter;

import com.girish.activity.NotesViewActivity;
import com.girish.model.NotesDAO;

import nucleus.presenter.RxPresenter;

/**
 * Created by girish on 07/07/16.
 */

public class NotesViewPresenter extends RxPresenter<NotesViewActivity> {

    public void updateData(long id , String description){
        NotesDAO notesDAO= NotesDAO.load(NotesDAO.class , id);
        notesDAO.description = description;
        notesDAO.save();
    }

}
