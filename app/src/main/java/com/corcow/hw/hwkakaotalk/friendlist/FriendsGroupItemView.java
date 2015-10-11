package com.corcow.hw.hwkakaotalk.friendlist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.corcow.hw.hwkakaotalk.R;

/**
 * Created by multimedia on 2015-10-11.
 */
public class FriendsGroupItemView extends FrameLayout {
    public FriendsGroupItemView(Context context) {
        super(context);
        init();
    }
    TextView contentNameView;
    private void init() {
        inflate(getContext(), R.layout.friends_view_group_item, this);
        contentNameView = (TextView)findViewById(R.id.text_contentname);
    }

    public void setGroupItem (FriendsGroupItem item) {
        contentNameView.setText(item.groupname);
    }

}
