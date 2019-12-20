package com.bawei.chenshuaishuaiyuekaodemo01.view.wedgit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class FlowLayout extends LinearLayout {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int left =0 ;
        int top = 0;
        int right = 0;
        int bottom = 0;

        int childCount = getChildCount();
        System.out.println("count===="+childCount);
        if (childCount>0){
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                childView.measure(0,0);

                int childWidth = childView.getMeasuredWidth();
                int childHeight = childView.getMeasuredHeight();
                DisplayMetrics dm = getResources().getDisplayMetrics();
                int screenWidth =  dm.widthPixels;
                right = left+childWidth;
                if (right>screenWidth){
                    left = 0;
                    right = left+childWidth;
                    top = bottom+30;
                }
                bottom = top+childHeight;
                childView.layout(left,top,right,bottom);
                left += childWidth+30;

            }
        }

            }



    public void addView(List<String> tags){
        if (tags!=null&&tags.size()>0){
            for (String tag : tags) {
                final TextView textView = new TextView(getContext());
                textView.setText(tag);
                addView(textView);
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickflow.clc(textView.getText().toString());
                    }
                });


            }
        }
    }
    public void addd(String ed){
        final TextView tt=new TextView(getContext());
        tt.setText(ed);
        addView(tt);
        tt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickflow.clc(tt.getText().toString());
            }
        });
    }
    private Clickflow clickflow;

    public void setClickflow(Clickflow clickflow) {
        this.clickflow = clickflow;
    }

    public interface Clickflow{
        void clc(String keyword);
    }

}
