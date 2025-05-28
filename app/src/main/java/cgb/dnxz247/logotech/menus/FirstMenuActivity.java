package cgb.dnxz247.logotech.menus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import cgb.dnxz247.logotech.MainActivity;
import cgb.dnxz247.logotech.R;
import cgb.dnxz247.logotech.games.FirstGameActivity;

public class FirstMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.game_1_menu);

        ImageView game_Random = findViewById(R.id.toGameRandom);
        game_Random.setOnClickListener(v -> {
            Intent i = new Intent(FirstMenuActivity.this, FirstGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "random");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView game_S = findViewById(R.id.toGame_S);
        game_S.setOnClickListener(v -> {
            Intent i = new Intent(FirstMenuActivity.this, FirstGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "s");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView game_SH = findViewById(R.id.toGame_SH);
        game_SH.setOnClickListener(v -> {
            Intent i = new Intent(FirstMenuActivity.this, FirstGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "sh");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView game_L = findViewById(R.id.toGame_L);
        game_L.setOnClickListener(v -> {
            Intent i = new Intent(FirstMenuActivity.this, FirstGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "l");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView game_R = findViewById(R.id.toGame_R);
        game_R.setOnClickListener(v -> {
            Intent i = new Intent(FirstMenuActivity.this, FirstGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "r");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView back = findViewById(R.id.toMenu);
        back.setOnClickListener(v -> {
            Intent i = new Intent(FirstMenuActivity.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });
    }
}