package cgb.dnxz247.logotech.menus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import cgb.dnxz247.logotech.MainActivity;
import cgb.dnxz247.logotech.R;
import cgb.dnxz247.logotech.games.ThirdGameActivity;

public class ThirdMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.game_3_menu);

        ImageView game_Random = findViewById(R.id.toGameRandom);
        game_Random.setOnClickListener(v -> {
            Intent i = new Intent(ThirdMenuActivity.this, ThirdGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "random");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView game_S_SH = findViewById(R.id.toGame_S_SH);
        game_S_SH.setOnClickListener(v -> {
            Intent i = new Intent(ThirdMenuActivity.this, ThirdGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "s_sh");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView game_L_R = findViewById(R.id.toGame_L_R);
        game_L_R.setOnClickListener(v -> {
            Intent i = new Intent(ThirdMenuActivity.this, ThirdGameActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            i.putExtra("mode", "l_r");
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });

        ImageView back = findViewById(R.id.toMenu);
        back.setOnClickListener(v -> {
            Intent i = new Intent(ThirdMenuActivity.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
        });
    }
}