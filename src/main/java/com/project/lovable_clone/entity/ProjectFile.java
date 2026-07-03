package com.project.lovable_clone.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long fileId;

    Project project;

    String path;
    String fileName;

    String minioObjectKey;

    Instant createdAt;
    Instant deletedAt;
    Instant updatedAt;

    User  createdBy;

    User updatedBy;


}
