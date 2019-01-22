package net.englishexplore.scenes;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.align.HorizontalAlign;

public class SplashScene extends BaseScene {

    @Override
    public void createScene() {

        Sprite splash = new Sprite((SCREEN_WIDTH) / 2, (SCREEN_HEIGHT) / 2, mResourceManager.mSplashTextureRegion, mVertexBufferObjectManager) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        splash.setSize(800, 800);
        attachChild(splash);

        Text copyrightText = new Text(0, 0, mResourceManager.mFont, "(c) 2011-2014",
                new TextOptions(HorizontalAlign.LEFT), mVertexBufferObjectManager);
        copyrightText.setPosition(SCREEN_WIDTH - copyrightText.getWidth()-5, SCREEN_HEIGHT - copyrightText.getHeight()-5);
        attachChild(copyrightText);
    }

    @Override
    public void onBackKeyPressed() {
        mActivity.finish();
    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return SceneManager.SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene() {
    }

}