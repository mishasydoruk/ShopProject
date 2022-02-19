package com.example.xyeta.Exeptions;

public class NotFoundResponse extends ErrorResponse {

    public NotFoundResponse(String _message)
    {
        message = _message + " not found";
        status = 404;
    }
}
