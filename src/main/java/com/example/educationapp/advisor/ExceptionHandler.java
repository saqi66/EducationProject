package com.example.educationapp.advisor;

import com.example.educationapp.model.response.MetaResponse;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice

public class ExceptionHandler extends ResponseEntityExceptionHandler {

        public ExceptionHandler() {
        super();
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        super.setMessageSource(messageSource);
    }

    @Override
    protected MessageSource getMessageSource() {
        return super.getMessageSource();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "method not supported exception"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Media type not supported exception"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Media type not acceptable exception"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Missing path variable exception"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Missing servlet request parameter exception"));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Missing servlet request parameter exception"));
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Servlet request binding exception"));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Method argument not valid exception"));
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "No handler found exception"));
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Async request timeout exception"));
    }

    @Override
    protected ResponseEntity<Object> handleErrorResponseException(ErrorResponseException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Error response exception"));
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Conversion not supported exception"));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "Type mismatch exception"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "HTTP message not readable exception"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(Boolean.TRUE, BAD_REQUEST.value(), "HTTP message not writable exception"));
    }
}
