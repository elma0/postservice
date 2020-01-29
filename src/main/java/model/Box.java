package model;

public class Box implements Edges, MainDiagonals {
    private final Parallelepiped p;

    public Box(Parallelepiped p) {
        this.p = p;
    }

    public double[] diags() {
        return p.diags();
    }

    public double[] edges() {
        return p.edges();
    }
}
