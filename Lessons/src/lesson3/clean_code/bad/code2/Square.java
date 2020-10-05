package lesson3.clean_code.bad.code2;

/**
 * Объект Квадрат реализует интерфейс 2Д Фигуры
 */
public class Square implements Shape2D {

    /**
     * колличество сторон квадрата
     */
    public static final int SIDES_OF_SQUARE = 4;

    /**
     * значения x центра фигуры относительно начала коорлинат
     */
    private Double centerX;
    /**
     * значения y центра фигуры относительно начала коорлинат
     */
    private Double centerY;

    /**
     * длинна стороны квадрата
     */
    private Double edgeSize;

    public Square(Double centerX, Double centerY, Double edgeSize) {
        this.centerX = centerX;
        this.centerY = centerY;
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
     * @return значение центра фигуры относительно начала координато по оси У
     */
    @Override
    public Double getCenterY() {
        return centerY;
    }

    /**
     * @return возвращает площадь квадрата
     */
    @Override
    public Double getSquare() {
        return edgeSize * edgeSize;
    }

    /**
     * @return возвращает периметр квадрата
     */
    @Override
    public Double getPerimeter() {
        return SIDES_OF_SQUARE * edgeSize;
    }

}
