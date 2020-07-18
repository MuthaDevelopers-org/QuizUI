package com.example.quizui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class LoginScreen extends AppCompatActivity {

    LinearLayout loginLayoutSlider;
    BottomSheetBehavior<LinearLayout> bottomSheetBehavior;
    LinearLayout splashScreenLayout;
    FrameLayout credentialInfoFrame , loginFrame;
    TextView helpButton;
    Button proceedButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginLayoutSlider = findViewById(R.id.login_slider);
        splashScreenLayout = findViewById(R.id.splashScreenLayout);
        credentialInfoFrame = findViewById(R.id.credentialInformationFrame);
        loginFrame = findViewById(R.id.loginFrame);
        helpButton = findViewById(R.id.helpButton);
        proceedButton = findViewById(R.id.proceedButton);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credentialInfoFrame.setVisibility(View.GONE);
                loginFrame.setVisibility(View.VISIBLE);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFrame.setVisibility(View.GONE);
                credentialInfoFrame.setVisibility(View.VISIBLE);
            }
        });

        initSlider();
    }

    private void initSlider() {

        bottomSheetBehavior = BottomSheetBehavior.from(loginLayoutSlider);
        loginLayoutSlider.findViewById(R.id.sliderTextLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    splashScreenLayout.setAlpha(.8f);
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                    credentialInfoFrame.setVisibility(View.VISIBLE);
                    loginFrame.setVisibility(View.GONE);

                }else{
                    splashScreenLayout.setAlpha(1f);
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                    credentialInfoFrame.setVisibility(View.VISIBLE);
                    loginFrame.setVisibility(View.GONE);
                }
            }
        });
    }
}