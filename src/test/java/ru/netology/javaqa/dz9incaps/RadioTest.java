package ru.netology.javaqa.dz9incaps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    @Test // проверка конструктора по умолчанию
    void shouldCreateDefaultRadio() {
        Radio radio = new Radio();
        assertEquals(9, radio.getMaxStation());
    }

    @Test // проверка конструктора с параметром
    void shouldCreateCustomRadio() {
        Radio radio = new Radio(20);
        assertEquals(19, radio.getMaxStation());
    }

    @Test // проверка конструктора с некорректным параметром
    void shouldHandleInvalidStationCount() {
        Radio radio = new Radio(-5);
        assertEquals(9, radio.getMaxStation());
        
        radio = new Radio(0);
        assertEquals(9, radio.getMaxStation());
    }

    @Test // сеттер по умолчанию
    void shouldSetStation() {
        Radio radio = new Radio();
        
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
        
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
        
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
        
        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
        
        // Валидные значения
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test // сеттер с параметром
    void shouldSetStationForCustomRadio() {
        Radio radio = new Radio(30);
        
        // Граничные значения
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
        
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
        
        radio.setCurrentStation(29);
        assertEquals(29, radio.getCurrentStation());
        
        radio.setCurrentStation(30);
        assertEquals(29, radio.getCurrentStation());
        
        // Валидные значения
        radio.setCurrentStation(15);
        assertEquals(15, radio.getCurrentStation());
    }

    @Test // next со значением по умолчанию
    void shouldNextStation() {
        Radio radio = new Radio();
        
        radio.setCurrentStation(0);
        radio.next();
        assertEquals(1, radio.getCurrentStation());
        
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
        
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test // next с параметром
    void shouldNextStationForCustomRadio() {
        Radio radio = new Radio(30);
        
        radio.setCurrentStation(0);
        radio.next();
        assertEquals(1, radio.getCurrentStation());
        
        radio.setCurrentStation(28);
        radio.next();
        assertEquals(29, radio.getCurrentStation());
        
        radio.setCurrentStation(29);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test // rev со значением по умолчанию
    void shouldPrevStation() {
        Radio radio = new Radio();
        
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
        
        radio.setCurrentStation(9);
        radio.prev();
        assertEquals(8, radio.getCurrentStation());
        
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test // prev с параметром
    void shouldPrevStationForCustomRadio() {
        Radio radio = new Radio(30);
        
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
        
        radio.setCurrentStation(29);
        radio.prev();
        assertEquals(28, radio.getCurrentStation());
        
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(29, radio.getCurrentStation());
    }

    @Test //увеличение громкости
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        // увеличиваем громкость, пока до дойдём до 100
        for (int i = 0; i < 99; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());

        // проверяем, что громкость не может быть больше 100
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test //уменьшение громкости
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        
        // Устанавливаем максимальную громкость
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        
        radio.decreaseVolume();
        assertEquals(99, radio.getCurrentVolume());
        
        for (int i = 0; i < 99; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());

        // проверяем, что громкость не может быть ниже 0
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
} 