package cgb.dnxz247.logotech.menus;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import cgb.dnxz247.logotech.R;
import cgb.dnxz247.logotech.Utils;
import cgb.dnxz247.logotech.games.SecondGameActivity;

public class SecondMenuActivity extends AppCompatActivity implements MenuActivity {

    Bundle sis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.game_2_menu);

        sis = savedInstanceState;

        ImageView game_Random = findViewById(R.id.toGameRandom);
        game_Random.setOnClickListener(v -> goToGame("random"));

        ImageView game_S = findViewById(R.id.toGame_S);
        game_S.setOnClickListener(v -> goToGame("s"));

        ImageView game_SH = findViewById(R.id.toGame_SH);
        game_SH.setOnClickListener(v -> goToGame("sh"));

        ImageView game_L = findViewById(R.id.toGame_L);
        game_L.setOnClickListener(v -> goToGame("l"));

        ImageView game_R = findViewById(R.id.toGame_R);
        game_R.setOnClickListener(v -> goToGame("r"));

        ImageView back = findViewById(R.id.toMenu);
        back.setOnClickListener(v -> backToMain());
    }

    @Override
    public Bundle getSIS() {
        return sis;
    }

    public void goToGame(String mode) {
        Utils.goToActivityExtra(this, SecondMenuActivity.this, SecondGameActivity.class, mode);
    }

    public void backToMain() {
        Utils.backToMain(this, SecondMenuActivity.this);
    }
}