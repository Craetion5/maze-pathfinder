package pathfinder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jethulk
 */
public class PathfinderTest {

    public PathfinderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Functional level is solved.
     */
    @Test
    public void testSolveLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,0,0,1,1,8,1,1,0,0,0,0,0,0,0,1,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,1,1,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,9,0,0,0,0,0,0,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
        System.out.println(result);
        Assert.assertTrue(result, result.contains("aaaaassdssassdssassddsddddsddddddwwawwdwwawwdwwawwaaasasasasasassddddddwwwww"));
    }

    /**
     * Functional level featuring keys is solved.
     */
    @Test
    public void testSolveKeyLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,9,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,8,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,25,0,0,0,1,0,25,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
        System.out.println(result);
        Assert.assertTrue(result, result.contains("awwdddddddwwaaaaaaassadddssaassddssaassdddddddwwwaawddsssaaaaaaawwddwwaawwwaaaaawwdw"));
    }

    /**
     * Functional level featuring ice is solved.
     */
    @Test
    public void testSolveIceLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,2,2,2,2,2,0,0,1,1,1,1,1,1,0,0,2,2,2,2,2,0,0,1,1,1,1,1,1,0,8,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,0,2,1,1,1,1,1,1,0,0,0,1,2,2,2,2,2,1,1,1,1,1,1,0,9,0,1,2,0,2,0,2,1,1,1,1,1,1,0,0,0,1,2,2,2,2,2,1,1,1,1,1,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
        System.out.println(result);
        Assert.assertTrue(result, result.contains("aassddwasdwddwwwaaaw"));
    }

    /**
     * Impossible level can't be solved.
     */
    @Test
    public void testCantSolveLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,8,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,9,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
        System.out.println(result);
        Assert.assertTrue(result.contains("Couldn't solve the level..."));
    }

    /**
     * Impossible level featuring keys can't be solved.
     */
    @Test
    public void testCantSolveKeyLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,9,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,28,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,1,1,28,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,8,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,25,0,0,0,1,0,25,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
        System.out.println(result);
        Assert.assertTrue(result.contains("Couldn't solve the level..."));
    }

    /**
     * Impossible level featuring ice can't be solved.
     */
    @Test
    public void testCantSolveIceLevel() {
        String result = Pathfinder.solve("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,0,0,2,2,2,2,0,0,0,0,1,1,0,0,0,2,2,1,0,0,1,1,0,0,0,1,1,0,0,1,2,2,0,0,0,0,1,0,0,0,1,1,0,8,1,2,2,0,0,9,0,1,0,0,0,1,1,0,0,1,2,2,0,0,0,0,1,0,0,0,1,1,0,0,0,2,2,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
        System.out.println(result);
        Assert.assertTrue(result.contains("Couldn't solve the level..."));
    }

    /**
     * Bad input.
     */
    @Test
    public void testBadInput() {
        String result = Pathfinder.solve("bad input");
        System.out.println(result);
        Assert.assertTrue(result.contains("Invalid level code!"));
    }

}
