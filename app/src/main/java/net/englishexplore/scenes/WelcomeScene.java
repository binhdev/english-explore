package net.englishexplore.scenes;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.TouchEvent;

public class WelcomeScene extends BaseScene implements IOnSceneTouchListener {

    private Sprite mGiftBox;

    private AnimatedSprite mPrince;
    private AnimatedSprite mPrincess;
    private AnimatedSprite mAngel;

    private AnimatedSprite mGiftBoxVocabulary;
    private AnimatedSprite mGiftBoxCulture;

    /* Background */
    private SpriteBackground mBackground;
    private Sprite mBackgroundTree;
    private Sprite mBackgroundFlower;

    @Override
    public void createScene() {
        mEngine.registerUpdateHandler(new FPSLogger());

        setOnSceneTouchListener(this);

        //TODO create entities
        Sprite background = new Sprite((SCREEN_WIDTH) / 2, (SCREEN_HEIGHT) / 2, mResourceManager.mWelcomeBgTextureRegion,
                mVertexBufferObjectManager);

        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        SpriteBackground spriteBackground = new SpriteBackground(background);
        setBackground(spriteBackground);

        Sprite bgTree = new Sprite((SCREEN_WIDTH) / 2, (SCREEN_HEIGHT) / 2, mResourceManager.mWelcomeBgTreeTextureRegion,
                mVertexBufferObjectManager);
        bgTree.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        attachChild(bgTree);
        bgTree.setZIndex(2);

        Sprite bgFlower = new Sprite((SCREEN_WIDTH) / 2, 261 / 2, mResourceManager.mWelcomeBgFlowerTextureRegion,
                mVertexBufferObjectManager);
        bgFlower.setSize(SCREEN_WIDTH, 261);
        attachChild(bgFlower);
        bgTree.setZIndex(3);
        final float birdX = 320;
        final float birdY = 320;

        mAngel = new AnimatedSprite(birdX, birdY, mResourceManager.mAngleTextureRegion, mVertexBufferObjectManager);
        mAngel.setPosition(500, SCREEN_HEIGHT - 500);
        mAngel.setZIndex(10);
        mAngel.setSize(320, 320);
        mAngel.animate(100);

        attachChild(mAngel);

        /* The actual collision-checking. */
        registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void reset() {}

            @Override
            public void onUpdate(float pSecondsElapsed) {

                //TODO implement
            }
        });

        if(!mResourceManager.mMusic.isPlaying()){
            mResourceManager.mMusic.play();
        }
    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        //TODO implement
        return false;
    }

    @Override
    public void onBackKeyPressed() {
        mSceneManager.setScene(SceneManager.SceneType.SCENE_MENU);
    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return SceneManager.SceneType.SCENE_WELCOME;
    }

    @Override
    public void disposeScene() {
        //TODO
    }

}