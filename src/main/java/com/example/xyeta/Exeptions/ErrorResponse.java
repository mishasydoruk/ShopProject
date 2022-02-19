package com.example.xyeta.Exeptions;

import lombok.Getter;
import lombok.Setter;

import javax.management.remote.rmi.RMIConnectionImpl_Stub;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ErrorResponse {
    public int status;
    public String message;
    public LocalDateTime timestamp;

    public ErrorResponse() {

        timestamp = LocalDateTime.now();
    }

}
