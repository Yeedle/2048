import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Program class, where the GUI stuff happens
 * Created by Yeedle on 2/2/2016.
 */
public class Program extends Application{
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage window) throws Exception {


        /* The Stage is the window. The Scene is what happens inside the window. The scene has a child node of type Group called root. */



        Group root = new Group(); //root for all the children nodes to be added to the scene


        Scene scene = new Scene(root, 500, 500);

        window.setScene(scene);
        window.setTitle("2048 | Java");



        window.show();

    }
}
