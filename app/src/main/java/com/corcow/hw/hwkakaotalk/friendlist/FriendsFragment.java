package com.corcow.hw.hwkakaotalk.friendlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.corcow.hw.hwkakaotalk.FriendsInfo;
import com.corcow.hw.hwkakaotalk.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {

    ExpandableListView listView;
    FriendsAdapter mAdapter;

    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_friends, container, false);
        listView = (ExpandableListView) v.findViewById(R.id.expandableListView);

        // headerview(검색창)는 listview에 adapter를 할당하기 전에 설정
        View headerView = inflater.inflate(R.layout.friends_header_layout, null);
        listView.addHeaderView(headerView, null, false);

        // child clicked
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                FriendsChildItem data = (FriendsChildItem) mAdapter.getChild(groupPosition, childPosition);
                Intent intent = new Intent(getActivity(), FriendsInfo.class);
                intent.putExtra("name", data.name);
                intent.putExtra("img", data.profileImageResource);
                startActivity(intent);

                return false;
            }
        });

        // adapter 할당
        mAdapter = new FriendsAdapter();
        listView.setAdapter(mAdapter);


        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                listView.expandGroup(groupPosition);
            }
        });

        // Data add
        mAdapter.add("내 프로필", "최현우", R.drawable.img_chat_profile_send_default);
        mAdapter.add("즐겨찾기", "### 10남 ###", R.drawable.img_chat_profile_send_default);
        mAdapter.add("즐겨찾기", "● 졸프 ●", R.drawable.img_chat_profile_send_default);
        mAdapter.add("즐겨찾기", "와타시의원경쨩", R.drawable.img_chat_profile_send_default);
        mAdapter.add("친구", "가이슬", R.drawable.img_chat_profile_send_default);
        mAdapter.add("친구", "가평", R.drawable.img_chat_profile_send_default);
        mAdapter.add("친구", "강태윤", R.drawable.img_chat_profile_send_default);
        mAdapter.add("친구", "강태윤", R.drawable.img_chat_profile_send_default);
        mAdapter.add("친구", "강태임", R.drawable.img_chat_profile_send_default);
        mAdapter.add("친구", "고현경", R.drawable.img_chat_profile_send_default);
        mAdapter.add("친구", "광", R.drawable.img_chat_profile_send_default);

        // group expand
        for (int i=0; i<mAdapter.getGroupCount(); i++) {
            listView.expandGroup(i);
        }

        return v;
    }

}
