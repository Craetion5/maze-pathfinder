package pathfinder;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jethulk
 */
public class PathfinderTest {

    public PathfinderTest() {
    }

    /**
     * Simple functional level is solved.
     */
    @Test
    public void testSolveLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,0,0,1,1,8,1,1,0,0,0,0,0,0,0,1,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,1,1,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,9,0,0,0,0,0,0,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result, result.contains("asasasasssssssssddddddddwdwdwwwwwwwwwwaaasasasssssddwwwdww"));
    }

    /**
     * Functional level featuring keys is solved.
     */
    @Test
    public void testSolveKeyLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,9,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,8,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,25,0,0,0,1,0,25,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result, result.contains("wwwwddddssaaaaaadsssssssdddddddwwwaasddssaaaaawwwwwwwaaaaawwwa"));
    }

    /**
     * Functional level featuring ice is solved.
     */
    @Test
    public void testSolveIceLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,2,2,2,2,2,0,0,1,1,1,1,1,1,0,0,2,2,2,2,2,0,0,1,1,1,1,1,1,0,8,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,0,2,1,1,1,1,1,1,0,0,0,1,2,2,2,2,2,1,1,1,1,1,1,0,9,0,1,2,0,2,0,2,1,1,1,1,1,1,0,0,0,1,2,2,2,2,2,1,1,1,1,1,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result, result.contains("asddwddwwwwaaa"));
    }

    /**
     * Level featuring key/lock traps is solved.
     */
    @Test
    public void testCantFoolThePlayer() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,8,0,1,0,0,0,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1,0,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,0,1,1,0,0,0,2,2,1,25,1,0,0,0,1,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,1,0,1,1,1,1,1,1,1,0,0,0,1,0,1,1,0,1,0,1,0,0,0,1,0,1,28,1,0,1,1,0,1,0,0,0,1,25,1,0,1,0,1,0,1,1,0,1,0,1,0,0,0,1,0,1,9,1,0,1,1,0,1,0,1,1,1,1,1,28,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result, result.contains("wddddddddddssaaassdssadwwawwdddssssssssssaaaaaaaaaaawwwwddssddddddd"));
    }

    /**
     * Level featuring lava is solved.
     */
    @Test
    public void testSolveLavaLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,3,3,3,3,3,3,3,1,0,0,1,1,0,8,0,3,2,2,2,2,3,1,1,0,0,1,1,0,0,0,3,2,0,2,0,3,1,0,0,0,1,1,0,0,0,3,2,2,25,2,3,1,0,0,0,1,1,0,0,0,3,2,2,2,2,3,1,0,0,0,1,1,0,0,0,3,2,0,0,2,3,1,0,0,0,1,1,0,0,0,3,2,2,2,2,3,3,0,0,0,1,1,0,0,0,2,2,2,2,0,3,3,0,0,0,1,1,0,0,0,2,2,2,3,3,3,3,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,0,0,0,2,2,2,3,0,0,0,0,0,0,1,1,0,0,0,2,2,2,28,0,9,0,0,0,0,1,1,0,0,0,2,2,2,3,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result, result.contains("sddddddsawdsadwdwdddsss"));
    }

    /**
     * Impossible level can't be solved.
     */
    @Test
    public void testCantSolveLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,8,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,9,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result.contains("Couldn't solve the level..."));
    }

    /**
     * Impossible level featuring keys can't be solved.
     */
    @Test
    public void testCantSolveKeyLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,9,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,28,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,8,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,25,0,0,0,1,0,25,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result.contains("Couldn't solve the level..."));
    }

    /**
     * Impossible level featuring ice can't be solved.
     */
    @Test
    public void testCantSolveIceLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,2,2,1,0,0,1,1,0,0,0,1,1,0,0,1,2,2,0,0,0,0,1,0,0,0,1,1,0,8,1,2,2,0,0,9,0,1,0,0,0,1,1,0,0,1,2,2,0,0,0,0,1,0,0,0,1,1,0,0,0,2,2,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result.contains("Couldn't solve the level..."));
    }

    /**
     * Impossible level featuring lava can't be solved.
     */
    @Test
    public void testCantSolveLavaLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,8,1,0,9,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,3,0,0,0,0,0,0,0,0,0,0,1,1,0,0,3,0,0,0,0,0,0,0,0,0,0,1,1,0,0,3,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,2,3,3,1,1,0,0,0,0,2,2,2,2,2,2,2,3,3,1,1,0,0,0,0,2,2,2,2,2,2,2,3,3,1,1,0,0,0,0,2,2,2,2,2,2,2,3,3,1,1,0,0,0,0,2,2,2,2,2,2,2,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", false, 0);
        System.out.println(result);
        Assert.assertTrue(result.contains("Couldn't solve the level..."));
    }

    /**
     * Bad input.
     */
    @Test
    public void testBadInput() {
        String result = Pathfinder.solve("bad input", false, 0);
        System.out.println(result);
        Assert.assertTrue(result.contains("Invalid level code!"));
    }

}
