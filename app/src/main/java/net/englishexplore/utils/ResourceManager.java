package net.englishexplore.utils;

import android.graphics.Color;
import android.graphics.Typeface;

import net.englishexplore.GameActivity;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.util.debug.Debug;

import java.io.IOException;

public class ResourceManager {

    private static final ResourceManager instance = new ResourceManager();

    public GameActivity mActivity;

    /* Splash Resource */
    private BitmapTextureAtlas mSplashTextureAtlas;
    public ITextureRegion mSplashTextureRegion;

    /* Welcome Resource */
    private BitmapTextureAtlas mWelcomeBgTextureAtlas;
    public ITextureRegion mWelcomeBgTextureRegion;

    private BitmapTextureAtlas mWelcomeBgTreeTextureAtlas;
    public ITextureRegion mWelcomeBgTreeTextureRegion;

    private BitmapTextureAtlas mWelcomeBgFlowerTextureAtlas;
    public ITextureRegion mWelcomeBgFlowerTextureRegion;

    private BitmapTextureAtlas mAngleTextureAtlas;
    public ITiledTextureRegion mAngleTextureRegion;

    /* Font Resource*/
    public Font mFont;

    /* Sound Resource */
    public Sound mSound;
    public Music mMusic;

    private ResourceManager() {}

    public static ResourceManager getInstance() {
        return instance;
    }

    public void prepare(GameActivity activity) {
        instance.mActivity = activity;
    }

    public void loadSplashResources() {
        //TODO implement
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/splash/");
        mSplashTextureAtlas = new BitmapTextureAtlas(mActivity.getTextureManager(), 512, 512, TextureOptions.BILINEAR);
        mSplashTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSplashTextureAtlas,
                mActivity, "logo.png", 0, 0);
        mSplashTextureAtlas.load();

        mFont = FontFactory.create(mActivity.getFontManager(), mActivity.getTextureManager(), 256, 256,
                Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 10, Color.GRAY);
        mFont.load();
    }

    public void unloadSplashResources() {
        //TODO implement
        mSplashTextureAtlas.unload();
        mSplashTextureRegion = null;

        mFont.unload();
        mFont = null;
    }

    public void loadWelcomeResources() {
        //TODO implement
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/welcome/");
        mWelcomeBgTextureAtlas = new BitmapTextureAtlas(mActivity.getTextureManager(), 2560, 1440, TextureOptions.BILINEAR);
        mWelcomeBgTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mWelcomeBgTextureAtlas,
                mActivity, "bg_1.png", 0, 0);

        mWelcomeBgTreeTextureAtlas = new BitmapTextureAtlas(mActivity.getTextureManager(), 2560, 1440, TextureOptions.BILINEAR);
        mWelcomeBgTreeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mWelcomeBgTreeTextureAtlas,
                mActivity, "bg_2.png", 0, 0);

        mWelcomeBgFlowerTextureAtlas = new BitmapTextureAtlas(mActivity.getTextureManager(), 2560, 261, TextureOptions.BILINEAR);
        mWelcomeBgFlowerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mWelcomeBgFlowerTextureAtlas,
                mActivity, "bg_3.png", 0, 0);

        mAngleTextureAtlas = new BitmapTextureAtlas(mActivity.getTextureManager(), 2028, 196, TextureOptions.BILINEAR);
        mAngleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mAngleTextureAtlas, mActivity, "angel.png", 0, 0, 12, 1);

        mWelcomeBgTextureAtlas.load();
        mWelcomeBgTreeTextureAtlas.load();
        mWelcomeBgFlowerTextureAtlas.load();
        mAngleTextureAtlas.load();

        SoundFactory.setAssetBasePath("mfx/");
        try {
            mSound = SoundFactory.createSoundFromAsset(mActivity.getEngine().getSoundManager(), mActivity, "game_over.ogg");
        } catch (final IOException e) {
            Debug.e(e);
        }

        MusicFactory.setAssetBasePath("mfx/");
        try {
            mMusic = MusicFactory.createMusicFromAsset(mActivity.getEngine().getMusicManager(), mActivity, "music_background.ogg");
            mMusic.setLooping(true);
        } catch (final IOException e) {
            Debug.e(e);
        }
    }

    public void unloadWelcomeResources() {
        //TODO implement
        mWelcomeBgTextureAtlas.unload();
        mWelcomeBgTextureAtlas = null;
        mWelcomeBgTreeTextureAtlas.unload();
        mWelcomeBgTreeTextureAtlas = null;
        mWelcomeBgFlowerTextureAtlas.unload();
        mWelcomeBgFlowerTextureAtlas = null;
    }

    public void loadGameResources() {
    }

    public void unloadGameResources() {
        //TODO implement
        mSound.release();
        mSound = null;

        mMusic.stop();
        mMusic.release();
        mMusic = null;
    }

}