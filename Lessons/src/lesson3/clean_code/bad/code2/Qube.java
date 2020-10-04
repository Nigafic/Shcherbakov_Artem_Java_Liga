package lesson3.clean_code.bad.code2;

public class Qube implements Shape3D {
    private Double x;
    private Double y;
    private Double z;
    private Double edgeSize;

    public Qube(Double centerX, Double centerY, Double centerZ, Double edgeSize) {
        this.x = centerX;
        this.y = centerY;
        this.z = centerZ;
        this.edgeSize = edgeSize;
    }


    @Override
    public Double getXSide() {
        return x;
    }

    @Override
    public Double getYSide() {
        return y;
    }

    @Override
    public Double getZSide() {
        return z;
    }

    /**
     * @return возвращает площадь куба
     */
    @Override
    public Double getSquare() {
        return 6*edgeSize*edgeSize;
    }

    /**
     * @return возвращает объем круга
     */
    @Override
    public Double getVolume() {
        return Math.pow(edgeSize, 3);
    }
}
