/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radioplayer;

import javafx.application.Application;
import java.awt.*;
import javafx.stage.Stage;
/**
 *
 * @author alex
 */
public class Splash extends Application{
    
    public static void main(final String[] args) {
        SplashScreen splash = SplashScreen.getSplashScreen();
        try {
            Thread.sleep(3000L);
        }
        catch (InterruptedException ex) {
            ex.getMessage();
        }
        if (splash != null) {
            splash.close();
            Application.launch(RadioPlayer.class, args);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
