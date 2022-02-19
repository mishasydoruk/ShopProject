package com.example.xyeta.Exeptions;

public class AlreadyExistsResponse extends ErrorResponse {
    public AlreadyExistsResponse(String _message)
    {
        status = 403;
        message = _message + " already exists";
    }
}
