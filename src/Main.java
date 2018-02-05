import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<IrisPlant> vectorOfPlants = new Vector<>();
        Vector<IrisPlant> testPlants = new Vector<>();
        Vector<IrisPlant> teachPlants = new Vector<>();

        KNearestNeighbours knn = new KNearestNeighbours(vectorOfPlants);
        knn.getFileInformation();
        knn.dataSeparation(testPlants, teachPlants);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of K: ");
        int K = in.nextInt();
        while(K > teachPlants.size() || K < 1) {
            System.out.println("Enter new value for K: ");
            K = in.nextInt();
        }

        knn.solution(K, testPlants, teachPlants);
    }

}
