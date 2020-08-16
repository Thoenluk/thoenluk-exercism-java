class Darts {
    
    double distance;

    Darts(double x, double y) {
        this.distance = Math.sqrt(x * x + y * y);
    }

    int score() {
        if(distance > 10){
            return 0;
        } else if (distance > 5){
            return 1;
        } else if (distance > 1){
            return 5;
        } else {
            return 10;
        }
    }

}
