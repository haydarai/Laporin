package com.bananastech.laporin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.bananastech.laporin.R;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Haydar Ali Ismail on 24-Oct-15.
 */
public class ReportFraudActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private AppCompatButton mAppCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraud_report);
        final Bundle bundle = getIntent().getExtras();
        mToolbar = (Toolbar) findViewById(R.id.activity_fraud_report_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Data penipu");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText etName = (EditText) findViewById(R.id.activity_fraud_report_et_name);
        final MaterialSpinner spnContactType = (MaterialSpinner) findViewById(R.id.activity_fraud_report_spn_contact_type);
        final EditText etContact = (EditText) findViewById(R.id.activity_fraud_report_et_contact);
        final MaterialSpinner spnShop = (MaterialSpinner) findViewById(R.id.activity_fraud_report_spn_shop);
        final MaterialSpinner spnBankName = (MaterialSpinner) findViewById(R.id.activity_fraud_report_spn_bank_name);
        final EditText etBankAccountName = (EditText) findViewById(R.id.activity_fraud_report_et_bank_account_name);
        final EditText etBankAccountNumber = (EditText) findViewById(R.id.activity_fraud_report_et_bank_account_number);
        mAppCompatButton = (AppCompatButton) findViewById(R.id.activity_fraud_report_btn_next);

        final String contact_types[] = {"Nomor telpon", "WhatsApp", "Line", "Blackberry Messenger"};
        final ArrayAdapter<String> contactTypesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, contact_types);
        contactTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnContactType.setAdapter(contactTypesAdapter);

        final String shops[] = {"Kaskus", "Facebook", "Lazada", "Blibli", "Lain-lain"};
        final ArrayAdapter<String> shopsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shops);
        shopsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnShop.setAdapter(shopsAdapter);

        String banks[] = {"BCA", "Mandiri", "BNI", "CIMB Niaga", "Lain-lain"};
        ArrayAdapter<String> banksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, banks);
        banksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBankName.setAdapter(banksAdapter);

        mAppCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String con_name = etName.getText().toString();
                int con_contact_type_id = spnContactType.getSelectedItemPosition();
                String con_contact = etContact.getText().toString();
                int con_shop_id = spnShop.getSelectedItemPosition();
                int con_bank_id = spnBankName.getSelectedItemPosition();
                String con_bank_account_name = etBankAccountName.getText().toString();
                String con_bank_account_number = etBankAccountNumber.getText().toString();

                if (con_name.length() < 1) {
                    etName.setError("Tuliskan nama penipu");
                    return;
                }
                if (con_contact_type_id < 0) {
                    spnContactType.setError("Pilih jenis kontak penipu");
                    return;
                }
                if (con_contact.length() < 7) {
                    etContact.setError("Isikan kontak penipu");
                    return;
                }
                if (con_shop_id < 0) {
                    spnShop.setError("Pilih media penjualan penipu");
                    return;
                }
                if (con_bank_id < 0) {
                    spnBankName.setError("Pilih bank penipu");
                    return;
                }
                if (con_bank_account_name.length() < 1) {
                    etBankAccountName.setError("Tulis nama pemilik rekening");
                    return;
                }
                if (con_bank_account_number.length() < 10) {
                    etBankAccountNumber.setError("Tulis nomor rekening penipu");
                    return;
                }

                bundle.putString("con_name", con_name);
                bundle.putInt("con_contact_type_id", con_contact_type_id);
                bundle.putString("con_contact", con_contact);
                bundle.putInt("con_shop_id", con_shop_id);
                bundle.putInt("con_bank_id", con_bank_id);
                bundle.putString("con_bank_account_name", con_bank_account_name);
                bundle.putString("con_bank_account_number", con_bank_account_number);
                Intent intent = new Intent(getApplicationContext(), ReportDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
