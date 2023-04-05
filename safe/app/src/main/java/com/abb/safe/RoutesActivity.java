package com.abb.safe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abb.safe.routeFragment.sRoutesFragment;

public class RoutesActivity extends AppCompatActivity {

    Button screenroute;
    Button screenmap;
    Button screensetting;
    Button routesafe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        //메뉴 버튼 설정
        //map 기본 메인 화면
        screenmap = findViewById(R.id.screenmap);
        screenroute = findViewById(R.id.screenroute);
        screensetting = findViewById(R.id.screensetting);
        screenmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
        screenroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RoutesActivity.class);
                startActivity(intent);
            }
        });
        screensetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent);
            }
        });

        //지도 그리기
        routesafe1 = findViewById(R.id.route1_safe);
        routesafe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Bundle bundle = new Bundle(); // 번들을 통해 값 전달
                    bundle.putString("route","routesafe1");//번들에 넘길 값 저장
                    sRoutesFragment routesFragment = new sRoutesFragment();
                    routesFragment.setArguments(bundle); //보내기
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,routesFragment).commit();

                } catch (Exception e) {
                    System.out.println("프레임 오류 생김");
                }

            }
        });
    }
}