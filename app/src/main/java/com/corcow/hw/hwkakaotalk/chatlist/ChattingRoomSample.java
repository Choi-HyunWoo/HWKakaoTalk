package com.corcow.hw.hwkakaotalk.chatlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.corcow.hw.hwkakaotalk.R;

import java.util.Date;

public class ChattingRoomSample extends AppCompatActivity {

    ListView listView;
    ChattingRoomAdapter mAdapter;
    RadioGroup category;
    EditText messageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting_room_sample);

        listView = (ListView) findViewById(R.id.listView);
        mAdapter = new ChattingRoomAdapter();
        listView.setAdapter(mAdapter);
        listView.setDivider(null);

        category = (RadioGroup)findViewById(R.id.radioGroup);
        messageView = (EditText)findViewById(R.id.edit_message);
        Button btn = (Button)findViewById(R.id.btn_input);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageView.getText().toString();
                switch (category.getCheckedRadioButtonId()) {
                    case R.id.radio_send: {
                        if (!TextUtils.isEmpty(message)) {
                            SendData data = new SendData();
                            data.message = message;
                            mAdapter.add(data);
                            messageView.setText("");
                        }
                        break;
                    }
                    case R.id.radio_receive: {
                        if (!TextUtils.isEmpty(message)) {
                            ReceiveData data = new ReceiveData();
                            data.message = message;
                            data.resId = R.drawable.img_chat_profile_send_default;
                            mAdapter.add(data);
                            messageView.setText("");
                        }
                        break;
                    }
                    case R.id.radio_date : {
                        DateData data = new DateData();
                        data.date = new Date().toString();
                        mAdapter.add(data);
                        messageView.setText("");
                    }
                    break;
                }
            }
        });


        btn = (Button)findViewById(R.id.btn_goback);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
