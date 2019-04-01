
package com.maquinadebusca.app.model.service;

import com.maquinadebusca.app.controller.Coletor;
import com.maquinadebusca.app.model.Documento;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ColetorService {
    
    public static void main(String[] args){
    Coletor coletor = new Coletor();
    coletor.imprimeColetor();
}

    // URL: http://localhost:8080/coletor/iniciar
    public Documento iniciar() {
        
        URL url;
        Documento d = new Documento();
        try {
            url = new URL("http://journals.ecs.soton.ac.uk/java/tutorial/networking/urls/readingWriting.html");
            Document doc = Jsoup.connect(url.toString()).get();
            Elements links = doc.select("a[href]");
            d.setUrl(url);
            d.setTexto(doc.html());
            d.setVisao(doc.text());
            List<String> urls = new LinkedList();
            for (Element link : links) {
                if (!link.attr("abs:href").equals("") && (link.attr("abs:href") != null)) {
                    urls.add(link.attr("abs:href"));
                }
            }
            d.setUrls(urls);
            System.out.println("\n\n\n=================================================");
            System.out.println(">>> URL:");
            System.out.println("=================================================");
            System.out.println(d.getUrl());
            System.out.println("\n\n\n=================================================");
            System.out.println(">>> P\u00c3\u00a1gina:");
            System.out.println("=================================================");
            System.out.println(d.getTexto());
            System.out.println("\n\n\n=================================================");
            System.out.println(">>> Vis\u00c3\u00a3o:");
            System.out.println("=================================================");
            System.out.println(d.getVisao());
            System.out.println("\n\n\n=================================================");
            System.out.println(">>>URLs: ");
            System.out.println("=================================================");
            urls = d.getUrls();
            for (String u : urls) {
                System.out.println(u);
            }
        } catch (Exception e) {
            System.out.println("Erro ao coletar a pagina");
            e.printStackTrace();
        }
        return d;
    }}

