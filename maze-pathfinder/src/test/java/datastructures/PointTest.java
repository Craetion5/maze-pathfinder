
package datastructures;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jethulk
 */
public class PointTest {

    public PointTest() {
    }

    /**
     * Point is created properly.
     */
    @Test
    public void testInitialization() {
        Point p = new Point(2, 5);
        Assert.assertTrue(p.getX() == 2 && p.getY() == 5);
    }

    /**
     * X and y values can be properly changed.
     */
    @Test
    public void testChangeValues() {
        Point p = new Point(2, 5);
        p.setX(3);
        p.setY(4);
        Assert.assertTrue(p.getX() == 3 && p.getY() == 4);
    }

}
