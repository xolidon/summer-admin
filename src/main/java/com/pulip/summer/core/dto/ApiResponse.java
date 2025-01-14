package com.pulip.summer.core.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponse extends ResponseEntity<Map<String, Object>> {
    public ApiResponse(HttpStatusCode status) {
        super(status);
    }

    public ApiResponse(Map<String, Object> body, HttpStatus status) {
        super(body, status);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Map<String, Object> body = new LinkedHashMap<>();
        private HttpStatus status;



        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder put(String key, Object value) {
            this.body.put(key, value);
            return this;
        }

        public Builder map(Map<String, Object> map) {
            this.body = map;
            return this;
        }

        public Builder list(Object list) {
            this.body.put("list", list);
            return this;
        }

        public Builder body(Map<String, Object> body) {
            this.body = body;
            return this;
        }

        public ApiResponse ok()/* throws MallException*/ {
            this.status = HttpStatus.OK;
            return new ApiResponse(body, status);
        }

        public ApiResponse error() {
            return error(null);
        }

        public ApiResponse error(HttpStatus status) {
            if (this.status == null) {
                status = HttpStatus.BAD_REQUEST;
            }
            return new ApiResponse(body, status);
        }
    }
}
