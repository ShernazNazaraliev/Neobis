public class Cars {
    private long CarID;
    private String CarName;
    private String Color;
    private double EngineVolume;
    private double Prise;

    public Cars() {
    }

    public Cars(long carID, String carName, String color, double engineVolume, double prise) {
        CarID = carID;
        CarName = carName;
        Color = color;
        EngineVolume = engineVolume;
        Prise = prise;
    }

    public void setCarID(long carID) {
        CarID = carID;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setEngineVolume(double engineVolume) {
        EngineVolume = engineVolume;
    }

    public void setPrise(double prise) {
        Prise = prise;
    }

    public long getCarID() {
        return CarID;
    }

    public String getCarName() {
        return CarName;
    }

    public String getColor() {
        return Color;
    }

    public double getEngineVolume() {
        return EngineVolume;
    }

    public double getPrise() {
        return Prise;
    }
}

