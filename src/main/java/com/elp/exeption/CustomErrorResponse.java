package com.elp.exeption;

import java.time.LocalDateTime;

public record CustomErrorResponse(
        LocalDateTime dateTime,
        String message,
        String path

) {
}
