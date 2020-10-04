package lesson3.clean_code.bad.code2;

/**
 * Объект Куб реализует интерфейс 3Д Фигуры
 */
public class Qube implements Shape3D {
    /**
     * колличество сторон у куба
     */
    public static final int SIDES_OF_CUBE = 6;

    /**
     * колличество ребер у куба
     */
    public static final int CUBE_EDGES = 12;

    private Double centerX;
    private Double centerY;
    private Double centerZ;

    /**
     * величина ребра куба
     */
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
     * @return возвращает периметр куба
     */
    @Override
    public Double getPerimeter() {
        return CUBE_EDGES * edgeSize;
    }

    /**
     * @return возвращает площадь куба
     */
    @Override
    public Double getSquare() {
        return SIDES_OF_CUBE * edgeSize * edgeSize;
    }

    /**
     * @return возвращает объем круга
     */
    @Override
    public Double getVolume() {
        return Math.pow(edgeSize, 3);
    }
}
