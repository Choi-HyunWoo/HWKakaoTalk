package com.corcow.hw.hwkakaotalk.chatlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by multimedia on 2015-10-11.
 */
public class ChatlistAdapter extends BaseAdapter{

    List<ChatlistItem> items = new ArrayList<ChatlistItem>();

    public void add(String roomName, String chatText, String lastTime, int roomImgResource) {
        ChatlistItem c = null;
        for (ChatlistItem item : items) {
            if (item.roomName.equals(roomName)) {
                c = item;
                break;
            }
        }
        if (c == null) {
            c = new ChatlistItem();
            c.roomName = roomName;
            c.chatText = chatText;
            c.lastTime = lastTime;
            c.roomImageResource = roomImgResource;
            items.add(c);
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatlistItemView v;
        if (convertView != null)
            v = (ChatlistItemView) convertView;
        else
            v = new ChatlistItemView(parent.getContext());
        // data
        v.setChatItem(items.get(position));
        return v;
    }
}
