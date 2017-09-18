package io.app.demo.demo.util.rest;

import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;

/**
 * Created by fidelvillanuevadelgado on 17/09/17.
 */
public class Response {

    private String message;
    private HttpStatus status;
    private Class<?> object;


    public Response(String message, HttpStatus status, Class<?> object) {
        this.message = message;
        this.status = status;
        this.object=object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Class<?> getClassType() {
        return object;
    }

    public void setClassType(Class<?> object) {
        this.object = object;
    }
}
