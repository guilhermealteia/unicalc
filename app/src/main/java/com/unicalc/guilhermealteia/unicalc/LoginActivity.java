package com.unicalc.guilhermealteia.unicalc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.unicalc.guilhermealteia.unicalc.connection.Connection;
import com.unicalc.guilhermealteia.unicalc.utils.CommonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btLogin;
    private ContentLoadingProgressBar clpbLoading;
    private boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        clpbLoading = (ContentLoadingProgressBar) findViewById(R.id.clpb_loading);

        etEmail.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                etEmail = (EditText) view;
                if(etEmail.getText().toString() != null && etEmail.getText().toString().contains( "\n")){
                    etEmail.setText(etEmail.getText().toString().replace("\n", ""));
                    etPassword.requestFocus();
                }
                return false;
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Connection().execute("https://earthquake.usgs.gov/fdsnws/event/1/query?endtime=2016-01-31&format=geojson&limit=10&minmag=6&starttime=2016-01-01");

                //MOCK
                if ("alteia@live.com".equals(etEmail.getText().toString())){
                    Intent myIntent = new Intent(LoginActivity.this, CalcActivity.class);
                    myIntent.putExtra("email", etEmail.getText().toString()); //Optional parameters
                    LoginActivity.this.startActivity(myIntent);
                } else {
                }
            }
        });
    }

    class Connection extends AsyncTask<String, Void, String> {
        ContentLoadingProgressBar clpbLoading = (ContentLoadingProgressBar) findViewById(R.id.clpb_loading);

        @Override
        protected void onPreExecute() {
            clpbLoading.setVisibility(View.VISIBLE);
            etEmail.setVisibility(View.INVISIBLE);
            etPassword.setVisibility(View.INVISIBLE);
            btLogin.setVisibility(View.INVISIBLE);
            clpbLoading.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            URL url;
            StringBuffer response = new StringBuffer();
            String responseJSON = "";
            try {
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("invalid url");
            }

            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(false);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

                // handle the response
                int status = conn.getResponseCode();
                if (status != 200) {
                    throw new IOException("Post failed with error code " + status);
                } else {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }

                //Here is your json in string format
                responseJSON = response.toString();
                Log.d("responseJSON: ", responseJSON);
            }
            loaded = true;
            return responseJSON;
        }

        @Override
        protected void onPostExecute(String s) {
            clpbLoading.setVisibility(View.INVISIBLE);
            etEmail.setVisibility(View.VISIBLE);
            etPassword.setVisibility(View.VISIBLE);
            btLogin.setVisibility(View.VISIBLE);
            clpbLoading.hide();
            super.onPostExecute(s);
        }
    }

}