import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
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

        Board board = new Board();

        Node node = board.getChildren().get(0);
        node.setOnSwipeDown(se -> board.movedUp());

        Group root = new Group(); //root for all the children nodes to be added to the scene
        root.getChildren().addAll(board);

        final int WIDTH = 503;
        final int HEIGHT = 503;
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        window.setScene(scene);
        scene.getStylesheets().add("stylesheet.css"); //adds the styles in stylesheet.css to game

        scene.setOnKeyPressed(ke -> board.moved(ke));

        board.setOnSwipeUp(se -> board.movedUp());
        board.setOnSwipeDown(se -> board.movedDown());
        board.setOnSwipeLeft(se -> board.movedLeft());
        board.setOnSwipeRight(se -> board.movedRight());


        window.setTitle("2048 | Java");

        window.setResizable(false);

        window.show();
    }
}
