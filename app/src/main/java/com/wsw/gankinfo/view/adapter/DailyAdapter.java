package com.wsw.gankinfo.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.wsw.gankinfo.R;
import com.wsw.gankinfo.model.vo.DailyVO;
import com.wsw.gankinfo.view.DetailActivity;

import org.jetbrains.annotations.NotNull;

import vm.DailyViewModel;

/**
 * Created by wsw on 2016/12/12.
 */

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> implements TypeUtils {

    private static final int HEAD = 0;
    private static final int CONTENT = 1;

    private ObservableArrayList<DailyVO> dailyVOs;

    private Activity mActivity;

    public DailyAdapter(ObservableArrayList<DailyVO> dailyVOs) {
        this.dailyVOs = dailyVOs;
    }

    public void setActivity(@NotNull Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                getItemLayoutId(viewType),
                parent,
                false);
        return new DailyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {
        holder.bindTo(handleData(dailyVOs.get(position), position));
    }

    @Override
    public int getItemCount() {
        return dailyVOs.size();
    }

    @Override
    public int getItemLayoutId(int viewType) {
        if (viewType == HEAD) {
            return R.layout.item_recycle_daily_head;
        } else {
            return R.layout.item_recycle_daily;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (dailyVOs.get(position).isHead()) {
            return HEAD;
        } else {
            return CONTENT;
        }
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mBinding;

        public DailyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bindTo(DailyViewModel dailyViewModel) {
            mBinding.setVariable(BR.daily, dailyViewModel);
            mBinding.executePendingBindings();

            mBinding.getRoot().setOnClickListener(view -> {
                Intent intent = new Intent(mActivity, DetailActivity.class);
                intent.putExtra("url", dailyViewModel.url.get());
                mActivity.startActivity(intent);
            });
        }
    }


    private DailyViewModel handleData(DailyVO dailyVO, int pos) {
        DailyViewModel dailyViewModel = new DailyViewModel();
        dailyViewModel.author.set(dailyVO.getAuthor() == null ? "未知" : dailyVO.getAuthor());
        dailyViewModel.desc.set(dailyVO.getDesc());
        dailyViewModel.time.set(dailyVO.getTime());
        dailyViewModel.type.set(dailyVO.getType());
        dailyViewModel.url.set(dailyVO.getUrl());
        return dailyViewModel;
    }

}
