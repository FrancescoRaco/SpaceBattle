package it.insidecode.racogame;

import it.insidecode.racogame.framework.core.Core;
import it.insidecode.spacetagger.SpaceTagger;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = true;
        initialize(new SpaceTagger(Core.getLevel()), cfg);
    }
}