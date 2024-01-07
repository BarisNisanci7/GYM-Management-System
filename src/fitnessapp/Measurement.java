package fitnessapp;
import java.util.Date;

public class Measurement {
    
    private int MeasurementID;
    private String measurementDate;
    private double weight;
    private double waistSize;
    private double chestSize;
    private double hipSize;
    private double bodyFatPercentage;

    public Measurement(int measurementID, String date, double weight, double waistSize, double chestSize, double hipSize) {
        MeasurementID = measurementID;
        this.measurementDate = date;
        this.weight = weight;
        this.waistSize = waistSize;
        this.chestSize = chestSize;
        this.hipSize = hipSize;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "MeasurementID=" + MeasurementID +
                ", date=" + measurementDate +
                ", weight=" + weight +
                ", waistSize=" + waistSize +
                ", chestSize=" + chestSize +
                ", hipSize=" + hipSize +
                ", bodyFatPercentage=" + bodyFatPercentage +
                '}';
    }

    public int getMeasurementID() {
        return MeasurementID;
    }

    public void setMeasurementID(int measurementID) {
        MeasurementID = measurementID;
    }

    public String getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(String measurementDate) {
        this.measurementDate = measurementDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(double waistSize) {
        this.waistSize = waistSize;
    }

    public double getChestSize() {
        return chestSize;
    }

    public void setChestSize(double chestSize) {
        this.chestSize = chestSize;
    }

    public double getHipSize() {
        return hipSize;
    }

    public void setHipSize(double hipSize) {
        this.hipSize = hipSize;
    }

    public double getBodyFatPercentage() {
        return 0.29288 * weight +
                0.0005 * weight * weight -
                0.000128 * weight * weight * weight +
                0.00000128 * weight * weight * weight * weight -
                0.00000000326 * weight * weight * weight * weight * weight;
    }

}
