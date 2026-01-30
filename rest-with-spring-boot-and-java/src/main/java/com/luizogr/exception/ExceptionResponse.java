package com.luizogr.exception;

import java.util.Date;

public record ExceptionResponse(Date timestemp, String message, String details) {
}
