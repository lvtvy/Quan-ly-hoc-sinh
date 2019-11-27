package sample.model;

public class Subject {

    private String id;
    private String name;
    private int numCredit;
    private float pointDiligence;
    private float pointMidterm;
    private float pointEndterm;

    public Subject() {
    }

    public Subject(String id, String name, int numCredit, float pointDiligence, float pointMidterm, float pointEndterm) {
        this.id = id;
        this.name = name;
        this.numCredit = numCredit;
        this.pointDiligence = pointDiligence;
        this.pointMidterm = pointMidterm;
        this.pointEndterm = pointEndterm;
    }

    public float getPointTotal() {
        return (float) (getPointDiligence() * 0.1 + getPointMidterm() * 0.3 + getPointEndterm() * 0.6);
    }

//    public char show(){
//        if (getPointTotal() >= 8.5){
//            return 'A';
//        } else if (getPointTotal() >= 7.0){
//            return 'B';
//        } else if (getPointTotal() >= 5.5) {
//            return 'C';
//        } else if (getPointTotal() >= 4.5){
//            return 'D';
//        }
//        return 'F';
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumCredit() {
        return numCredit;
    }

    public void setNumCredit(int numCredit) {
        this.numCredit = numCredit;
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
}
