package lesson3.clean_code.bad.code2;

/**
 * Объект Куб реализует интерфейс 3Д Фигуры
 */
public class Qube implements Shape3D {
    private Double centerX;
    private Double centerY;
    private Double centerZ;
    private Double edgeSize;

    public Qube(Double centerX, Double centerY, Double centerZ, Double edgeSize) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.edgeSize = edgeSize;
    }


    @Override
    public Double getXSide() {
        return centerX;
    }

    @Override
    public Double getYSide() {
        return centerY;
    }

    @Override
    public Double getZSide() {
        return centerZ;
    }

    /**
     * @return возвращает площадь куба
     */
    @Override
    public Double getSquare() {
        return 6 * edgeSize * edgeSize;
    }

    @Override
    public Double getPerimeter() {
        return 12 * edgeSize;
    }

    /**
     * @return возвращает объем круга
     */
    @Override
    public Double getVolume() {
        return Math.pow(edgeSize, 3);
    }
}
