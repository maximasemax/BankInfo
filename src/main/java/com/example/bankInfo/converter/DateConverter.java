package com.example.bankInfo.converter;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {

    /**
     * Метод для конвертации входного объекта {@link XMLGregorianCalendar} в {@link Date}
     * @param calendar 
     * @return null если входной параметр равен null. В остальнрых случаях возращает новый объект {@link Date}
     * с установленным временем.
     */
    public static Date toDate(XMLGregorianCalendar calendar) {
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

    /**
     * Метод для конвертации входного объекта {@link Date} в {@link XMLGregorianCalendar}
     * @param date
     * @return null если входной параметр равен null или если при выполнении возникли какие-либо ошибки.
     * В остальных случаях возвращает новый объект {@link XMLGregorianCalendar} с установленным временем.
     */
    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}