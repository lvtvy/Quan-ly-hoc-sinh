package sample.model;

public class Student {

    private String name;
    private int id;
    private String dept;
    private String clazz;
    private String date;
    private String gender;

    private float pointDiligence;
    private float pointMidterm;
    private float pointEndterm;
    //    private float pointTotal;
    private boolean select;

    private String email;
    private String password;

    public Student(String name, int id, String dept, String clazz, String date, String gender, float pointDiligence, float pointMidterm, float pointEndterm) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.clazz = clazz;
        this.date = date;
        this.gender = gender;
        this.pointDiligence = pointDiligence;
        this.pointMidterm = pointMidterm;
        this.pointEndterm = pointEndterm;
    }

    public Student(String name, int id, String dept, String clazz, String date, String gender, String email, String password) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.clazz = clazz;
        this.date = date;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getPointDiligence() {
        return pointDiligence;
    }

    public void setPointDiligence(float pointDiligence) {
        this.pointDiligence = pointDiligence;
    }

    public float getPointMidterm() {
        return pointMidterm;
    }

    public void setPointMidterm(float pointMidterm) {
        this.pointMidterm = pointMidterm;
    }

    public float getPointEndterm() {
        return pointEndterm;
    }

    public void setPointEndterm(float pointEndterm) {
        this.pointEndterm = pointEndterm;
    }

//    public float getPointTotal() {
//        return pointTotal;
//    }
//
//    public void setPointTotal(float pointTotal) {
//        this.pointTotal = pointTotal;
//    }

    public float getPointTotal() {
        return (float) (getPointDiligence() * 0.1 + getPointMidterm() * 0.3 + getPointEndterm() * 0.6);
    }


    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
