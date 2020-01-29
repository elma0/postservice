package model;

public class Package implements Edges, MainDiagonals {
    private final Parallelepiped p;

    public Package(Parallelepiped p) {
        this.p = p;
    }

    public double[] diags() {
        return p.diags();
    }

    public double[] edges() {
        return p.edges();
    }
}
