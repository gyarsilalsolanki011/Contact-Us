package com.gyarsilalsolanki011.contactus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ContactUsFragment extends Fragment {
    TextView whatsapp,feedback,send_your_message;
    ImageView linkedin, instagram, github, share;
    public ContactUsFragment() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact_us, container, false);

        whatsapp = v.findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uriText = "https://api.whatsapp.com/send/"+"?phone="+"7909519946"+"&text="+"Please+help+me+regarding+the+issue+:+"+"&type=phone_number&app_absent=0";
                gotoUrl(uriText);
            }
            private void gotoUrl(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });


        feedback = v.findViewById(R.id.feedback);
        feedback.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + Uri.encode("gyarsilalsolanki011@gmail.com") + "?subject=" +
                    Uri.encode("Send Ur feedback") + "&body=" + Uri.encode("");

            Uri uri = Uri.parse(uriText);
            intent.setData(uri);
            startActivity(Intent.createChooser(intent, "Send Email"));

        });



        send_your_message = v.findViewById(R.id.send_your_message);
        send_your_message.setOnClickListener(v1 -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        });


        linkedin = v.findViewById(R.id.linkedin);
        linkedin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String uriText = "https://www.linkedin.com/in/gyarsilalsolanki";
                gotoUrl(uriText);
            }
            private void gotoUrl(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        github = v.findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String uriText = "https://github.com/gyarsilalsolanki011";
                gotoUrl(uriText);
            }
            private void gotoUrl(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });


        instagram = v.findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String uriText = "https://www.instagram.com/invites/contact/?i=h3v7k8la76dm&utm_content=q90eiqa";
                gotoUrl(uriText);
            }
            private void gotoUrl(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });



        share = v.findViewById(R.id.share);
        share.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String shareBody = "look all Programmings";
            String subject = "https://github.com/gyarsilalsolanki011?tab=repositories";
            i.putExtra(Intent.EXTRA_SUBJECT,shareBody);
            i.putExtra(Intent.EXTRA_TEXT,subject);
            startActivity(Intent.createChooser(i,"Share via"));

        });
        return v;
    }
}