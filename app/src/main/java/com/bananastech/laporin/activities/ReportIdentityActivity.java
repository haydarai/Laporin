package com.bananastech.laporin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bananastech.laporin.R;

/**
 * Created by Haydar Ali Ismail on 24-Oct-15.
 */
public class ReportIdentityActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private AppCompatButton mAppCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_report);
        mToolbar = (Toolbar) findViewById(R.id.activity_identity_report_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Data pelapor");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAppCompatButton = (AppCompatButton) findViewById(R.id.activity_identity_report_btn_next);
        mAppCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tvName = (EditText) findViewById(R.id.activity_identity_report_et_name);
                if (tvName.length() < 1) {
                    tvName.setError("Tuliskan nama anda");
                    return;
                }
                EditText tvPhone = (EditText) findViewById(R.id.activity_identity_report_et_phone);
                if (tvPhone.length() < 6) {
                    tvPhone.setError("Tuliskan nomor telpon yang valid");
                    return;
                }
                EditText tvEmail = (EditText) findViewById(R.id.activity_identity_report_et_email);
                String name = tvName.getText().toString();
                String phone = tvPhone.getText().toString();
                String email = tvEmail.getText().toString();
                if (!(email.contains(".")) || (!email.contains("@"))) {
                    tvEmail.setError("Tuliskan email yang valid");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("reporter_name", name);
                bundle.putString("reporter_phone", phone);
                bundle.putString("reporter_email", email);
                Intent intent = new Intent(getApplicationContext(), ReportFraudActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
