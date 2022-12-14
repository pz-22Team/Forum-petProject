package com.forum.user.app;

import com.forum.user.alerts.MyAlert;
import com.forum.user.controllers.util.SwitchScenes;
import com.forum.user.db.manager.DBManager;
import com.forum.user.exceptions.DataBaseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.forum.user.logger.MyLogger;

public class UserApplication extends Application {
    public static final String LOGIN_SCENE_TITLE = "Log in";
    public static final String SIGNUP_SCENE_TITLE = "Sign up";
    public static final String MAIN_SCENE_TITLE = "Forum(client)";
    public static final String PROFILE_SCENE_TITLE = "Profile";

    public static final String LOGIN_SCENE_PATH = "login.fxml";
    public static final String MAIN_SCENE_PATH = "mainScene.fxml";
    public static final String SIGNUP_SCENE_PATH = "signUp.fxml";
    public static final String PROFILE_SCENE_PATH = "profile-view.fxml";
    public static final String DATABASE_CONNECTION_SCENE_PATH = "database-connectionScene.fxml";

    public static final String ICON_PATH = "userIcon.png";
    public static final String HIDE_ICON_PATH = "hide.png";
    public static final String UNHIDE_ICON_PATH = "unhide.png";

    private final MyAlert alert = new MyAlert(MAIN_SCENE_TITLE);
    private final SwitchScenes switchScenes = new SwitchScenes();
    //private static final Logger com.forum.user.logger = LogManager.getLogger();
    private static final MyLogger logger = new MyLogger();

    private boolean connectionFailed = false;

    @Override
    public void init() {
        //com.forum.user.logger.info("Initialise");
        logger.log(MyLogger.INFO, "Initialise");
        logger.log(MyLogger.INFO,"Database connection check start");
        checkConnection();
        logger.log(MyLogger.INFO,"Database connection check end");
    }

    @Override
    public void start(Stage stage) throws Exception {
        logger.log(MyLogger.INFO,"Start application");
        logger.log(MyLogger.INFO,"Connection established = " + !connectionFailed);
        if(connectionFailed) {
            alert.show(MyAlert.ERROR, "Error", "Database connection failure! Please try later)");
            System.exit(0);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(UserApplication.class.getResource(LOGIN_SCENE_PATH));
        Image img = new Image(ICON_PATH);
        stage.getIcons().add(img);
        stage.setTitle(MAIN_SCENE_TITLE);
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", MyPreloader.class.getCanonicalName());
        launch(args);
    }

    private void checkConnection() {
        try {
            DBManager.getInstance();
        } catch (DataBaseException e) {
            connectionFailed = true;
            logger.log(MyLogger.ERROR, "Database connection failed");
        }
    }
}