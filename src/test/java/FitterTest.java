import model.Box;
import model.Package;
import model.Parallelepiped;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FitterTest {

    private Service service;

    @Before
    public void setup() {
        service = new Service();
    }

    @Test
    public void testPositive() {
        Package p = new Package(new Parallelepiped(new Vector3D(7, 2.4, 0), new Vector3D(1, 0, 0),
                new Vector3D(2, 2, 0)));
        Box b = new Box(new Parallelepiped(new Vector3D(-0.5, 1.2, 0), new Vector3D(8.5, 1.8, 0),
                new Vector3D(2, 2, 0)));
        Assert.assertTrue(service.isPackageFitInBox(p, b));
    }

    @Test
    public void testPositiveDiag() {
        Package p = new Package(new Parallelepiped(new Vector3D(7, 2.4, 0), new Vector3D(1, 0, 0),
                new Vector3D(2, 2, 0)));
        Box b = new Box(new Parallelepiped(new Vector3D(-0.5, 7.2, 0), new Vector3D(7, 1.8, 0),
                new Vector3D(2, 2, 0)));
        Assert.assertTrue(service.isPackageFitInBox(p, b));
    }

    @Test
    public void testNegative() {
        Package p = new Package(new Parallelepiped(new Vector3D(7, 2.4, 0), new Vector3D(2, 0, 0),
                new Vector3D(2, 2, 0)));
        Box b = new Box(new Parallelepiped(new Vector3D(-0.5, 1.2, 0), new Vector3D(8.5, 1.8, 0),
                new Vector3D(2, 2, 0)));
        Assert.assertFalse(service.isPackageFitInBox(p, b));
    }

    @Test
    public void testSameSize() {
        Package p = new Package(new Parallelepiped(new Vector3D(8.5, 1.8, 0), new Vector3D(-0.5, 1.2, 0),
                new Vector3D(2, 2, 0)));
        Box b = new Box(new Parallelepiped(new Vector3D(-0.5, 1.2, 0), new Vector3D(8.5, 1.8, 0),
                new Vector3D(2, 2, 0)));
        Assert.assertTrue(service.isPackageFitInBox(p, b));
    }
}
