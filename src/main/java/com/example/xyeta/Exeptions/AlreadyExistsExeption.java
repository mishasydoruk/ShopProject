package com.example.xyeta.Exeptions;

public class AlreadyExistsExeption extends ErrorResponse {
    public AlreadyExistsExeption(String _message)
    {
        status = 403;
        message = _message + " already exists";
    }

    public AlreadyExistsExeption() {

    }
}
