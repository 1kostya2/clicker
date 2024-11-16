package com.example.sungoose;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    String title = "";
    String name = "Ударь Бебруда";
    TextView textCounter;
    TextView textTitle;
    TextView textName;

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
        textName = findViewById(R.id.text3);
        textTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textName.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    public void tapRUD(View view) {
        counter += 1;
        switch (counter) {
            case 10:
            case 11:
            case 12:
            case 13: title = "-ААА, за что?"; textTitle.setTextColor(Color.YELLOW); break;
            case 21:
            case 22:
            case 23: title = "-Остановись, пожалуйста!"; textTitle.setTextColor(Color.GREEN); break;
            case 30:
            case 31:
            case 32:
            case 33: title = "-Хватит бить меня!"; textTitle.setTextColor(Color.RED); break;
            case 50:
            case 51:
            case 52: title = "-Да хватит!"; textTitle.setTextColor(Color.RED); break;
            case 100:
            case 101: title = "-Ты не устал?"; textTitle.setTextColor(Color.RED); break;
            case 200:
            case 201: title = "-Отстань!"; textTitle.setTextColor(Color.RED); break;
            case 313: title = "ВЛ"; textTitle.setTextColor(Color.GREEN); break;
            case 432: title = "GY432"; textTitle.setTextColor(Color.GREEN); break;
            case 1:   name = "Играй";  textName.setTextColor(Color.BLUE); break;
            default: title = "Бей его"; textTitle.setTextColor(Color.BLACK);
    }

        textTitle.setText(title);
        textName.setText(name);
        textCounter.setText(String.format("Ударил %d%s", counter, counter % 10 > 1 &&
                counter % 10 < 5 && counter / 10 % 10 != 1 ? " раза" : " раз"));
    }
}