package com.example.mmert.finalprojeson;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GirisActivity extends AppCompatActivity {
    private int attempt = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        final Button girisYap = (Button) findViewById(R.id.btn_girisYap);
        final EditText edt_ka = (EditText) findViewById(R.id.edt_user);
        final EditText edt_sfr = (EditText) findViewById(R.id.edt_pass);
        final TextView txt_at = (TextView) findViewById(R.id.txt_atm);
        girisYap.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edt_ka.getText().toString().equals("mmert") && edt_sfr.getText().toString().equals("abc123")) {
                            Toast.makeText(GirisActivity.this, "Kullanıcı Adı ve Şifre Doğru", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(GirisActivity.this, SecenekActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(GirisActivity.this, "Kullanıcı Adı ve Şifre Hatalı", Toast.LENGTH_SHORT).show();
                            attempt--;
                            txt_at.setText(String.valueOf(attempt));
                            if (attempt == 0)
                                girisYap.setEnabled(false);
                        }
                    }
                }

        );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
