package sample.Main13;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class Controller {
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Label label;

    private Process process;

    public void start(ActionEvent actionEvent) {
        process = new Process();
        progressBar.progressProperty().bind(process.progressProperty());
        progressIndicator.progressProperty().bind(process.progressProperty());
        label.textProperty().bind(process.messageProperty());
        new Thread(process).start();
    }

    public void cancel(ActionEvent actionEvent) {
        progressBar.progressProperty().unbind();
        progressBar.setProgress(0);
        progressIndicator.progressProperty().unbind();
        progressIndicator.setProgress(0);
        label.textProperty().unbind();
        label.setText("Waiting..");
        process.cancel();
    }
}

class Process extends Task<Void> {
    @Override
    protected Void call() throws Exception {
        for (int i = 1; i <= 10; i++) {
            if (isCancelled())
            {
                updateMessage("Cancelled");
                break;
            }
            updateProgress(i, 10);
            updateMessage("Loading..");
            Thread.sleep(1000);
        }
        updateMessage("Completed");
        return null;
    }
}
