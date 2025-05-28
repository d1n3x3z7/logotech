package cgb.dnxz247.logotech.games;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import cgb.dnxz247.logotech.MainActivity;
import cgb.dnxz247.logotech.R;

public class ThirdGameActivity extends AppCompatActivity {

    HashMap<String, Integer> sounds = new HashMap<>();
    HashMap<String, Integer> images = new HashMap<>();

    String[] available_pairs = new String[]{"l_r", "s_sh"};
    int[] notes = new int[]{R.id.note1, R.id.note2};

    String mode;

    Random randomizer;
    SoundPool sp;

    boolean isClickedCorrect = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.game_3);

        randomizer = new Random();

        mode = getIntent().getStringExtra("mode");

        resInit();

        gameInit();

        ImageView exit = findViewById(R.id.toMenu);
        exit.setOnClickListener(v -> {
            sp.autoPause();
            sp.release();
            Intent i = new Intent(ThirdGameActivity.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i, savedInstanceState);
            overridePendingTransition(0,0);
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

    private void resInit() {
        switch (mode) {
            case "random":
            case "s_sh":
                sounds.put("s", R.raw.s);
                sounds.put("sh", R.raw.sh);

                // SH
                images.put("sh_baby", R.drawable.sh_baby);
                images.put("sh_cat", R.drawable.sh_cat);
                images.put("sh_cherry", R.drawable.sh_cherry);
                images.put("sh_cherry2", R.drawable.sh_cherry2);
                images.put("sh_dush", R.drawable.sh_dush);
                images.put("sh_frogg", R.drawable.sh_frogg);
                images.put("sh_frogg2", R.drawable.sh_frogg2);
                images.put("sh_grandma", R.drawable.sh_grandma);
                images.put("sh_grandpa", R.drawable.sh_grandpa);
                images.put("sh_hockey", R.drawable.sh_hockey);
                images.put("sh_horse", R.drawable.sh_horse);
                images.put("sh_kamish", R.drawable.sh_kamish);
                images.put("sh_kasha", R.drawable.sh_kasha);
                images.put("sh_kasha2", R.drawable.sh_kasha2);
                images.put("sh_kashtan", R.drawable.sh_kashtan);
                images.put("sh_katushka", R.drawable.sh_katushka);
                images.put("sh_kuvshin", R.drawable.sh_kuvshin);
                images.put("sh_tower", R.drawable.sh_tower);
                images.put("sh_wallet", R.drawable.sh_wallet);

                // S
                images.put("s_aist", R.drawable.s_aist);
                images.put("s_ananas", R.drawable.s_ananas);
                images.put("s_autobus", R.drawable.s_autobus);
                images.put("s_barsuk", R.drawable.s_barsuk);
                images.put("s_bone", R.drawable.s_bone);
                images.put("s_busi", R.drawable.s_busi);
                images.put("s_busi2", R.drawable.s_busi2);
                images.put("s_cactus", R.drawable.s_cactus);
                images.put("s_campfire", R.drawable.s_campfire);
                images.put("s_coconut", R.drawable.s_coconut);
                images.put("s_coconut2", R.drawable.s_coconut2);
                images.put("s_compas", R.drawable.s_compas);
                images.put("s_cosmos", R.drawable.s_cosmos);
                images.put("s_globus", R.drawable.s_globus);
                images.put("s_gradusnik", R.drawable.s_gradusnik);
                images.put("s_kapusta", R.drawable.s_kapusta);
                images.put("s_kaska", R.drawable.s_kaska);
                images.put("s_kassa", R.drawable.s_kassa);
                images.put("s_kolbasa", R.drawable.s_kolbasa);
                images.put("s_kolyaska", R.drawable.s_kolyaska);
                images.put("s_kolyaska2", R.drawable.s_kolyaska2);
                images.put("s_suit", R.drawable.s_suit);
                images.put("s_wheel", R.drawable.s_wheel);

                if (!mode.equals("random")) break;
            case "l_r":
                sounds.put("l", R.raw.l);
                sounds.put("r", R.raw.r);

                // L
                images.put("l_angel", R.drawable.l_angel);
                images.put("l_angel2", R.drawable.l_angel2);
                images.put("l_baklazhan", R.drawable.l_baklazhan);
                images.put("l_baklazhan2", R.drawable.l_baklazhan2);
                images.put("l_bokal", R.drawable.l_bokal);
                images.put("l_bottle", R.drawable.l_bottle);
                images.put("l_bulavka", R.drawable.l_bulavka);
                images.put("l_eye", R.drawable.l_eye);
                images.put("l_flag", R.drawable.l_flag);
                images.put("l_hlopushka", R.drawable.l_hlopushka);
                images.put("l_shark", R.drawable.l_shark);
                images.put("l_shkatulka", R.drawable.l_shkatulka);
                images.put("l_smile", R.drawable.l_smile);
                images.put("l_table", R.drawable.l_table);
                images.put("l_torch", R.drawable.l_torch);
                images.put("l_veshalka", R.drawable.l_veshalka);
                images.put("l_vilka", R.drawable.l_vilka);
                images.put("l_wolf", R.drawable.l_wolf);
                images.put("l_yula", R.drawable.l_yula);

                // R
                images.put("r_arbuz", R.drawable.r_arbuz);
                images.put("r_arpha", R.drawable.r_arpha);
                images.put("r_arpha2", R.drawable.r_arpha2);
                images.put("r_basket", R.drawable.r_basket);
                images.put("r_beans", R.drawable.r_beans);
                images.put("r_brick", R.drawable.r_brick);
                images.put("r_dragon", R.drawable.r_dragon);
                images.put("r_fence", R.drawable.r_fence);
                images.put("r_giraffe", R.drawable.r_giraffe);
                images.put("r_gora", R.drawable.r_gora);
                images.put("r_grusha", R.drawable.r_grusha);
                images.put("r_guitar", R.drawable.r_guitar);
                images.put("r_helicopter", R.drawable.r_helicopter);
                images.put("r_helicopter2", R.drawable.r_helicopter2);
                images.put("r_kenguru", R.drawable.r_kenguru);
                images.put("r_kenguru2", R.drawable.r_kenguru2);
                images.put("r_komar", R.drawable.r_komar);
                images.put("r_komar2", R.drawable.r_komar2);
                images.put("r_road", R.drawable.r_road);
                images.put("r_road2", R.drawable.r_road2);
                images.put("r_square", R.drawable.r_square);
                images.put("r_termometr", R.drawable.r_termometr);
                images.put("r_veer", R.drawable.r_veer);
                images.put("r_zebra", R.drawable.r_zebra);
                images.put("r_zebra2", R.drawable.r_zebra2);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void gameInit() {
        isClickedCorrect = false;

        sp = new SoundPool.Builder().build();
        int correct_sound = sp.load(getApplicationContext(), R.raw.correct, 1);
        int fail_sound = sp.load(getApplicationContext(), R.raw.fail, 1);

        String[] selected_pair = mode.equals("random") ?
                available_pairs[randomizer.nextInt(available_pairs.length)].split("_") : mode.split("_");

        int rnd_char_i = randomizer.nextInt(selected_pair.length);
        String correct_char = selected_pair[rnd_char_i];
        String incorrect_char = selected_pair[selected_pair.length-1-rnd_char_i];

        Object[] imgs = images.keySet().stream().filter(i -> i.split("_")[0].equals(correct_char)).toArray();
        String selected_image = (String) imgs[randomizer.nextInt(imgs.length)];

        int correct_note_id = randomizer.nextInt(notes.length);

        ImageView correct_note = findViewById(notes[correct_note_id]);
        int sound_for_image = sp.load(getApplicationContext(), sounds.get(correct_char), 1);
        correct_note.setOnClickListener(v -> {
            sp.autoPause();
            sp.play(sound_for_image, 1, 1, 1,0,1);
            isClickedCorrect = true;
        });

        ImageView incorrect_note = findViewById(notes[1-correct_note_id]);
        int incorrect_sound = sp.load(getApplicationContext(), sounds.get(incorrect_char), 1);
        incorrect_note.setOnClickListener(v -> {
            sp.autoPause();
            sp.play(incorrect_sound, 1, 1, 1, 0, 1);
            isClickedCorrect = false;
        });

        ImageView main_image = findViewById(R.id.ImageView);
        main_image.setImageDrawable(getDrawable(images.get(selected_image)));
        main_image.setOnClickListener(v -> {
            if (isClickedCorrect) {
                sp.autoPause();
                main_image.setClickable(false);
                sp.play(correct_sound, 1, 1, 1,0,1);
                new Handler().postDelayed(() -> {
                    sp.release();
                    main_image.setClickable(true);
                    gameInit();
                }, 1000);
            } else {
                sp.autoPause();
                main_image.setClickable(false);
                sp.play(fail_sound, 1, 1, 1,0,1);
                new Handler().postDelayed(() -> {
                    sp.release();
                    main_image.setClickable(true);
                    gameInit();
                }, 1000);
            }
        });
    }
}
