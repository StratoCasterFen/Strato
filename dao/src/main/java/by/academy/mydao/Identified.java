package by.academy.mydao;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {

    // Возвращает идентификатор объекта
    public PK getId();
}
