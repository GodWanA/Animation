package animation;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Csernay Attila
 */
public class Animation extends Application {

    @Override
    public void start(Stage stage) {
        Rectangle negyzet = new Rectangle(100, 100);
        negyzet.setFill(Color.DARKORANGE);

        RotateTransition forgatasTransition = new RotateTransition();
        forgatasTransition.setDuration(Duration.millis(1000));
        forgatasTransition.setNode(negyzet);
        forgatasTransition.setByAngle(360);
        forgatasTransition.setCycleCount(50);
        forgatasTransition.setAutoReverse(false);

        ScaleTransition nagyitastransition = new ScaleTransition();
        nagyitastransition.setDuration(Duration.millis(1000));
        nagyitastransition.setNode(negyzet);
        nagyitastransition.setByY(1.5);
        nagyitastransition.setByX(1.5);
        nagyitastransition.setCycleCount(50);
        nagyitastransition.setAutoReverse(false);

        RotateTransition forgatasTransition2 = new RotateTransition();
        forgatasTransition2.setDuration(Duration.millis(1000));
        forgatasTransition2.setNode(negyzet);
        forgatasTransition2.setByAngle(360);
        forgatasTransition2.setCycleCount(50);
        forgatasTransition2.setAutoReverse(false);

        ScaleTransition nagyitastransition2 = new ScaleTransition();
        nagyitastransition2.setDuration(Duration.millis(1000));
        nagyitastransition2.setNode(negyzet);
        nagyitastransition2.setByY(1.5);
        nagyitastransition2.setByX(1.5);
        nagyitastransition2.setCycleCount(50);
        nagyitastransition2.setAutoReverse(false);

        TranslateTransition mozgatasTransition = new TranslateTransition();
        mozgatasTransition.setDuration(Duration.millis(1000));
        mozgatasTransition.setNode(negyzet);
        mozgatasTransition.setByX(300);
        mozgatasTransition.setCycleCount(50);
        mozgatasTransition.setAutoReverse(false);

        SequentialTransition szekvencialis = new SequentialTransition(negyzet, forgatasTransition2, nagyitastransition2);
        ParallelTransition parhuzamos = new ParallelTransition(negyzet, forgatasTransition2, nagyitastransition2);

        ComboBox cb_anim = new ComboBox();
        cb_anim.getItems().addAll("Forgatas", "Nagyítas", "Mozgatas", "Szekvencialis az elso harombol", "Parhuzamos animacio az elso harombol");
        cb_anim.setOnAction((event) -> {
            int i = cb_anim.getSelectionModel().getSelectedIndex();
            switch (i) {
                case 0:
                    forgatasTransition.playFromStart();
                    nagyitastransition.stop();
                    mozgatasTransition.stop();
                    szekvencialis.stop();
                    parhuzamos.stop();
                    break;
                case 1:
                    forgatasTransition.stop();
                    nagyitastransition.playFromStart();
                    mozgatasTransition.stop();
                    szekvencialis.stop();
                    parhuzamos.stop();
                    break;
                case 2:
                    forgatasTransition.stop();
                    nagyitastransition.stop();
                    mozgatasTransition.playFromStart();
                    szekvencialis.stop();
                    parhuzamos.stop();
                    break;
                case 3:
                    forgatasTransition.stop();
                    nagyitastransition.stop();
                    mozgatasTransition.stop();
                    szekvencialis.playFromStart();
                    parhuzamos.stop();
                    break;
                case 4:
                    forgatasTransition.stop();
                    nagyitastransition.stop();
                    mozgatasTransition.stop();
                    szekvencialis.stop();
                    parhuzamos.playFromStart();
                    break;
            }
        });
        //cb_anim.getSelectionModel().select(0);

        Button button_m = new Button("Megallit");
        button_m.setOnAction((ActionEvent e) -> {
            int i = cb_anim.getSelectionModel().getSelectedIndex();
            switch (i) {
                case 0:
                    forgatasTransition.stop();
                    break;
                case 1:
                    nagyitastransition.stop();
                    break;
                case 2:
                    mozgatasTransition.stop();
                    break;
                case 3:
                    szekvencialis.stop();
                    break;
                case 4:
                    parhuzamos.stop();
                    break;
            }
        });

        Button button_l = new Button("Folytat");
        button_l.setOnAction((ActionEvent e) -> {
            int i = cb_anim.getSelectionModel().getSelectedIndex();
            switch (i) {
                case 0:
                    forgatasTransition.play();
                    break;
                case 1:
                    nagyitastransition.play();
                    break;
                case 2:
                    mozgatasTransition.play();
                    break;
                case 3:
                    szekvencialis.play();
                    break;
                case 4:
                    parhuzamos.play();
                    break;
            }
        });

        HBox hbox = new HBox(cb_anim, button_m, button_l);
        hbox.setPadding(new Insets(5, 5, 200, 5));
        VBox vbox = new VBox(hbox, negyzet);
        vbox.setPadding(new Insets(0, 0, 0, 100));

        Group root = new Group(vbox);
        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
