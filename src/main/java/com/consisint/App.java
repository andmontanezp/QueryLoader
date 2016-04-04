package com.consisint;

import com.consisint.factory.LoaderFactory;
import com.consisint.loader.Loader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Loader loader = LoaderFactory.getLoader("xml");
        String query = loader.load("getAllPremiums");
        String query2 = loader.load("getPremiumsById");
        System.out.println(query);
        System.out.println(query2);
    }
}
