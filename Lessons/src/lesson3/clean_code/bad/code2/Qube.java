package lesson3.clean_code.bad.code2;

/**
 * Объект Куб реализует интерфейс 3Д Фигуры
 */
public class Qube implements Shape3D {
    /**
     * колличество граней у куба
     */
    public static final int SIDES_OF_CUBE = 6;

    /**
     * значения x центра фигуры относительно начала коорлинат
     */
    private Double centerX;
    /**
     * значение y центра фигуры относительно начала коорлинат
     */
    private Double centerY;
    /**
     * значение z центра фигуры относительно начала коорлинат
     */
    private Double centerZ;

    /**
     * длинна ребра куба
     */
    private Double edgeSize;

    public Qube(Double centerX, Double centerY, Double centerZ, Double edgeSize) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.edgeSize = edgeSize;
    }


    /**
     * @return значение центра фигуры относительно начала координато по оси Х
     */
    @Override
    public Double getCenterX() {
        return centerX;
    }

    /**
     * @return значение центра фигуры относительно начала координато по оси Y
     */
    @Override
    public Double getCenterY() {
        return centerY;
    }

    /**
     * @return значение центра фигуры относительно начала координато по оси Z
     */
    @Override
    public Double getCenterZ() {
        return centerZ;
    }

    /**
     * @return возвращает площадь куба
     */
    @Override
    public Double getSquare() {
        return SIDES_OF_CUBE * edgeSize * edgeSize;
    }

    /**
     * @return возвращает объем куба
     */
    @Override
    public Double getVolume() {
        return Math.pow(edgeSize, 3);
    }
}
