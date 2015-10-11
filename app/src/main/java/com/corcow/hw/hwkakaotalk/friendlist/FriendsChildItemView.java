package com.corcow.hw.hwkakaotalk.friendlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.corcow.hw.hwkakaotalk.R;

/**
 * Created by multimedia on 2015-10-11.
 */
public class FriendsChildItemView extends FrameLayout {
    public FriendsChildItemView(Context context) {
        super(context);
        init();
    }

    TextView nameView;
    ImageButton profileImageBtn;
    private void init() {
        inflate(getContext(), R.layout.friends_view_child_item , this);
        nameView = (TextView)findViewById(R.id.text_name);
        profileImageBtn = (ImageButton)findViewById(R.id.img_profile);
    }

    public void setChildItem(FriendsChildItem item) {
        nameView.setText(item.name);
        profileImageBtn.setImageResource(item.profileImageResource);
    }
}
