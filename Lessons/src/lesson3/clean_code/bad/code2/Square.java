package lesson3.clean_code.bad.code2;

/**
 * Объект Квадрат реализует интерфейс 2Д Фигуры
 */
public class Square implements Shape2D {

    public static final int SIDES_OF_SQUARE = 4;

    private Double xSideOfSq;
    private Double ySideOfSq;
    private Double edgeSize;

    public Square(Double xSideOfSq, Double ySideOfSq, Double edgeSize) {
        this.xSideOfSq = xSideOfSq;
        this.ySideOfSq = ySideOfSq;
        this.edgeSize = edgeSize;
    }

    @Override
    public Double getXSide() {
        return xSideOfSq;
    }

    @Override
    public Double getYSide() {
        return ySideOfSq;
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
