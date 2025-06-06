package ru.netology.javaqa.dz9incaps;

public class Radio {
    private int currentStation;
    private int currentVolume;

    // Методы для работы с радиостанцией
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station < 0) {
            return;
        }
        if (station > 9) {
            return;
        }
        currentStation = station;
    }

    public void next() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation = currentStation - 1;
        }
    }

    // Методы для работы с громкостью
    public int getCurrentVolume() {
        return currentVolume;
    }

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