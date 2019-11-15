package sample.model;

public class Subject {

    private String id;
    private String name;
    private int numCredit;
    private float pointDiligence;
    private float pointMidterm;
    private float pointEndterm;
    private float pointTotal;

    public Subject() {
    }

    public Subject(String id, String name, int numCredit, float pointDiligence, float pointMidterm, float pointEndterm, float pointTotal) {
        this.id = id;
        this.name = name;
        this.numCredit = numCredit;
        this.pointDiligence = pointDiligence;
        this.pointMidterm = pointMidterm;
        this.pointEndterm = pointEndterm;
        this.pointTotal = pointTotal;
    }

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

    public float getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(float pointTotal) {
        this.pointTotal = pointTotal;
    }
}
