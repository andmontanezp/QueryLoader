package com.consisint.factory;

import com.consisint.loader.JsonLoader;
import com.consisint.loader.Loader;
import com.consisint.loader.XmlLoader;

/**
 * Created by ANDERSON on 03/04/2016.
 */
public class LoaderFactory {
    public static Loader getLoader(String loaderName) {
        if("xml".equalsIgnoreCase(loaderName)) {
            return new XmlLoader();
        } else if("json".equalsIgnoreCase(loaderName)) {
            return new JsonLoader();
        } else {
            return null;
        }
    }
}
