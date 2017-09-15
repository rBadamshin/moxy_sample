package com.agima.mymoxyapp.ui.samples.presenterList.adapter.holder;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.MvpDelegate;

import butterknife.ButterKnife;

public abstract class MvpViewHolder extends RecyclerView.ViewHolder {
    private MvpDelegate mMvpDelegate;
    private final MvpDelegate mParentDelegate;
    public MvpViewHolder(MvpDelegate<?> parentDelegate, final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mParentDelegate = parentDelegate;
    }

    @Nullable
    protected MvpDelegate getMvpDelegate() {
        if (getMvpChildId() == null) {
            return null;
        }
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);
            mMvpDelegate.setParentDelegate(mParentDelegate, getMvpChildId());
        }
        return mMvpDelegate;
    }

    protected void destroyMvpDelegate() {
        if (getMvpDelegate() != null) {
            getMvpDelegate().onSaveInstanceState();
            getMvpDelegate().onDetach();
            mMvpDelegate = null;
        }
    }

    protected void createMvpDelegate() {
        if (getMvpDelegate() != null) {
            getMvpDelegate().onCreate();
            getMvpDelegate().onAttach();
        }
    }
    protected abstract String getMvpChildId();
}
