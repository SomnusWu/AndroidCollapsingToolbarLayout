package com.somnus.mylib.recycleutils.recycleadapter; /**
 * Copyright 2013 Joan Zapata
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;


import com.somnus.mylib.recycleutils.animation.AlphaInAnimation;
import com.somnus.mylib.recycleutils.animation.BaseAnimation;
import com.somnus.mylib.recycleutils.animation.ScaleInAnimation;
import com.somnus.mylib.recycleutils.animation.SlideInBottomAnimation;
import com.somnus.mylib.recycleutils.animation.SlideInLeftAnimation;
import com.somnus.mylib.recycleutils.animation.SlideInRightAnimation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction class of a BaseAdapter in which you only need
 * to provide the convert() implementation.<br/>
 * Using the provided BaseViewHolder, your code is minimalist.
 *
 * @param <T> The type of the items in the list.
 *            <p/>
 *            <p/>
 *            BaseAdapter
 */
public abstract class BaseQuickAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @IntDef({ALPHAIN, SCALEIN, SLIDEIN_BOTTOM, SLIDEIN_LEFT, SLIDEIN_RIGHT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationType {
    }

    /**
     * Use with {@link #openLoadAnimation}
     */
    public static final int ALPHAIN = 0;
    /**
     * Use with {@link #openLoadAnimation}
     */
    public static final int SCALEIN = 1;
    /**
     * Use with {@link #openLoadAnimation}
     */
    public static final int SLIDEIN_BOTTOM = 2;
    /**
     * Use with {@link #openLoadAnimation}
     */
    public static final int SLIDEIN_LEFT = 3;
    /**
     * Use with {@link #openLoadAnimation}
     */
    public static final int SLIDEIN_RIGHT = 4;


    protected static final String TAG = BaseQuickAdapter.class.getSimpleName();

    protected final Context context;

    protected final int layoutResId;

    protected final List<T> data;

    private Interpolator mInterpolator = new LinearInterpolator();

    private int mDuration = 300;

    private int mLastPosition = -1;

    private boolean isFirstOnly = true;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    private int animationType = ALPHAIN;
    private BaseAnimation customAnimation = null;

    private boolean isOpenAnimation = false;

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    public interface OnRecyclerViewItemClickListener {
        public void onItemClick(View view, int position);
    }

    /**
     * Create a QuickAdapter.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public BaseQuickAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public BaseQuickAdapter(Context context, int layoutResId, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
        this.context = context;
        this.layoutResId = layoutResId;
    }

    public void remove(int position) {
        data.remove(position);
        notifyItemRemoved(position);

    }

    /**
     * 清除数据
     */
    public void clear() {
        if (data != null && !data.isEmpty())
            data.clear();
        notifyDataSetChanged();
    }

    public void add(int position, T item) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    /**
     * 添加数据
     *
     * @param list
     */
    public void addAll(List<T> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                layoutResId, parent, false);
        return new BaseViewHolder(context, item);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
        convert(baseViewHolder, data.get(position));

        if (onRecyclerViewItemClickListener != null) {
            baseViewHolder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecyclerViewItemClickListener.onItemClick(v, position);
                }
            });
        }
        if (isOpenAnimation) {
            if (!isFirstOnly || position > mLastPosition) {
                BaseAnimation animation = null;
                if (customAnimation == null) {
                    animation = new AlphaInAnimation();
                    switch (animationType) {
                        case ALPHAIN:
                            animation = new AlphaInAnimation();
                            break;
                        case SCALEIN:
                            animation = new ScaleInAnimation();
                            break;
                        case SLIDEIN_BOTTOM:
                            animation = new SlideInBottomAnimation();
                            break;
                        case SLIDEIN_LEFT:
                            animation = new SlideInLeftAnimation();
                            break;
                        case SLIDEIN_RIGHT:
                            animation = new SlideInRightAnimation();
                            break;
                    }
                } else {
                    animation = customAnimation;
                }
                for (Animator anim : animation.getAnimators(holder.itemView)) {
                    anim.setDuration(mDuration).start();
                    anim.setInterpolator(mInterpolator);
                }
                mLastPosition = position;
            }
        }
    }

    /**
     * Set the view animation type.
     *
     * @param animationType One of {@link #ALPHAIN}, {@link #SCALEIN}, {@link #SLIDEIN_BOTTOM}, {@link #SLIDEIN_LEFT}, {@link #SLIDEIN_RIGHT}.
     */
    public void openLoadAnimation(@AnimationType int animationType) {
        this.isOpenAnimation = true;
        this.animationType = animationType;
        customAnimation = null;
    }

    /**
     * Set Custom ObjectAnimator
     *
     * @param animation ObjectAnimator
     */
    public void openLoadAnimation(BaseAnimation animation) {
        this.isOpenAnimation = true;
        this.customAnimation = animation;
    }

    public void openLoadAnimation() {
        this.isOpenAnimation = true;
    }


    public void setFirstOnly(boolean firstOnly) {
        isFirstOnly = firstOnly;
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     * 实现此方法 进行视图操作
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    protected abstract void convert(BaseViewHolder helper, T item);


    @Override
    public long getItemId(int position) {
        return position;
    }


}
