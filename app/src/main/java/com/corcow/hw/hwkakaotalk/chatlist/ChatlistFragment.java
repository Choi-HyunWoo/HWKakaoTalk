package com.corcow.hw.hwkakaotalk.chatlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.corcow.hw.hwkakaotalk.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatlistFragment extends Fragment {

    ListView listView;
    ChatlistAdapter mAdapter;

    public ChatlistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chatlist, container, false);

        listView = (ListView)v.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ChattingRoomSample.class));
            }
        });

        // 헤더뷰
        View headerView = inflater.inflate(R.layout.chatlist_header_layout, null);
        listView.addHeaderView(headerView);

        // Adapter
        mAdapter = new ChatlistAdapter();
        listView.setAdapter(mAdapter);

        mAdapter.add("최현우", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우2", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우3", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우4", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우5", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우6", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우7", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우8", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우9", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우0", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);
        mAdapter.add("최현우-", "테스트 테스트 테스트", "오후 6:50", R.drawable.img_chat_profile_send_default);



        return v;
    }


}
