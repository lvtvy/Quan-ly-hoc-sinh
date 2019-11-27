package sample.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import sample.model.Student;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ControllerTeacher implements Initializable {

    ObservableList<String> ITList = FXCollections.observableArrayList("CNTT1", "CNTT2", "CNTT3", "CNTT4");
    ObservableList<String> MathList = FXCollections.observableArrayList("T1", "T2", "T3", "T4");
    ObservableList<String> deptList = FXCollections.observableArrayList("CNTT", "Toán");
    ObservableList<String> genderList = FXCollections.observableArrayList("Nam", "Nữ");
    ObservableList<String> sortList = FXCollections.observableArrayList("Tên", "Mã sinh viên", "Điểm");
    private Map<String, ObservableList<String>> mapClass;

    private ObservableList<Student> students;
    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> classColumn;
    @FXML
    private TableColumn<Student, String> deptColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> dateColumn;

    @FXML
    private TableColumn<Student, String> genderColumn;
    @FXML
    private TableColumn<Student, Boolean> selectColumn;
    @FXML
    private TableColumn<Student, Float> PointDiligenceCol;
    @FXML
    private TableColumn<Student, Float> PointMidtermCol;
    @FXML
    private TableColumn<Student, Float> PointEndtermCol;
    @FXML
    private TableColumn<Student, Float> PointTotalCol;
    @FXML
    private TextField idText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField pointDiligence;
    @FXML
    private TextField pointMidterm;
    @FXML
    private TextField pointEndterm;
    @FXML
    private TextField pointTotal;
    @FXML
    private ComboBox gender;
    @FXML
    private ChoiceBox sort;
    @FXML
    private ComboBox clazz;
    @FXML
    private ComboBox dept;
    @FXML
    private Label dateTime;
    @FXML
    private DatePicker date;
    @FXML
    private Label hi;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mapClass = new HashMap<String, ObservableList<String>>();
        mapClass.put("CNTT", ITList);
        mapClass.put("Toán", MathList);
        dept.setItems(deptList);
        gender.setItems(genderList);
        sort.setItems(sortList);

        students = FXCollections.observableArrayList(
                new Student("Dương Văn A", 001, "CNTT", "CNTT1", "2016-06-03", "Nam", 10, 10, 10)
        );

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        deptColumn.setCellValueFactory(new PropertyValueFactory<>("dept"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("clazz"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        PointDiligenceCol.setCellValueFactory(new PropertyValueFactory<>("pointDiligence"));
        PointMidtermCol.setCellValueFactory(new PropertyValueFactory<>("pointMidterm"));
        PointEndtermCol.setCellValueFactory(new PropertyValueFactory<>("pointEndterm"));
        PointTotalCol.setCellValueFactory(new PropertyValueFactory<>("pointTotal"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));

        selectColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Student, Boolean> param) {
                Student obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.isSelect());
                return booleanProp;
            }
        });

        selectColumn.setCellFactory(new Callback<TableColumn<Student, Boolean>, TableCell<Student, Boolean>>() {
            @Override
            public TableCell<Student, Boolean> call(TableColumn<Student, Boolean> p) {
                CheckBoxTableCell<Student, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        table.setItems(students);

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd \n \n HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        hi.setText("Xin chào giáo viên");
    }

    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/fileFXML/welcome.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    public void setValueClass(ActionEvent event) {
        String key = (String) dept.getValue();
        Set<String> set = mapClass.keySet();
        for (String e : set) {
            if (e.equals(key)) {
                clazz.setItems(mapClass.get(e));
            }
        }
    }

    @FXML
    public void add() {
        Student student = new Student();
        student.setId(Integer.parseInt(idText.getText()));
        student.setName(nameText.getText());
        student.setDept(dept == null ? deptList.get(0) : dept.getValue().toString());
        student.setClazz(clazz.getValue().toString());
        student.setDate(date.getValue().toString());
        student.setGender(gender == null ? genderList.get(0) : gender.getValue().toString());
        student.setPointDiligence(Float.parseFloat(pointDiligence.getText()));
        student.setPointMidterm(Float.parseFloat(pointMidterm.getText()));
        student.setPointEndterm(Float.parseFloat(pointEndterm.getText()));
//        student.setPointTotal(Float.parseFloat(pointTotal.getText()));
        student.getPointTotal();
        boolean check = false;
        for (Student st : students) {
            if (student.getId() == st.getId()) {
                check = true;
            }
        }
        if (check) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Mã sinh viên đã tồn tại");
            alert.showAndWait();
        } else {
            students.add(student);
        }
    }

    @FXML
    public void delete(ActionEvent event) {
        Student selected = table.getSelectionModel().getSelectedItem();
        students.remove(selected);
    }

    @FXML
    public void edit(ActionEvent event) {
        Student selected = table.getSelectionModel().getSelectedItem();
        selected.setName(nameText.getText());
        selected.setDept(dept == null ? deptList.get(0) : dept.getValue().toString());
        selected.setDate(date.getValue().toString());
        selected.setGender(gender == null ? genderList.get(0) : gender.getValue().toString());
        selected.setPointDiligence(Float.parseFloat(pointDiligence.getText()));
        selected.setPointMidterm(Float.parseFloat(pointMidterm.getText()));
        selected.setPointEndterm(Float.parseFloat(pointEndterm.getText()));
//        selected.setPointTotal(Float.parseFloat(pointTotal.getText()));

        table.getItems().set(table.getSelectionModel().getSelectedIndex(), selected);
    }

    @FXML
    public void reset() {
        idText.clear();
        nameText.clear();
        dept.setValue(null);
        gender.setValue(null);
        date.setValue(null);
        clazz.setValue(null);
        pointDiligence.clear();
        pointMidterm.clear();
        pointEndterm.clear();
        pointTotal.clear();
    }

    public void clickItem(MouseEvent event) {
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Student selected = table.getSelectionModel().getSelectedItem();
                idText.setText(String.valueOf(selected.getId()));
                nameText.setText(selected.getName());
                clazz.setValue(selected.getClazz());
                dept.setValue(selected.getDept());
                date.setValue(LocalDate.parse(selected.getDate()));
                gender.setValue(selected.getGender());
                pointDiligence.setText(String.valueOf(selected.getPointDiligence()));
                pointMidterm.setText(String.valueOf(selected.getPointMidterm()));
                pointEndterm.setText(String.valueOf(selected.getPointEndterm()));
//                pointTotal.setText(String.valueOf(selected.getPointTotal()));
            }
        });
    }

    public void SapXepTangDan() {
        if (sort.getValue().toString().equals("Tên")) {
            Collections.sort(students, (o1, o2) -> {
                if (o1.getName().equalsIgnoreCase(o2.getName())) {
                    if (o1.getId() > o2.getId()) {
                        return 1;
                    } else if (o1.getId() < o2.getId()) {
                        return -1;
                    } else
                        return 0;
                } else
                    return o1.getName().compareTo(o2.getName());
            });
        } else if (sort.getValue().toString().equals("Mã sinh viên")) {
            Collections.sort(students, (o1, o2) -> {
                int value = o1.getId() < o2.getId() ? -1 : 1;
                return value;
            });
        } else if (sort.getValue().toString().equals("Điểm")) {
            Collections.sort(students, (o1, o2) -> {
                int value = o1.getPointTotal() < o2.getPointTotal() ? -1 : 1;
                if (o1.getPointTotal() == o2.getPointTotal()) {
                    value = o1.getName().compareTo(o2.getName());
                }
                return value;
            });
        }
    }

    public void SapXepGiamDan() {
        if (sort.getValue().toString().equals("Tên")) {
            Collections.sort(students, (o1, o2) -> {
                if (o1.getName().equalsIgnoreCase(o2.getName())) {
                    if (o1.getId() > o2.getId()) {
                        return -1;
                    } else if (o1.getId() < o2.getId()) {
                        return 1;
                    } else
                        return 0;
                } else
                    return o2.getName().compareTo(o1.getName());
            });
        } else if (sort.getValue().toString().equals("Mã sinh viên")) {
            Collections.sort(students, (o1, o2) -> {
                int value = o1.getId() > o2.getId() ? -1 : 1;
                return value;
            });
        } else if (sort.getValue().toString().equals("Điểm")) {
            Collections.sort(students, (o1, o2) -> {
                int value = o1.getPointTotal() < o2.getPointTotal() ? 1 : -1;
                if (o1.getPointTotal() == o2.getPointTotal()) {
                    value = o1.getName().compareTo(o2.getName());
                }
                return value;
            });
        }
    }
}

