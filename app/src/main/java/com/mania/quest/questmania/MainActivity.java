package com.mania.quest.questmania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onQuestsClick(View view){
        Intent intent = new Intent(this, QuestProgressActivity.class);
        startActivity(intent);
    }

    public void onAwardsClick(View view){
        Intent intent = new Intent(this, AwardsActivity.class);
        startActivity(intent);
    }

    public void onSettingsActiity(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
