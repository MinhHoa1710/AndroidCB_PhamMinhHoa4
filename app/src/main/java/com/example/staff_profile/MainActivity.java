package com.example.staff_profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.Random;
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
 */

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_profile);

        // Khởi tạo các View
        LinearLayout layout = findViewById(R.id.linear_layout);
        ImageView imageView = findViewById(R.id.my_image_view);
        TextView textView = findViewById(R.id.text_view);
        progressBar = findViewById(R.id.custom_progress_bar);

        // Hiển thị ProgressBar
        progressBar.setVisibility(View.VISIBLE);

        // Thực hiện công việc bất đồng bộ
        new Thread(() -> {
            try {
                // Giả lập một khoảng thời gian để hiển thị hiệu ứng tải
                Thread.sleep(2000); // 2 giây delay

                // Mảng các màu từ colors.xml
                int[] colors = {
                        getResources().getColor(R.color.purple_200),
                        getResources().getColor(R.color.purple_500),
                        getResources().getColor(R.color.purple_700),
                        getResources().getColor(R.color.teal_200),
                        getResources().getColor(R.color.teal_700),
                        getResources().getColor(R.color.indigo),
                        getResources().getColor(R.color.black),
                        getResources().getColor(R.color.white)
                };
                // Chọn màu ngẫu nhiên từ mảng
                Random random = new Random();
                int randomColor = colors[random.nextInt(colors.length)];
                // Cập nhật giao diện người dùng trên thread chính
                runOnUiThread(() -> {
                    // Đặt nền của layout thành màu ngẫu nhiên
                    layout.setBackgroundColor(randomColor);
                    // Ẩn ProgressBar sau khi hoàn thành công việc
                    progressBar.setVisibility(View.GONE);
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
                // Nếu có lỗi, ẩn ProgressBar
                runOnUiThread(() -> progressBar.setVisibility(View.GONE));
            }
        }).start(); // Bắt đầu thread mới
    }
}

