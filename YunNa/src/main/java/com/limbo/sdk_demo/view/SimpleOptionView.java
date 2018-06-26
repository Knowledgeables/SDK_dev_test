package com.limbo.sdk_demo.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.limbo.sdk_demo.R;

public class SimpleOptionView extends LinearLayout {

    private ImageView mLeftImageView;
    private ImageView mRightImageView;
    private TextView mRightTextView;
    private RelativeLayout mLeftParent;
    private RelativeLayout mRightParent;
    private TextView mTitleText;
    private View mCustomeView;
    private RelativeLayout mTobBar;
    private boolean isSetBackOption = false;


    public SimpleOptionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleOptionView(Context context) {
        this(context, null);
    }

    public SimpleOptionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SimpleOptionView);
        String title = a.getString(R.styleable.SimpleOptionView_option_title);
        int barheight = a.getDimensionPixelSize(R.styleable.SimpleOptionView_option_barheight, -1);
        int textSize = a.getDimensionPixelSize(R.styleable.SimpleOptionView_option_textsize, -1);
        int right_textSize = a.getDimensionPixelSize(R.styleable.SimpleOptionView_option_right_textsize, -1);
        int bgColor = a.getColor(R.styleable.SimpleOptionView_option_backgroundcolor, -1);
        int textColor = a.getColor(R.styleable.SimpleOptionView_option_textcolor, -1);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.simple_action_bar, this, true);

        mTitleText = findViewById(R.id.option_textview_title);
        mLeftParent = findViewById(R.id.left_parent);
        mRightParent = findViewById(R.id.right_parent);
        mTobBar = findViewById(R.id.top_bar);
        mLeftImageView = findViewById(R.id.option_imageview_left);
        mRightTextView = findViewById(R.id.option_textview_right);
        mRightImageView = findViewById(R.id.option_imageview_right);
        if (title != null) {
            mTitleText.setText(title);
        }
        if (barheight != -1) {
            mTobBar.setMinimumHeight(barheight);
        }
        if (textSize != -1) {
            mTitleText.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }
        if (right_textSize != -1) {
            mRightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, right_textSize);
        }
        if (bgColor != -1) {
            mTobBar.setBackgroundColor(bgColor);
        }
        if (textColor != -1) {
            mTitleText.setTextColor(textColor);
            //mRightTextView.setTextColor(textColor);
        }

        setBackOption(true);
    }

    public void setCenterCustomeView(View v) {
        if (mCustomeView != v) {
            mCustomeView = v;
            ViewGroup vg = (ViewGroup) mTitleText.getParent();
            mTitleText.setVisibility(View.GONE);
            vg.addView(v);
        }
    }

    public void removeCenterCustomeView() {
        if (mCustomeView != null) {
            ViewGroup vg = (ViewGroup) mTitleText.getParent();
            vg.removeView(mCustomeView);
            mCustomeView = null;
            mTitleText.setVisibility(View.VISIBLE);
        }
    }

    public void setLeftOption(int resId, OnClickListener listener) {
        mLeftImageView.setTag(resId);
        mLeftImageView.setVisibility(View.VISIBLE);
        mLeftImageView.setImageResource(resId);
        mLeftParent.setOnClickListener(listener);
        isSetBackOption = false;
    }

    public void setRightOption(int resId, OnClickListener listener) {
        mRightImageView.setVisibility(View.VISIBLE);
        mRightTextView.setVisibility(View.GONE);
        mRightImageView.setImageResource(resId);
        mRightParent.setOnClickListener(listener);
    }

    public void setRightText(int resId, OnClickListener listener) {
        mRightTextView.setVisibility(View.VISIBLE);
        mRightImageView.setVisibility(View.GONE);
        mRightTextView.setText(resId);
        mRightParent.setOnClickListener(listener);
    }

    public void setRightText(String text, OnClickListener listener) {
        mRightTextView.setVisibility(View.VISIBLE);
        mRightImageView.setVisibility(View.GONE);
        mRightTextView.setText(text);
        mRightParent.setOnClickListener(listener);
    }

    public void setRightText(String text, int color, OnClickListener listener) {
        mRightTextView.setVisibility(View.VISIBLE);
        mRightImageView.setVisibility(View.GONE);
        mRightTextView.setText(text);
        mRightParent.setOnClickListener(listener);
    }

    public void setRightViewVisibility(int visibility) {
        mRightTextView.setVisibility(visibility);
    }

    public void setLeftImageViewVisibility(int visibility) {
        mLeftParent.setVisibility(visibility);
    }

    public void setRightOptionEnabled(boolean b) {
        mRightParent.setEnabled(b);

    }

    public View getRightView() {
        return mRightImageView;
    }

    private OnClickListener leftClickListener;

    /**
     * 设置返回按钮的点击事件
     *
     * @param leftClickListener
     */
    public void setLeftClickListener(OnClickListener leftClickListener) {
        this.leftClickListener = leftClickListener;
    }

    public void setBackOption(boolean b) {
        if (isSetBackOption != b) {
            isSetBackOption = b;
            if (b) {
                mLeftImageView.setImageResource(R.drawable.back_selector);
                mLeftParent.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if (leftClickListener != null) {
                            leftClickListener.onClick(view);
                        }
                        ((Activity) getContext()).onBackPressed();
                    }
                });
                mLeftImageView.setContentDescription("back Icon");

            } else {
                mLeftParent.setOnClickListener(null);
            }
        }
        if (b) {
            mLeftImageView.setVisibility(View.VISIBLE);
        } else {
            mLeftImageView.setVisibility(View.INVISIBLE);
        }
    }

    public void setRightCustomeView(View v, OnClickListener l) {
        if (mRightParent != null) {
            mRightParent.removeAllViews();
            if (v.getParent() == null) {
                mRightParent.addView(v);
            }
            mRightParent.setVisibility(View.VISIBLE);
            mRightParent.setOnClickListener(l);
        }
    }

    public void setLeftCustomeView(View v, OnClickListener l) {
        if (mLeftParent != null) {
            mLeftParent.removeAllViews();
            if (v.getParent() == null) {
                mLeftParent.addView(v);
            }
            mLeftParent.setVisibility(View.VISIBLE);
            mLeftParent.setOnClickListener(l);
        }

    }


    public CharSequence getTitle() {
        return mTitleText.getText();
    }

    public void setTitle(CharSequence str) {
        mTitleText.setText(str);
        mTitleText.setVisibility(View.VISIBLE);
        if (mCustomeView != null) {
            ViewGroup vg = (ViewGroup) mTitleText.getParent();
            vg.removeView(mCustomeView);
            mCustomeView = null;
        }
    }

    public void setTitle(CharSequence str, int textSize, int textColor) {
        mTitleText.setText(str);
        mTitleText.setTextSize(textSize);
        mTitleText.setTextColor(textColor);
        mTitleText.setVisibility(View.VISIBLE);
        if (mCustomeView != null) {
            ViewGroup vg = (ViewGroup) mTitleText.getParent();
            vg.removeView(mCustomeView);
            mCustomeView = null;
        }
    }

    public void setTitle(int resId) {
        mTitleText.setText(resId);
        mTitleText.setVisibility(View.VISIBLE);
        if (mCustomeView != null) {
            ViewGroup vg = (ViewGroup) mTitleText.getParent();
            vg.removeView(mCustomeView);
            mCustomeView = null;
        }
    }

    public TextView getTitleView() {
        return mTitleText;
    }

}
