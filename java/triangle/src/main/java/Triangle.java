class Triangle {
    private boolean isEquilateral, isIsosceles, isScalene;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        if(side1 == 0 || side2 == 0 || side3 == 0 ||
            side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1){
            throw new TriangleException();
        }
        this.isEquilateral = (side1 == side2 && side1 == side3);
        this.isIsosceles = this.isEquilateral || (side1 == side2 || side1 == side3 || side2 == side3);
        this.isScalene = !this.isIsosceles;
    }

    boolean isEquilateral() {
        return isEquilateral;
    }

    boolean isIsosceles() {
        return isIsosceles;
    }

    boolean isScalene() {
        return isScalene;
    }

}
