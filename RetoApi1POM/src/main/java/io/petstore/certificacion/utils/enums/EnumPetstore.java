package io.petstore.certificacion.utils.enums;

public enum EnumPetstore{

    URI_PETSTORE("https://petstore.swagger.io"),
    PATH_CREATE_USER("/v2/user");

    private String value;

    EnumPetstore(String value) {
    }

    public String getValue() {
        return value;
    }

}
