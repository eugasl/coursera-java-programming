import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for (Point point : s.getPoints()) {
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averageLength = 0.0;
        int numPoints = getNumPoints(s);
        double perimeter = getPerimeter(s);
        averageLength = perimeter / numPoints;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSideLength = 0.0;
        Point lastPoint = s.getLastPoint();
        for (Point point : s.getPoints()) {
            double sideLength = point.distance(lastPoint);
            if (sideLength > largestSideLength) {
                largestSideLength = sideLength; 
            }
            lastPoint = point;
        }
        return largestSideLength;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        for (Point point : s.getPoints()) {
            double pointX = point.getX();
            if (pointX > largestX) {
                largestX = pointX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0.0;
        DirectoryResource directoryResource = new DirectoryResource();
        for (File file : directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            Shape shape = new Shape(fileResource);
            double perimeter = getPerimeter(shape);
            if (perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        double largestPerimeter = 0.0;
        DirectoryResource directoryResource = new DirectoryResource();
        for (File file : directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            Shape shape = new Shape(fileResource);
            double perimeter = getPerimeter(shape);
            if (perimeter > largestPerimeter) {
                temp = file;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("datatest1.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int numPoints = getNumPoints(s);
        System.out.println("numPoints = " + numPoints);
        
        double averageLength = getAverageLength(s);
        System.out.println("averageLength= " + averageLength);
        
        double largestSideLength = getLargestSide(s);
        System.out.println("largestSideLength = " + largestSideLength);
        
        double largestX = getLargestX(s);
        System.out.println("largestX = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largestPerimeter = " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("fileName = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
