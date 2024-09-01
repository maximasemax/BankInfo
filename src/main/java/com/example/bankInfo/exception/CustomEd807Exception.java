package com.example.bankInfo.exception;

import java.io.IOException;

/**
 * Исключение, генерируемое при ошибках в процесе обработки запросов, связанных с ED807.
 */
public class CustomEd807Exception extends IOException {

    /**
     * Конструктор исключения.
     * @param errorMessage сообщение об ошибке
     */
    public CustomEd807Exception(String errorMessage) {
        super(errorMessage);
    }
}
