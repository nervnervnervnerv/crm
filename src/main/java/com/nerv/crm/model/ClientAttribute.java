package com.nerv.crm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientAttribute {
    DELETE("Удалить"),
    UNAVAILABLE("Не дозвонились"),
    CALL_BACK("Перезвонить"),
    NON_EXISTENT("Не существует"),
    SMARTASS("Умник"),
    PASS("Передать"),
    CLOSED("Закрыт");

    private final String value;

}
