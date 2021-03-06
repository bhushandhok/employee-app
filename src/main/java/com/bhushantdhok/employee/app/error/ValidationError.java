package com.bhushantdhok.employee.app.error;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.*;

public class ValidationError {
    Map<String, Set<String>> errors = new HashMap<>();

    public static ValidationError getInstance() {
        return new ValidationError();
    }


    @JsonAnySetter
    public ValidationError addError(String path, String message) {
        Set<String> messages = null;
        if (errors.containsKey(path)) {
            messages = errors.get(path);

        } else {
            messages = new HashSet<>();
            errors.put(path, messages);
        }
        messages.add(message);
        return this;
    }

    @JsonAnyGetter
   public Map<String, Set<String>> getErrors() {
        return errors;
    }


}