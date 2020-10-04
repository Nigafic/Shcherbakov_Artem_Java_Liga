package lesson3.clean_code.bad.code2;

/**
 * Интерфейс добавляет возможности для 3D Фигур
 */
public interface Shape3D extends Shape2D{

    Double getZSide();
    Double getVolume();

}
