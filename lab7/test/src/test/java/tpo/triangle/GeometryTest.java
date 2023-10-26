package tpo.triangle;

import org.junit.Assert;
import org.junit.Test;



public class GeometryTest extends Assert {
    @Test
    public void testIsTriangle1() throws Exception {
        Assert.assertTrue("Bad triangle", Triangle.isTriangle(4,6,  7));
    }
    @Test
    public void testIsTriangle2() throws Exception {
        Assert.assertTrue("Bad triangle", Triangle.isTriangle(1,2,  5));
    }
    @Test
    public void testIsTriangle3() throws Exception {
        Assert.assertTrue("Bad triangle", Triangle.isTriangle(16,10,  10));
    }
    @Test
    public void testIsTriangle4() throws Exception {
        Assert.assertTrue("Bad triangle", Triangle.isTriangle(9,17,  12));
    }
    @Test
    public void testIsTriangle5() throws Exception {
        Assert.assertTrue("Bad triangle", Triangle.isTriangle(4,3,  5));
    }
    //---------
    @Test
    public void testIsRectangular1() throws Exception {
        Triangle triangle = new Triangle(3, 4, 5);
        Assert.assertTrue("Not Rectangular", triangle.isRectangular());
    }@Test
    public void testIsRectangular2() throws Exception {
        Triangle triangle = new Triangle(4, 4, 5);
        Assert.assertTrue("Not Rectangular", triangle.isRectangular());
    }
    //---
    @Test
    public void testIsIsosceles1() throws Exception {
        Triangle triangle = new Triangle(9, 9, 9);
        Assert.assertTrue("Not Isosceles", triangle.isIsosceles());
    }@Test
    public void testIsIsosceles2() throws Exception {
        Triangle triangle = new Triangle(4, 4, 5);
        Assert.assertTrue("Not Isosceles", triangle.isIsosceles());
    }
    //---
    @Test
    public void testIsEquilateral1() throws Exception {
        Triangle triangle = new Triangle(9, 9, 9);
        Assert.assertTrue("Not Equilateral", triangle.isEquilateral());
    }@Test
    public void testIsEquilateral2() throws Exception {
        Triangle triangle = new Triangle(4, 4, 5);
        Assert.assertTrue("Not Equilateral", triangle.isEquilateral());
    }
}
