package com.pierre.pierreboudonexercice4gson;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pierre.pierreboudonexercice4gson.Classes.User;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView loginTV;
    TextView idTV;
    TextView avatar_urlTV;
    TextView urlTV;
    TextView html_urlTV;
    TextView gists_urlTV;
    TextView typeTV;
    TextView public_reposTV;
    TextView created_atTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTV = (TextView)findViewById(R.id.loginTextView);
        idTV = (TextView)findViewById(R.id.idTextView);
        avatar_urlTV = (TextView)findViewById(R.id.avatar_urlTextView);
        urlTV = (TextView)findViewById(R.id.urlTextView);
        html_urlTV = (TextView)findViewById(R.id.html_urlTextView);
        gists_urlTV = (TextView)findViewById(R.id.gists_urlTextView);
        typeTV = (TextView)findViewById(R.id.typeTextView);
        public_reposTV = (TextView)findViewById(R.id.public_reposTextView);
        created_atTV = (TextView)findViewById(R.id.created_atTextView);

        final EditText githubUser = (EditText)findViewById(R.id.githubUserEditText);
        Button searchBtn = (Button)findViewById(R.id.searchBtn);

        if (searchBtn != null) {
            searchBtn.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    OkHttpClient okhttpClient = new OkHttpClient();
                    Request myGetRequest = new Request.Builder()
                            .url("https://api.github.com/users/" + githubUser.getText())
                            .build();

                    okhttpClient.newCall(myGetRequest).enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            final String text = response.body().string();
                            final int statusCode = response.code();

                            Gson gson = new Gson();
                            final User user = gson.fromJson(text, User.class);

                                /*MainActivity.this.*/runOnUiThread(new Runnable() {
                                public void run() {
                                    loginTV.setText("Login: " + user.getLogin());
                                    idTV.setText("ID: " + user.getId());
                                    avatar_urlTV.setText("Avatar URL: " + user.getAvatar_url());
                                    urlTV.setText("URL: " + user.getUrl());
                                    html_urlTV.setText("HTML URL: " + user.getHtml_url());
                                    gists_urlTV.setText("Gists URL: " + user.getGists_url());
                                    typeTV.setText("Type: " + user.getType());
                                    public_reposTV.setText("Public Repos: " + user.getPublic_repos());
                                    created_atTV.setText("Created At: " + user.getCreated_at());
                                }
                            });
                        }

                        @Override
                        public void onFailure(Call call, IOException e) {
                        }
                    });
                }
            });
        }


    }
}
