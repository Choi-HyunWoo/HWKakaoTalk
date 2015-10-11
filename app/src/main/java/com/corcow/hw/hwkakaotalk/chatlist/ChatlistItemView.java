package com.corcow.hw.hwkakaotalk.chatlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.corcow.hw.hwkakaotalk.R;

/**
 * Created by multimedia on 2015-10-11.
 */
public class ChatlistItemView extends FrameLayout {
    public ChatlistItemView(Context context) {
        super(context);
        init();
    }

    ImageView chatroomImageView;
    TextView othersNameView;
    TextView chatTextView;
    TextView timeTextView;

    public void init() {
        inflate(getContext(), R.layout.chatlist_view_item, this);

        chatroomImageView = (ImageView)findViewById(R.id.img_chatroom);
        othersNameView = (TextView)findViewById(R.id.text_othersname);
        chatTextView = (TextView)findViewById(R.id.text_othersname);
        timeTextView = (TextView)findViewById(R.id.text_time);
    }

    public void setChatItem(ChatlistItem item) {
        chatroomImageView.setImageResource(item.roomImageResource);
        othersNameView.setText(item.roomName);
        chatTextView.setText(item.chatText);
        timeTextView.setText(item.lastTime);
    }

}
