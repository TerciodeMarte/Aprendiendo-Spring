package com.cafeconpalito.patrones.behavioral.observer;

/**
 * Representa un observador
 */
public interface WeatherObserver {
    /**
     * Actualiza el estado de observador con la nueva información notificada desde la clase que cambia
     * @param type
     */
    void update(WeatherType type);
}
