package sample.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.model.Student;
import sample.model.Subject;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ControllerStudent implements Initializable {

    @FXML
    private TableColumn<Subject, String> idSubCol;

    @FXML
    private TableColumn<Subject, String> nameSubCol;

    @FXML
    private TableColumn<Subject, Integer> numCreditCol;

    @FXML
    private TableColumn<Subject, Float> PointDiligenceCol;

    @FXML
    private TableColumn<Subject, Float> PointMidtermCol;

    @FXML
    private TableColumn<Subject, Float> PointEndtermCol;

    @FXML
    private TableColumn<Subject, Float> PointTotalCol;

    @FXML
    private Label dateTime;

    @FXML
    private Label hi;

    @FXML
    private TableView table;

    @FXML
    private Tab tab1;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private ComboBox gender;

    @FXML
    private TextField emailText;

    @FXML
    private TextField passwordText;

    @FXML
    private ComboBox clazz;

    @FXML
    private ComboBox dept;

    @FXML
    private DatePicker DOB;

    private ObservableList<Subject> subjects;

    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/fileFXML/welcome.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
        stage.setResizable(false);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subjects = FXCollections.observableArrayList(
                new Subject("1","C++",4,10,10,10,10),
                new Subject("2","Java",4,9,9,9,9)
        );

        idSubCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameSubCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        numCreditCol.setCellValueFactory(new PropertyValueFactory<>("numCredit"));
        PointDiligenceCol.setCellValueFactory(new PropertyValueFactory<>("pointDiligence"));
        PointMidtermCol.setCellValueFactory(new PropertyValueFactory<>("pointMidterm"));
        PointEndtermCol.setCellValueFactory(new PropertyValueFactory<>("pointEndterm"));
        PointTotalCol.setCellValueFactory(new PropertyValueFactory<>("pointTotal"));

        table.setItems(subjects);

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd \n \n HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        hi.setText("Xin chào sinh viên");

        Student student = new Student("Nguyễn Văn B",1,"CNTT","CNTT1","2000-02-26","Nam","vnb@gmail.com","123456789");

        idText.setText(String.valueOf(student.getId()));
        nameText.setText(student.getName());
        emailText.setText(student.getEmail());
        passwordText.setText(student.getPassword());
        gender.setValue(student.getGender());
        DOB.setValue(LocalDate.parse(student.getDate()));
        dept.setValue(student.getDept());
        clazz.setValue(student.getClazz());
    }
}
