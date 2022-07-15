package com.example.xyeta.Exeptions;

public class NotFoundExeption extends ErrorResponse {

    public NotFoundExeption(String _message)
    {
        message = _message + " not found";
        status = 404;
    }
}
