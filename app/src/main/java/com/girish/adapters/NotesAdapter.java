package com.girish.adapters;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.girish.notes.R;
import com.girish.activity.NotesActivity;
import com.girish.activity.NotesViewActivity;
import com.girish.model.NotesDAO;
import com.girish.notes.BaseActivity;
import com.girish.presenter.NotesPresenter;
import com.girish.utils.Constant;
import com.girish.utils.Utility;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<NotesDAO> notesDAOs = null;
    private int resID = R.layout.activity_notes_item;
    private NotesActivity context;
    private NotesPresenter notesPresenter;

    public NotesAdapter(NotesActivity context){
        this.context = context;
        notesPresenter = new NotesPresenter();
        notesDAOs = notesPresenter.getNotesData();
    }


    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resID, parent, false);
        final NotesViewHolder notesViewHolder = new NotesViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = notesViewHolder.getAdapterPosition();
                NotesDAO notesDAO = notesDAOs.get(position);
                Intent intent = new Intent(context , NotesViewActivity.class);
                intent.putExtra(Constant.NOTE_ID , notesDAO.getId()+"");
                intent.putExtra(Constant.A_NOTE_DATA, notesDAO);
                context.startActivity(intent);
            }
        });
        return notesViewHolder;
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        NotesDAO notesDAO = notesDAOs.get(position);
        holder.id = notesDAO.getId();
        holder.title.setText(notesDAO.getTitle());
        holder.description.setText(notesDAO.getDescription());
        holder.delete_imageview.setTag(holder.id);
        holder.delete_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                    builder.setTitle(R.string.confirmation);
                    builder.setMessage(R.string.delete_conf_message);
                    builder.setPositiveButton(R.string.yes  , new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            long selectedId = (Long)v.getTag();
                            NotesDAO.delete(NotesDAO.class , selectedId);
                            notesDAOs = notesPresenter.getNotesData();
                            notifyDataSetChanged();
                        }
                    });

                    builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    builder.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return notesDAOs.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    /**
     *
     */
    public class NotesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.delete_imageview)
        ImageView delete_imageview;
        long id;

        public NotesViewHolder(View view) {
            super(view);
            ButterKnife.bind(this , view);
        }
    }

}
