package ru.netology.javaqa.dz9incaps;

import lombok.Getter;

@Getter
public class Radio {
    
    private int maxStation;
    private int currentStation;
    private int currentVolume;
    
    public Radio() {
        this.maxStation = 9; // По умолчанию 10 станций (0-9)
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            this.maxStation = 9; // Если передано некорректное значение, используем значение по умолчанию
        } else {
            this.maxStation = stationCount - 1; // Максимальный номер станции = количество станций - 1
        }
    }

    // Методы для работы с радиостанцией
    public void setCurrentStation(int station) {
        if (station < 0) {
            return;
        }
        if (station > maxStation) {
            return;
        }
        currentStation = station;
    }

    public void next() {
        if (currentStation == maxStation) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = maxStation;
        } else {
            currentStation = currentStation - 1;
        }
    }

    // Методы для работы с громкостью
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
} 