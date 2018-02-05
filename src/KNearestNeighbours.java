import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Vector;
import java.util.stream.Stream;

public class KNearestNeighbours {
    private static Vector<IrisPlant> plants = new Vector<IrisPlant>();

    public KNearestNeighbours(Vector<IrisPlant> plants) {
        this.plants = plants;
    }

    public void getLineInformation(String line) {
        double sepalWidth = Double.parseDouble(line.substring(0, 3));
        double sepalLength = Double.parseDouble(line.substring(4, 7));
        double petalWidth = Double.parseDouble(line.substring(8, 11));
        double petalLength = Double.parseDouble(line.substring(12, 15));
        String classType = line.substring(16);

        plants.add(new IrisPlant(sepalWidth, sepalLength, petalWidth, petalLength, classType));
    }

    public void getFileInformation() {
        try (Stream<String> stream = Files.lines(Paths.get(Constants.FILE_DIRECTORY))) {
            stream.forEach(line -> getLineInformation(line));
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void dataSeparation(Vector<IrisPlant> testData, Vector<IrisPlant> teachData) {
        Collections.shuffle(plants);

        for (int i = 0; i < Constants.TEST_DATA_SIZE; i++) {
            testData.add(plants.get(i));
        }

        for (int i = Constants.TEST_DATA_SIZE; i < Constants.ALL_PLANTS_SIZE; i++) {
            teachData.add(plants.get(i));
        }
    }

    public void solution(int K, Vector<IrisPlant> testPlants, Vector<IrisPlant> teachPlants) {
        int setosaCount = 0;
        Vector<Integer> setosa = new Vector<>();
        int versicolorCount = 0;
        Vector<Integer> versicolor = new Vector<>();
        int virginicaCount = 0;
        Vector<Integer> virginica = new Vector<>();
        PlantsCompare plantsCompare = new PlantsCompare();

        for (int i = 0; i < Constants.TEST_DATA_SIZE; i++) {
            plantsCompare.testPlant = testPlants.elementAt(i);
            Collections.sort(teachPlants, plantsCompare);

            for (int j = 0; j < K; j++) {
                if (teachPlants.elementAt(j).classType.equals("Iris-setosa")) {
                    setosaCount++;
                }
                if (teachPlants.elementAt(j).classType.equals("Iris-versicolor")) {
                    versicolorCount++;
                }
                if (teachPlants.elementAt(j).classType.equals("Iris-virginica")) {
                    virginicaCount++;
                }
            }
            setosa.add(setosaCount);
            versicolor.add(versicolorCount);
            virginica.add(virginicaCount);

            if (setosaCount > versicolorCount && setosaCount > virginicaCount) {
                System.out.println("Predicted class type for test plant " + i + " is Iris-setosa");
            }
            if (versicolorCount > setosaCount && versicolorCount > virginicaCount) {
                System.out.println("Predicted class type for test plant " + i + " is Iris-versicolor");
            }
            if (virginicaCount > setosaCount && virginicaCount > versicolorCount) {
                System.out.println("Predicted class type for test plant " + i + " is Iris-virginica");
            }
        }

        Collections.sort(setosa);
        int maxCountSetosa = setosa.lastElement();
        Collections.sort(versicolor);
        int maxCountVersicolour = versicolor.lastElement();
        Collections.sort(virginica);
        int maxCountVirginica = virginica.lastElement();
    }

    public static int plantsSize() {
        return plants.size();
    }
}
