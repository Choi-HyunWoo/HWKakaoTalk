package com.corcow.hw.hwkakaotalk.chatlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.corcow.hw.hwkakaotalk.R;

/**
 * Created by multimedia on 2015-10-11.
 */
public class DateView extends FrameLayout {

    // DateView 의 멤버
    TextView dateView;

    public DateView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_date, this);
        dateView = (TextView) findViewById(R.id.text_date);
    }

    public void setData(DateData data) {
        dateView.setText(data.date);

    }
}