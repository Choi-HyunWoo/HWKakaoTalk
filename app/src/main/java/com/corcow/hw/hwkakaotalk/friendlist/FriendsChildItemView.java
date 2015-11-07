package com.corcow.hw.hwkakaotalk.friendlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
    ImageView profileImage;
    private void init() {
        inflate(getContext(), R.layout.friends_view_child_item , this);
        nameView = (TextView)findViewById(R.id.text_name);
        profileImage = (ImageView)findViewById(R.id.img_profile);
    }

    public void setChildItem(FriendsChildItem item) {
        nameView.setText(item.name);
        profileImage.setImageResource(item.profileImageResource);
    }
}
