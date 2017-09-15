package com.agima.mymoxyapp.ui.samples.presenterList.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agima.mymoxyapp.R;
import com.agima.mymoxyapp.ui.samples.list.model.Student;
import com.agima.mymoxyapp.ui.samples.presenterList.adapter.holder.MvpViewHolder;
import com.agima.mymoxyapp.ui.samples.presenterList.item.ItemPresenter;
import com.agima.mymoxyapp.ui.samples.presenterList.item.ItemView;
import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PresenteredListAdapter extends RecyclerView.Adapter<PresenteredListAdapter.ItemViewHolder> {

    private MvpDelegate<?> parentDelegate;

    private List<Student> items = new ArrayList<>();

    public void setItems(List<Student> items) {
        this.items = items;
    }

    public PresenteredListAdapter(MvpDelegate<?> parentDelegate) {
        this.parentDelegate = parentDelegate;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends MvpViewHolder implements ItemView {

        @BindView(R.id.nameText)
        TextView nameText;

        @BindView(R.id.secondNameText)
        TextView secondNameText;

        @BindView(R.id.rootView)
        View rootView;

        @BindView(R.id.presenterId)
        TextView counterText;

        @BindView(R.id.viewHolder)
        TextView viewHolder;

        private Student student;

        @ProvidePresenter
        protected ItemPresenter providePresenter() {
            return new ItemPresenter(student);
        }

        @InjectPresenter
        public ItemPresenter itemPresenter;


        public ItemViewHolder(View itemView) {
            super(PresenteredListAdapter.this.parentDelegate, itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setName(String name) {
            nameText.setText(name);
        }

        @Override
        public void setSecondName(String secondName) {
            secondNameText.setText(secondName);
        }

        @Override
        public void setCounterText(String counterText) {
            this.counterText.setText(counterText);
        }

        @Override
        public void setColor(int color) {
            rootView.setBackgroundColor(color);
        }

        protected void bind(Student student) {
            destroyMvpDelegate();

            this.student = student;

            createMvpDelegate();

            itemPresenter.bind();

            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemPresenter.changeColor();
                }
            });

            viewHolder.setText(this.toString());
        }

        @Override
        protected String getMvpChildId() {
            return student == null ? null : student.getId();
        }
    }
}