//Author: Damandeep Singh

public class Program4 {
    //Client class and program
    public static void main(String[] args) {
        //Tests
        Cube cube = new Cube(2);
        System.out.println("Cube");
        System.out.println("Radius = " + cube.getSide());
        System.out.println("Volume = " + cube.Volume());
        System.out.println("Surface Area = " +cube.SurfaceArea());
        System.out.println("============================");

        Prism rectangularPrism = new RectangularPrism(1, 2, 3);
        System.out.println("Rectangular Prism");
        System.out.println("Height = " + rectangularPrism.getHeight());
        System.out.println("Base = " + rectangularPrism.getBase());
        System.out.println("Width = " + rectangularPrism.getWidth());
        System.out.println("Volume =  " + rectangularPrism.Volume());
        System.out.println("Surface Area =  " + rectangularPrism.SurfaceArea());
        System.out.println("============================");

        Prism triangularPrism = new TriangularPrism(1, 2, 3, 4, 5, 6);
        System.out.println("Triangular Prism");
        System.out.println("Height = " + triangularPrism.getHeight());
        System.out.println("Base = " + triangularPrism.getBase());
        System.out.println("Side 1 = " + triangularPrism.getSide1());
        System.out.println("Side 2 =  " + triangularPrism.getSide2());
        System.out.println("Side 3 =  " + triangularPrism.getSide3());
        System.out.println("Triangle Height = " + triangularPrism.getTriangleHeight());
        System.out.println("Volume = " + triangularPrism.Volume());
        System.out.println("Surface Area = " + triangularPrism.SurfaceArea());
        System.out.println("============================");

        Sphere sphere = new Sphere(3);
        System.out.println("Sphere");
        System.out.println("Radius = " + sphere.getRadius());
        System.out.println("Volume = " + sphere.Volume());
        System.out.println("Surface Area = " + sphere.SurfaceArea());
        System.out.println("============================");

        CircularShape3D cone = new Cone(2, 3, 5);
        System.out.println("Cone");
        System.out.println("Radius = " + cone.getRadius());
        System.out.println("Height = " + cone.getHeight());
        System.out.println("Slant Height = " + cone.getSlantHeight());
        System.out.println("Volume = " + cone.Volume());
        System.out.println("Surface Area = " + cone.SurfaceArea());
        System.out.println("============================");

        CircularShape3D cylinder = new Cylinder(12, 13);
        System.out.println("Cylinder");
        System.out.println("Radius = " + cylinder.getRadius());
        System.out.println("Height = " + cylinder.getHeight());
        System.out.println("Volume = " + cylinder.Volume());
        System.out.println("Surface area = " + cylinder.SurfaceArea());
        System.out.println("============================");

    }
    }
    // top-level interface
    interface ThreeDimShape {
        //abstract methods
        double Volume();
        double SurfaceArea();
    }

    //Cube class with interface
    class Cube implements ThreeDimShape {
        //instance variable
        private final int side;

        // default constructor and initialize the side to 0
        public Cube() {
            this.side = 0;

        }

        // constructor with side parameter
        public Cube(int side) {
            this.side = side;
            Volume();
            SurfaceArea();
        }



        // Accessor method to get side
        public int getSide() {
            return side;
        }

        @Override
        //Calculates cube volume
        public double Volume() {
            return getSide() * getSide() * getSide();
        }

        @Override
        //Calculates cube surface Area
        public double SurfaceArea() {
            return 6 * getSide() * getSide();
        }

        @Override
        public String toString() {
            return "Side: " + getSide() + "\n" + "Volume: " + Volume() + "\n" + "Surface Area: " + SurfaceArea();
        }


    }

    // An abstract class prism that implements interface
    abstract class Prism implements ThreeDimShape {
        //instance variables
        private final int height;
        private final int base;
        private int width;
        private int side1;
        private int side2;
        private int side3;
        private int TriangleHeight;

        // default constructor
        public Prism() {
            height = 0;
            base = 0;
            width = 0;
            side1 = 0;
            side2 = 0;
            side3 = 0;
            TriangleHeight = 0;
        }

        // constructor with parameters for Triangular Prism
        public Prism(int height, int base, int side1, int side2, int side3, int triangleHeight) {
            this.height = height;
            this.base = base;
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            TriangleHeight = triangleHeight;
            Volume();
            SurfaceArea();
        }

        //constructor with parameters for Rectangular Prism
        public Prism(int height, int base, int width) {
            this.height = height;
            this.base = base;
            this.width = width;
            Volume();
            SurfaceArea();
        }

        // Accessor Methods
        public int getHeight() {
            return height;
        }

        public int getTriangleHeight() {
            return TriangleHeight;
        }

        public int getBase() {
            return base;
        }

        public int getSide3() {
            return side3;
        }

        public int getWidth() {
            return width;
        }

        public int getSide1() {
            return side1;
        }

        public int getSide2() {
            return side2;
        }


        @Override
        public String toString() {
            return "height= " + height +
                    "base= " + base +
                    "width= " + width +
                    "side1= " + side1 +
                    "side2= " + side2 +
                    "side3= " + side3 +
                    "TriangleHeight= " + TriangleHeight;
        }
    }

    // RectangularPrism extends the abstract class Prism
    class RectangularPrism extends Prism {

        public RectangularPrism() {
            super();
        }

        // constructor with parameters
        public RectangularPrism(int height, int base, int width) {
            super(height, base, width);
        }


        @Override
        // Rectangular Prism volume
        public double Volume() {
            return getWidth() * getHeight() * getBase();
        }

        @Override
        //Rectangular Prism Surface Area
        public double SurfaceArea() {
            return 2 * ((getWidth() * getBase()) + (getHeight() * getBase()) + (getHeight() * getWidth()));
        }

        //Overridden toString method
        public String toString() {
            return "Height: " + getHeight() + "\n" + "Base: " + getBase() + "\n" + "Width: " + getWidth()
                    + "\n" + "Volume: " + Volume() + "\n" + "Surface Area: " + SurfaceArea();
        }
    }

    //Triangular Prism class inherits the superclass Prism
    class TriangularPrism extends Prism {

        //Constructor with parameters of Triangular Prism
        public TriangularPrism(int height, int base, int side1, int side2, int side3, int triangleHeight) {
            super(height, base, side1, side2, side3, triangleHeight);
        }

        public TriangularPrism() {
            super();
        }

        @Override
        // Calculates Volume of Triangular Prism
        public double Volume() {
            return (1.0 / 2.0) * getBase() * getHeight() * getTriangleHeight();
        }

        @Override
        // Calculates Surface Area of Triangular Prism
        public double SurfaceArea() {
            return (getBase() * getTriangleHeight()) + (getSide1() + getSide2() + getSide3()) * getHeight();
        }

        // Overridden toString method
        public String toString() {
            return "Height: " + getHeight() + "\n" + "Base: " + getBase() + "\n" + "Triangle Height: "
                    + getTriangleHeight() + "\n" + "Side1: " + getSide1() + "\n"
                    + "Side2: " + getSide2() + "\n" + "Side3: " + getSide3() + "\n"
                    + "Volume: " + Volume() + "\n" + "Surface Area: " + SurfaceArea();
        }
    }

    //Abstract class CircularShapes3D for Sphere, Cylinder and Cone
    abstract class CircularShape3D implements ThreeDimShape {
        //common instance variables
        private final int radius;
        private int height;
        private int slantHeight;

        // default constructor
        public CircularShape3D() {
            this.radius = 0;
            this.height = 0;
            this.slantHeight = 0;

        }

        // Constructor for Cylinder
        public CircularShape3D(int radius, int height) {
            this.radius = radius;
            this.height = height;
            Volume();
            SurfaceArea();

        }

        // constructor for sphere
        public CircularShape3D(int radius) {
            this.radius = radius;
            Volume();
            SurfaceArea();
        }

        // Constructor for Cone
        public CircularShape3D(int radius, int height, int slantHeight) {
            this.radius = radius;
            this.height = height;
            this.slantHeight = slantHeight;
            Volume();
            SurfaceArea();
        }

        // Accessor methods
        public int getRadius() {
            return radius;
        }

        public int getHeight() {
            return height;
        }

        public int getSlantHeight() {
            return slantHeight;
        }
    }

    // Class sphere inherits abstract class
    class Sphere extends CircularShape3D {
        // constructor with parameter of Sphere
        public Sphere(int radius) {
            super(radius);
        }
        public Sphere() {
            super();
        }

        @Override
        //Calculates Sphere's Volume
        public double Volume() {
            return (4.0 / 3.0) * Math.PI * getRadius() * getRadius() * getRadius();
        }

        @Override
        //Calculates Sphere's Surface Area
        public double SurfaceArea() {
            return 4.0 * Math.PI * getRadius() * getRadius();
        }

        @Override
        //Overridden toString method
        public String toString() {
            return "Radius: " + getRadius() + "\n" + "Volume: " + Volume() + "\n" + "Surface Area: " + SurfaceArea();
        }
    }

    // Cone class inherits abstract class CircularShape3d
    class Cone extends CircularShape3D {
        //default constructor
        public Cone() {
            super();
        }

        //constructor with parameter
        public Cone(int radius, int height, int slantHeight) {
            super(radius, height, slantHeight);

        }

        @Override
        //Calculate Cone Volume
        public double Volume() {
            return Math.PI * getRadius() * getRadius() * getHeight();
        }

        @Override
        //Calculate Cone Surface Area
        public double SurfaceArea() {
            return Math.PI * getRadius() * (getRadius() + getSlantHeight());
        }

        // Overridden toString method
        public String toString() {
            return "Height: " + getRadius() + "\n" + "Slant Height: " + getSlantHeight() + "\n" + "Radius: " + getRadius()
                    + "\n" + "Volume: " + Volume() + "\n" + "Surface Area: " + SurfaceArea();
        }
    }

    // Cylinder Class extends abstract CircularShape3D
    class Cylinder extends CircularShape3D {
        public Cylinder() {
            super();
        }

        //constructor with parameters (radius and height)
        public Cylinder(int radius, int height) {
            super(radius, height);
        }

        @Override
        //Calculate Cylinder Volume
        public double Volume() {
            return Math.PI * getRadius() * getRadius() * getHeight();
        }

        @Override
        //Calculate Cylinder Surface Area
        public double SurfaceArea() {
            return (2 * Math.PI * getRadius() * getHeight()) + (2 * 3.1416 * getRadius() * getRadius());
        }

        @Override
        //Overridden toString method
        public String toString() {
            return "Radius: " + getRadius() + "\n" + "Height: " + getHeight() + "\n" + "Volume: " + Volume() + "\n"
                    + "Surface Area: " + SurfaceArea();
        }
    }








