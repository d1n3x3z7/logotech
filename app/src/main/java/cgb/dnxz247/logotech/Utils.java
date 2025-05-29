package cgb.dnxz247.logotech;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import cgb.dnxz247.logotech.games.GameActivity;
import cgb.dnxz247.logotech.menus.MenuActivity;

public class Utils {

    public static void goToActivityExtra(MenuActivity caller, Context from, Class<?> to, String extraString) {
        Intent i = new Intent(from, to);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i.putExtra("mode", extraString);
        ((AppCompatActivity)caller).startActivity(i, caller.getSIS());
        ((AppCompatActivity)caller).overridePendingTransition(0,0);
    }

    public static void goToActivityExtra(GameActivity caller, Context from, Class<?> to, String extraString) {
        Intent i = new Intent(from, to);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i.putExtra("mode", extraString);
        ((AppCompatActivity)caller).startActivity(i, caller.getSIS());
        ((AppCompatActivity)caller).overridePendingTransition(0,0);
    }

    public static void goToActivity(MenuActivity caller, Context from, Class<?> to) {
        Intent i = new Intent(from, to);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        ((AppCompatActivity)caller).startActivity(i, caller.getSIS());
        ((AppCompatActivity)caller).overridePendingTransition(0,0);
    }

    public static void goToActivity(GameActivity caller, Context from, Class<?> to) {
        Intent i = new Intent(from, to);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        ((AppCompatActivity)caller).startActivity(i, caller.getSIS());
        ((AppCompatActivity)caller).overridePendingTransition(0,0);
    }

    public static void backToMain(MenuActivity caller, Context from) {
        goToActivity(caller, from, MainActivity.class);
    }

    public static void backToMain(GameActivity caller, Context from) {
        goToActivity(caller, from, MainActivity.class);
    }
}
