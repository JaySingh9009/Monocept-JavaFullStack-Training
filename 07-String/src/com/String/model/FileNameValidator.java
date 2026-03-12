package com.String.model;

public class FileNameValidator {

    private String fileName;

    public FileNameValidator(String fileName) {
        this.fileName = fileName.trim();
    }

    public String getExtension() {

        int dotIndex = fileName.lastIndexOf(".");

        return fileName.substring(dotIndex + 1);
    }

    public String getNameWithoutExtension() {

        int dotIndex = fileName.lastIndexOf(".");

        return fileName.substring(0, dotIndex);
    }

    public String getFormattedName() {

        return getNameWithoutExtension().replace("_", " ");
    }

    public String getUpperCaseName() {

        return getFormattedName().toUpperCase();
    }
    public boolean isPdf() {

        return fileName.endsWith(".pdf");
    }
    public boolean containsFinal() {

        return getNameWithoutExtension().toLowerCase().contains("final");
    }
}
