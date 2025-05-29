package cgb.dnxz247.logotech.games;

import android.annotation.SuppressLint;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Random;

import cgb.dnxz247.logotech.R;
import cgb.dnxz247.logotech.Utils;

public class FirstGameActivity extends AppCompatActivity implements GameActivity {
    int[] notesViews = new int[] {R.id.note_1, R.id.note_2, R.id.note_3, R.id.note_4, R.id.note_5, R.id.note_6};

    HashMap<String, Integer> images = new HashMap<>();
    HashMap<String, Integer> sounds = new HashMap<>();

    private String mode;

    Random randomizer;

    SoundPool sp;

    Bundle sis;

    boolean isClickedCorrect = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.game_1);

        sis = savedInstanceState;

        randomizer = new Random();

        mode = getIntent().getStringExtra("mode");

        resInit();

        gameInit();

        ImageView exit = findViewById(R.id.toMenu);
        exit.setOnClickListener(v -> {
            sp.autoPause();
            sp.release();
            Utils.backToMain(this, FirstGameActivity.this);
        });
    }

    public void onWindowFocusChanged(boolean focused) {
        if (!focused) return;
        int opts = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

        getWindow().getDecorView().setSystemUiVisibility(opts);

        try {
            getActionBar().hide();
            getSupportActionBar().hide();
        } catch (NullPointerException ignored) {}
    }

    @Override
    public Bundle getSIS() {
        return sis;
    }

    public void resInit() {

        switch (mode) {
            case "random":
            case "s":
                images.put("s_nasos", R.drawable.s_nasos);
                if (!mode.equals("random")) break;
            case "sh":
                images.put("sh_snake", R.drawable.sh_snake);
                if (!mode.equals("random")) break;
            case "l":
                images.put("l_ship", R.drawable.l_ship);
                if (!mode.equals("random")) break;
            case "r":
                images.put("r_tiger", R.drawable.r_tiger);
                if (!mode.equals("random")) break;
        }

        sounds.put("ch", R.raw.ch);
        sounds.put("f", R.raw.f);
        sounds.put("h", R.raw.h);
        sounds.put("l", R.raw.l);
        sounds.put("n", R.raw.n);
        sounds.put("p", R.raw.p);
        sounds.put("r", R.raw.r);
        sounds.put("s", R.raw.s);
        sounds.put("sch", R.raw.sch);
        sounds.put("sh", R.raw.sh);
        sounds.put("t", R.raw.t);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void gameInit() {
        isClickedCorrect = false;

        sp = new SoundPool.Builder().build();
        int correct_sound = sp.load(getApplicationContext(), R.raw.correct, 1);
        int fail_sound = sp.load(getApplicationContext(), R.raw.fail, 1);

        String selected_image;
        int sound;
        String sound_name;
        Object[] filtered;
        if (mode.equals("random")) {
            filtered = images.keySet().stream().filter(s -> s.contains("_")).toArray();
            selected_image = (String) filtered[randomizer.nextInt(filtered.length)];
            sound_name = selected_image.split("_")[0];
        } else {
            filtered = images.keySet().stream().filter(s -> s.contains(mode)).toArray();
            selected_image = (String) filtered[randomizer.nextInt(filtered.length)];
            sound_name = mode;
        }
        sound = sp.load(getApplicationContext(), sounds.get(sound_name), 1);

        int correct_note_ID = randomizer.nextInt(6);

        ImageView correct_note = findViewById(notesViews[correct_note_ID]);
        correct_note.setOnClickListener(v -> {
            isClickedCorrect = true;
            sp.autoPause();
            sp.play(sound, 1, 1, 1, 0 ,1);
        });

        HashMap<String, Integer> sounds_copied = (HashMap<String, Integer>) sounds.clone();
        sounds_copied.remove(sound_name);

        for (int counter = 0; counter != 6; counter++) {
            if (counter == correct_note_ID) continue;
            String selected = (String) sounds_copied.keySet().toArray()[randomizer.nextInt(sounds_copied.size())];
            ImageView note = findViewById(notesViews[counter]);

            int sound_id = sp.load(getApplicationContext(), sounds_copied.get(selected), 1);
            note.setOnClickListener(v -> {
                isClickedCorrect = false;
                sp.autoPause();
                sp.play(sound_id, 1, 1, 1, 0 ,1);
            });
            sounds_copied.remove(selected);
        }

        ImageView img = findViewById(R.id.imageView);
        img.setImageDrawable(getDrawable(images.get(selected_image)));
        img.setOnClickListener(v -> {
            if (isClickedCorrect) {
                sp.autoPause();
                img.setClickable(false);
                sp.play(correct_sound, 1, 1, 1,0,1);
                new Handler().postDelayed(() -> {
                    sp.release();
                    img.setClickable(true);
                    gameInit();
                }, 1000);
            } else {
                sp.autoPause();
                img.setClickable(false);
                sp.play(fail_sound, 1, 1, 1,0,1);
                new Handler().postDelayed(() -> {
                    sp.release();
                    img.setClickable(true);
                    gameInit();
                }, 1000);
            }
        });
    }
}
