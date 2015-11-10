package com.bananastech.laporin.activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.bananastech.laporin.R;
import com.bananastech.laporin.fragments.picker.DatePickerFragment;

/**
 * Created by Haydar Ali Ismail on 24-Oct-15.
 */
public class ReportDetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private AppCompatButton mAppCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_report);
        Bundle bundle = getIntent().getExtras();
        mToolbar = (Toolbar) findViewById(R.id.activity_detail_report_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Detail penipuan");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText etDate = (EditText) findViewById(R.id.activity_detail_report_et_date);
        etDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                DialogFragment dialogFragment =
                        new DatePickerFragment() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        super.onDateSet(view, year, monthOfYear, dayOfMonth);
                        etDate.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear) + "-" + String.valueOf(year));
                    }
                };
                dialogFragment.show(getSupportFragmentManager(), "datepicker");
            }
        });
        mAppCompatButton = (AppCompatButton) findViewById(R.id.activity_detail_report_btn_finish);
        mAppCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(ReportDetailActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            progressDialog.dismiss();
                        }
                    }
                });
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
