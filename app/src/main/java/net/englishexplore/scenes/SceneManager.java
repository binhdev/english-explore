package net.englishexplore.scenes;

import net.englishexplore.utils.ResourceManager;

public class SceneManager {

    private static final SceneManager instance = new SceneManager();

    public enum SceneType {SCENE_SPLASH, SCENE_WELCOME, SCENE_VOCABULARY, SCENE_CULTURE, SCENE_MENU, SCENE_GAME}

    private SceneType mCurrentSceneType;
    private BaseScene mCurrentScene;

    private SceneManager() {
    }

    public static SceneManager getInstance() {
        return instance;
    }

    public void setScene(SceneType sceneType) {
        switch (sceneType) {
            case SCENE_WELCOME:
                setScene(createWelcomeScene());
                break;
            case SCENE_MENU:
                setScene(createMenuScene());
                break;
            case SCENE_GAME:
                setScene(createGameScene());
                break;
            case SCENE_SPLASH:
                setScene(createSplashScene());
                break;
        }
    }

    private void setScene(BaseScene scene) {
        ResourceManager.getInstance().mActivity.getEngine().setScene(scene);
        mCurrentScene = scene;
        mCurrentSceneType = scene.getSceneType();
    }

    public SceneType getCurrentSceneType() {
        return mCurrentSceneType;
    }

    public BaseScene getCurrentScene() {
        return mCurrentScene;
    }

    public BaseScene createSplashScene() {
        //TODO implement
        return new SplashScene();
    }

    public BaseScene createWelcomeScene() {
        //TODO implement
        return new WelcomeScene();
    }

    private BaseScene createMenuScene() {
        //TODO implement
        return null;
    }

    private BaseScene createGameScene() {
        //TODO implement
        return new GameScene();
    }

}