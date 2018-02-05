public class IrisPlant {
    double sepalWidth; //cm
    double sepalLength; //cm
    double petalWidth; //cm
    double petalLength; //cm
    String classType; // Iris Setosa, Iris Versicolour, Iris Virginica

    public IrisPlant() {
        sepalWidth = 0.0;
        sepalLength = 0.0;
        petalWidth = 0.0;
        petalLength = 0.0;
        classType = "";
    }

    public IrisPlant(double sepalWidth, double sepalLength, double petalWidth, double petalLength, String classType) {
        this.sepalWidth = sepalWidth;
        this.sepalLength = sepalLength;
        this.petalWidth = petalWidth;
        this.petalLength = petalLength;
        this.classType = classType;
    }

    public void printPlant() {
        System.out.println(sepalWidth + " - "
                         + sepalLength + " - "
                         + petalWidth + " - "
                         + petalLength + " - "
                         + classType);
    }
}

