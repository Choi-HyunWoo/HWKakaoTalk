package com.corcow.hw.hwkakaotalk.chatlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.corcow.hw.hwkakaotalk.R;
import com.corcow.hw.hwkakaotalk.chatlist.SendData;

/**
 * Created by multimedia on 2015-10-11.
 */
public class SendView extends FrameLayout {
    // SendView가 가진 멤버
    TextView messageView;

    public SendView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_send, this);
        messageView = (TextView) findViewById(R.id.text_message);

    }

    public void setData(SendData data) {
        messageView.setText(data.message);
    }
}
