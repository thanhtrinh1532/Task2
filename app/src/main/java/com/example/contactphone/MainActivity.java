package com.example.contactphone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView; // RecyclerView để hiển thị danh sách
    private ContactAdapter contactAdapter; // Adapter cho RecyclerView
    private List<Contact> contactList; // Danh sách dữ liệu liên hệ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ RecyclerView từ layout
        recyclerView = findViewById(R.id.recyclerView);

        // Thiết lập layout manager cho RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo danh sách dữ liệu liên hệ
        contactList = new ArrayList<>();
        contactList.add(new Contact("Alan Jones"));
        contactList.add(new Contact("Kevin Foley"));
        contactList.add(new Contact("Maria Smidt"));
        contactList.add(new Contact("Nigel Jameson"));
        contactList.add(new Contact("Zoe Taylor"));

        // Tạo Adapter và gắn Adapter vào RecyclerView
        contactAdapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(contactAdapter);
    }
}