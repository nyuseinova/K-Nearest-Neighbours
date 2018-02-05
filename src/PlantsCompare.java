import java.util.Comparator;

public class PlantsCompare implements Comparator<IrisPlant> {
    IrisPlant testPlant;

    @Override
    public int compare(IrisPlant plant1, IrisPlant plant2) {
        //computing Manhattan distance
        double distance1 = Math.abs(plant1.sepalLength - testPlant.sepalLength)  +
                Math.abs(plant1.sepalWidth - testPlant.sepalWidth) +
                Math.abs(plant1.petalLength - testPlant.petalLength) +
                Math.abs(plant1.petalWidth - testPlant.petalWidth);

        //computing Manhattan distance
        double distance2 = Math.abs(plant2.sepalLength - testPlant.sepalLength)  +
                Math.abs(plant2.sepalWidth - testPlant.sepalWidth) +
                Math.abs(plant2.petalLength - testPlant.petalLength) +
                Math.abs(plant2.petalWidth - testPlant.petalWidth);

        return Double.compare(distance1, distance2);
    }
}
