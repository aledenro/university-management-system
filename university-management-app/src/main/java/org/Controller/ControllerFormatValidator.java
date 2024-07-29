package org.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerFormatValidator {
    public boolean verifyFormatCedula(String cedula){
        Pattern pattern = Pattern.compile("^([1-9])-\\d{4}-\\d{4}");
        Matcher matcher = pattern.matcher(cedula);

        return matcher.find();
    }

    public boolean verifyFormatCorreo(String correo){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(correo);

        return matcher.find();
    }

    public boolean verifyFormatNumTelefono(String numero){
        Pattern pattern = Pattern.compile("^[682]?\\d{7}");
        Matcher matcher = pattern.matcher(numero);

        return matcher.find();
    }

    public boolean verifyOnlyNumbers(String numero){
        Pattern pattern = Pattern.compile("^[\\d]+$");
        Matcher matcher = pattern.matcher(numero);

        return matcher.find();
    }
}
