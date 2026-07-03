package com.project.lovable_clone.Error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Getter
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String resourceId;

}
