package com.corcow.hw.hwkakaotalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.corcow.hw.hwkakaotalk.R;
import com.corcow.hw.hwkakaotalk.chatlist.ChattingRoomSample;

import org.w3c.dom.Text;

public class FriendsInfo extends AppCompatActivity {

    ImageView imageView;

    TextView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_info);

        /* get name, phoneNum */
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        nameView = (TextView)findViewById(R.id.text_name);
        nameView.setText(name);

        // Chat
        imageView = (ImageView)findViewById(R.id.image_goToChat);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendsInfo.this, ChattingRoomSample.class);

                startActivity(intent);
                finish();
            }
        });

        // Dial
        imageView = (ImageView)findViewById(R.id.image_goToDial);
        final boolean showDialog = true;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showDialog) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(FriendsInfo.this);
                    builder.setMessage("미니프로필의 전화번호 버튼을 누르면 일반 전화로 연결되며, 통화료가 부과됩니다.");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Uri uri = Uri.parse("tel:010-9600-7673");
                            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("다시보지않음", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            boolean showDialog = false;
                            Uri uri = Uri.parse("tel:010-9600-7673");
                            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                            startActivity(intent);
                        }
                    });
                    AlertDialog dlg = builder.create();
                    dlg.show();
                }
            }
        });

        // KakaoStory
        imageView = (ImageView)findViewById(R.id.image_goToKakaostory);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://story.kakao.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
