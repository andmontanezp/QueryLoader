package com.consisint.context;

import com.consisint.loader.Loader;

/**
 * Created by ANDERSON on 03/04/2016.
 */
public class LoaderContext {
    Loader loader;
    String filePath;
    String fileName;

    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void load() {
        loader.load(getFileName());
    }
}
