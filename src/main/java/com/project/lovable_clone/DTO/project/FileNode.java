package com.project.lovable_clone.DTO.project;

public record FileNode(
        String path
) {
    @Override
    public String toString() {
        return path;
    }
}
