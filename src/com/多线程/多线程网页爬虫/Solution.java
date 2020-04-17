package com.多线程.多线程网页爬虫;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    ExecutorService executorService= Executors.newFixedThreadPool(10);
    String start;
    LinkedList<String> list=new LinkedList<>();
    ConcurrentHashMap<String,Boolean> concurrentHashMap=new ConcurrentHashMap<>();
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        this.start=startUrl;
        List<String> urls = htmlParser.getUrls(startUrl);
    return null;
    }
    public void dosome(String startUrl, HtmlParser htmlParser){
        List<String> urls = htmlParser.getUrls(startUrl);
        executorService.execute(new Thread(){
            @Override
            public void run() {
                urls.stream().filter(v->!concurrentHashMap.containsKey(v)).forEach(v->
                        {
                            executorService.execute(new Thread(){
                                @Override
                                public void run() {
                                    synchronized (list){
                                        list.add(v);
                                    }
                                }
                            });
                            dosome(v,htmlParser);
                        }
                        );
            }
        });
    }
    interface HtmlParser {
        // Return a list of all urls from a webpage of given url.
        // This is a blocking call, that means it will do HTTP request and return when this request is finished.
        public List<String> getUrls(String url);
    }

}