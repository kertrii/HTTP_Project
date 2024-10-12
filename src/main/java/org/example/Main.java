package org.example;

public class Main {
    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();
        System.out.println();
        try {
            System.out.println(checker.getStatusImage(205));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        System.out.println();
        try {
            downloader.downloadStatusImage(205);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        HttpImageStatusCli cli = new HttpImageStatusCli();
        System.out.println();
        cli.askStatus();
    }
}