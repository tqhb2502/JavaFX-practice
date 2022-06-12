package sample.Main11;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TreeView<String> treeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootTreeItem = new TreeItem<>();

        TreeItem<String> JavaFXTutorialsTreeItem = new TreeItem<>("JavaFXTutorials");

        TreeItem<String> srcTreeItem = new TreeItem<>("src");

        TreeItem<String> sampleTreeItem = new TreeItem<>("sample");

        TreeItem<String> Main9TreeItem = new TreeItem<>("Main9");
        TreeItem<String> Main10TreeItem = new TreeItem<>("Main10");
        TreeItem<String> Main11TreeItem = new TreeItem<>("Main11");
        TreeItem<String> Main1TreeItem = new TreeItem<>("Main1");

        TreeItem<String> ControllerTreeItem = new TreeItem<>("Controller");
        TreeItem<String> applicationTreeItem = new TreeItem<>("application");

        Main9TreeItem.getChildren().addAll(ControllerTreeItem, applicationTreeItem);

        sampleTreeItem.getChildren().addAll(Main9TreeItem, Main10TreeItem, Main11TreeItem, Main1TreeItem);

        srcTreeItem.getChildren().add(sampleTreeItem);

        JavaFXTutorialsTreeItem.getChildren().add(srcTreeItem);

        rootTreeItem.getChildren().add(JavaFXTutorialsTreeItem);

        treeView.setRoot(rootTreeItem);
        treeView.setShowRoot(false);

        JavaFXTutorialsTreeItem.setExpanded(true);
        srcTreeItem.setExpanded(true);
        sampleTreeItem.setExpanded(true);

        treeView.getSelectionModel().selectedItemProperty().addListener((observableValue, stringTreeItem, t1) -> {
            System.out.println(t1.getValue());
        });
    }
}
