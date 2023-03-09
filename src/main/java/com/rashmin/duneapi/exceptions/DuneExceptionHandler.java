package com.rashmin.duneapi.exceptions;

import com.rashmin.duneapi.model.dto.ExceptionDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
/**
 * is “advice” for multiple controllers. It enables the application of a single ExceptionHandler to multiple controllers
 *
 * ExceptionHandler is a Spring annotation that provides a mechanism to treat exceptions thrown during execution of
 * handlers (controller operations). This annotation, if used on methods of controller classes, will serve as the entry
 * point for handling exceptions thrown within this controller only.
 */
public class DuneExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error = "Invalid HTTP Request.";
        return buildResponseEntity(new ExceptionDTO(status.value(),"BAD REQUEST",error));
    }

    @Override protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return buildResponseEntity(new ExceptionDTO(status.value(),"METHOD NOT SUPPORTED","HTTP method not supported"));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        ExceptionDTO dto = new ExceptionDTO(HttpStatus.NOT_FOUND.value(), "Entity Not Found",ex.getMessage());
        return new ResponseEntity<>(dto, HttpStatusCode.valueOf(dto.getStatus()));
    }

    private ResponseEntity<Object> buildResponseEntity(ExceptionDTO exceptionDTO) {
        return new ResponseEntity<>(exceptionDTO, HttpStatusCode.valueOf(exceptionDTO.getStatus()));
    }
}
