package net.englishexplore;

import android.widget.Toast;

import net.englishexplore.scenes.SceneManager;
import net.englishexplore.utils.ResourceManager;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.util.FPSLogger;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.io.IOException;

public class GameActivity extends SimpleBaseGameActivity {
    public static final int CAMERA_WIDTH = 2560;
    public static final int CAMERA_HEIGHT = 1440;

    private Camera mCamera;
    private ResourceManager mResourceManager;
    private SceneManager mSceneManager;

    @Override
    protected void onCreateResources() throws IOException {
        mResourceManager = ResourceManager.getInstance();
        mResourceManager.prepare(this);
        mResourceManager.loadSplashResources();

        mSceneManager = SceneManager.getInstance();
    }

    @Override
    protected Scene onCreateScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());
        mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback() {
            public void onTimePassed(final TimerHandler pTimerHandler) {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                mResourceManager.loadWelcomeResources();
                mSceneManager.setScene(SceneManager.SceneType.SCENE_WELCOME);
                mResourceManager.unloadSplashResources();
            }
        }));

        return mSceneManager.createSplashScene();
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

        final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
        engineOptions.getAudioOptions().setNeedsSound(true).setNeedsMusic(true);
        return engineOptions;
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
