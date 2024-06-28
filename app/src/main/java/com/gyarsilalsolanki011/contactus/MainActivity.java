package com.gyarsilalsolanki011.contactus;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gyarsilalsolanki011.contactus.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.contactBtn.setOnClickListener(v -> {
            binding.contactBtn.setVisibility(View.GONE);
            binding.fragmentContainer.setVisibility(View.VISIBLE);
            loadFrag(new ContactUsFragment());
        });
    }

    public  void loadFrag(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_Container, fragment);
        ft.commit();
    }
}