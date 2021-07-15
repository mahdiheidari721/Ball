package Graphic;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Stack;

public class MainView {
    private Stage mainStage;
    private static MainView MV;
    public static Pane pane;
    private final Stack<String> all;

    private MainView(){
        all = new Stack<>();
    }

    public static MainView getMV(){
        if(MV == null)MV = new MainView();
        return MV;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setScene(String scene) throws IOException {
        String name = "";
        for(int i = 0;i < scene.length();i++){
            if(scene.charAt(i) == '.' || scene.charAt(i) == '/')break;
            name += scene.charAt(i);
        }
        all.push(scene);
        pane = FXMLLoader.load(Main.class.getResource(scene));



    }

    public void back() throws IOException{
        all.pop();
        Parent pane = FXMLLoader.load(Main.class.getResource(all.lastElement()));
        mainStage.setScene(new Scene(pane));
    }
}