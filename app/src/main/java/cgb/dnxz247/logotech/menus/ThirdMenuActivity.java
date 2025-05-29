package cgb.dnxz247.logotech.menus;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import cgb.dnxz247.logotech.R;
import cgb.dnxz247.logotech.Utils;
import cgb.dnxz247.logotech.games.ThirdGameActivity;

public class ThirdMenuActivity extends AppCompatActivity implements MenuActivity {

    Bundle sis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.game_3_menu);

        sis = savedInstanceState;

        ImageView game_Random = findViewById(R.id.toGameRandom);
        game_Random.setOnClickListener(v -> goToGame("random"));

        ImageView game_S_SH = findViewById(R.id.toGame_S_SH);
        game_S_SH.setOnClickListener(v -> goToGame("s_sh"));

        ImageView game_L_R = findViewById(R.id.toGame_L_R);
        game_L_R.setOnClickListener(v -> goToGame("l_r"));

        ImageView back = findViewById(R.id.toMenu);
        back.setOnClickListener(v -> backToMain());
    }

    @Override
    public Bundle getSIS() {
        return sis;
    }

    public void goToGame(String mode) {
        Utils.goToActivityExtra(this, ThirdMenuActivity.this, ThirdGameActivity.class, mode);
    }

    public void backToMain() {
        Utils.backToMain(this, ThirdMenuActivity.this);
    }
}