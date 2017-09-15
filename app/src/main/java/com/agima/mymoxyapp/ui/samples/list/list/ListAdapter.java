package com.agima.mymoxyapp.ui.samples.list.list;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agima.mymoxyapp.R;
import com.agima.mymoxyapp.ui.samples.list.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {

    public ListAdapter(List<Student> items, ListAdapterDelegate delegate) {
        this.items = items;
        this.delegate = delegate;
    }

    private List<Student> items = new ArrayList<>();

    private HashMap<String, Integer> colorSet = new HashMap<>();

    private ListAdapterDelegate delegate;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        Student student = items.get(position);

        holder.bind(student);

        Integer color = colorSet.get(student.getId());
        if (color != null) {
            holder.rootView.setBackgroundColor(color);
        } else {
            holder.rootView.setBackgroundColor(Color.TRANSPARENT);
        }

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer color = delegate.getRandomColor();
                colorSet.put(items.get(position).getId(), color);
                holder.rootView.setBackgroundColor(color);
                delegate.onClick(position, color);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @BindView(R.id.nameText)
        TextView nameText;
        @BindView(R.id.secondNameText)
        TextView secondNameText;
        @BindView(R.id.rootView)
        View rootView;

        void bind(Student student) {
            nameText.setText(student.getName());
            secondNameText.setText(student.getSurname());
        }
    }
}
