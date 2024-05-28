package me.dio.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends StandardError {

    private final String fields;
    private final String fieldsMessage;
}
