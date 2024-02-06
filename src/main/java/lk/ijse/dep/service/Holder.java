package lk.ijse.dep.service;
import java.util.Objects;

public class Holder implements Comparable<Holder> {
    private int col;
    private Integer mark;

    public Holder() {
    }

    public Holder(int col, int mark) {
        this.col = col;
        this.mark = mark;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Holder{" +
                "col=" + col +
                ", mark=" + mark +
                '}';
    }

    @Override
    public int compareTo(Holder o) {
        return this.mark.compareTo(o.getMark());
    }

}
