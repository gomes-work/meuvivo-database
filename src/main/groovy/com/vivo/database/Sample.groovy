package com.vivo.database

import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

/**
 * Created by joaogomes on 09/05/17.
 */
class Sample {

    static void processData(String data) {
        println "Request Result: " + data
    }
    static void main(String[] args) {

        def estadao = CompletableFuture.supplyAsync({
            "http://www.estadao.com.br".toURL().text;
        });
        def google = CompletableFuture.supplyAsync({
            "http://www.google.com.br".toURL().text;
        });

        estadao.thenCombine(google, { e, g ->
            if (g.length() > e.length()) println "Google Maior"
            else println "Estadao Maior"
        });


        println "Requesting...";
        google.thenApply(Sample.&processData);

        TimeUnit.SECONDS.sleep(5);
    }
}
