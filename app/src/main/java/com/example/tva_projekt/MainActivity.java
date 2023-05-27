package com.example.tva_projekt;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tva_projekt.enterActivity.EnterActivity;

public class MainActivity extends AppCompatActivity {
    private Button loginPageButton;
    private Button registerPageButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPageButton = findViewById(R.id.loginPage);
        registerPageButton = findViewById(R.id.registerPage);
        logoutButton = findViewById(R.id.logoutButton);

        updateUI();

        // Set the click listener for the logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
    }

    private void updateUI() {
        boolean isLoggedIn = isLoggedIn();

        if (isLoggedIn) {
            String username = getUsername();
            // User is logged in, show username and logout button
            loginPageButton.setVisibility(View.GONE);
            registerPageButton.setVisibility(View.GONE);
            logoutButton.setVisibility(View.VISIBLE);
            logoutButton.setText(getString(R.string.log_out) + " (" + username + ")");
        } else {
            // User is not logged in, show login and register buttons
            loginPageButton.setVisibility(View.VISIBLE);
            registerPageButton.setVisibility(View.VISIBLE);
            logoutButton.setVisibility(View.GONE);
        }
    }

        //Prvo se kreira objekt v tem primeri appUser - sedaj so ntor ročno vnešeni podatki
        //ob registraciji se bodo potem uporabili podatki iz obrazca
        /*
        AppUser appUser = new AppUser(
                "test",
                "test",
                "test@gmail.com",
                "test",
                22
        );
        //tukaj spodaj vse convertira objekt v json obliko da se lahko pošlje
        Gson gson = new Gson();
        String jsonAppUser = gson.toJson(appUser);
        RetrofitService retrofitService = ApiClient.getRetrofit().create(RetrofitService.class);
        Call<AppUser> registerUser = retrofitService.registerUser(appUser);
        registerUser.enqueue(new Callback<AppUser>() {
            //če je vse vredu se vrne response
            @Override
            public void onResponse(Call<AppUser> call, Response<AppUser> response) {
                if(response.body() != null) {
                    AppUser responseFromAPI = response.body();
                    String responseString = "Response:" + responseFromAPI.getResponse();
                    Log.d("Pretty Printed JSON :", responseString);
                } else {
                    Log.d("Null", "Response: " + response.body());
                }
            }
            //če pride do napake v requestu nam tukaj vrže error
            @Override
            public void onFailure(Call<AppUser> call, Throwable t) {
                Log.v("Error", "Response: " + t);
            }
        });
        */

    //ob kliku na Enter Activity preusmeri na aktivnost Enter Activity
    public void enterActivity(View view) {
        Intent intent = new Intent(MainActivity.this, EnterActivity.class);
        startActivity(intent);
    }
    public void chooseActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
        startActivity(intent);
    }

    public void historyActivity(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    public void registerActivity(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    public void loginActivity(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void logoutUser() {
        clearSharedPreferences();
        updateUI();
        Log.d("Shared Preferences", "Cleared");
    }

    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    private String getUsername() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        return sharedPreferences.getString("username", "");
    }

    private void clearSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

};