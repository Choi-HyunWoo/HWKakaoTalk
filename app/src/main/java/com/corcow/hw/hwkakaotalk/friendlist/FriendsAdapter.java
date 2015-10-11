package com.corcow.hw.hwkakaotalk.friendlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by multimedia on 2015-10-11.
 */
public class FriendsAdapter extends BaseExpandableListAdapter {

    List<FriendsGroupItem> items = new ArrayList<FriendsGroupItem>();

    public void add(String groupname, String name, int resId) {
        FriendsGroupItem g = null;
        for (FriendsGroupItem item : items) {
            if (item.groupname.equals(groupname)) {
                g = item;
                break;
            }
        }
        if (g == null) {
            g = new FriendsGroupItem();
            g.groupname = groupname;
            items.add(g);
        }
        if (name != null) {
            FriendsChildItem item = new FriendsChildItem();
            item.name = name;
            item.profileImageResource = resId;
            g.children.add(item);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return (long)groupPosition << 32 | 0xFFFFFFFF;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return (long)groupPosition << 32 | childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        FriendsGroupItemView v;
        if (convertView != null) {
            v = (FriendsGroupItemView) convertView;
        } else {
            v = new FriendsGroupItemView(parent.getContext());
        }
        // 데이터 할당
        v.setGroupItem(items.get(groupPosition));
        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        FriendsChildItemView v;
        if (convertView != null) {
            v = (FriendsChildItemView) convertView;
        } else {
            v = new FriendsChildItemView(parent.getContext());
        }
        // 데이터 할당
        v.setChildItem(items.get(groupPosition).children.get(childPosition));
        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
