package com.example.ecommerce.validation;

public class PhoneNumberValidation implements ValidationI {
    @Override
    public String getRegex() {
        return "^(\\+\\d{1,3}[- ]?)?\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
    }
}
