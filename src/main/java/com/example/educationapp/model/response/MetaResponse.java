package com.example.educationapp.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MetaResponse {

    private Boolean status;
    private Integer code;
    private String message;
    @JsonFormat(pattern = "yyyy-dd-mm HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime dateTime;

    public MetaResponse(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();


    }

}
