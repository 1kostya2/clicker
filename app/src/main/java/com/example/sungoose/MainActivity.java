package com.example.sungoose;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    String title = "";
    TextView textCounter;
    TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textCounter = findViewById(R.id.text2);
        textTitle = findViewById(R.id.text1);
        textTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    public void tapGoose(View view) {
        counter += 1;
        switch (counter) {
            case 10:
            case 11:
            case 12:
            case 13: title = "ААА, за что?"; textTitle.setTextColor(Color.RED); break;
            case 21:
            case 22:
            case 23: title = "Остановись, пожалуйста!"; textTitle.setTextColor(Color.RED); break;
            case 30:
            case 31:
            case 32:
            case 33: title = "Хватит бить меня!"; textTitle.setTextColor(Color.RED); break;
            default: title = "Бей его"; textTitle.setTextColor(Color.BLACK);
    }

        textTitle.setText(title);
        textCounter.setText(String.format("Ударил %d%s", counter, counter % 10 > 1 &&
                counter % 10 < 5 && counter / 10 % 10 != 1 ? " раза" : " раз"));
    }
}