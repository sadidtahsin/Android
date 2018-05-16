package android.example.com.myapplication;

/**
 * Created by TAMIM_ on 2/8/18.
 */
public class DataModel {

    private double co2;
    private String date;
    private double feels;
    private String time;
    private double humidity;
    private double temperature;

    public DataModel(double co2, String date, double feels, String time, double humidity, double temperature) {
        this.co2 = co2;
        this.date = date;
        this.feels = feels;
        this.time = time;
        this.humidity = humidity;
        this.temperature = temperature;

    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFeels() {
        return feels;
    }

    public void setFeels(double feels) {
        this.feels = feels;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
