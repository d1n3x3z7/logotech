package cgb.dnxz247.logotech;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import cgb.dnxz247.logotech.menus.FirstMenuActivity;
import cgb.dnxz247.logotech.menus.SecondMenuActivity;
import cgb.dnxz247.logotech.menus.ThirdMenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView menu_button_to_Game1_menu = findViewById(R.id.minigame_1);
        menu_button_to_Game1_menu.setOnClickListener(v -> {
            Intent x = new Intent(MainActivity.this, FirstMenuActivity.class);
            x.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(x, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView menu_button_to_Game2_menu = findViewById(R.id.minigame_2);
        menu_button_to_Game2_menu.setOnClickListener(v -> {
            Intent x = new Intent(MainActivity.this, SecondMenuActivity.class);
            x.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(x, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView menu_button_to_Game3_menu = findViewById(R.id.minigame_3);
        menu_button_to_Game3_menu.setOnClickListener(v -> {
            Intent x = new Intent(MainActivity.this, ThirdMenuActivity.class);
            x.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(x, savedInstanceState);
            overridePendingTransition(0,0);
        });
    }
}