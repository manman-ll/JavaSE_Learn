package Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class TestThread2 extends Thread{

    private String url;
    private String name;
    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url,name);
        System.out.println("下载了文件名为:"+name);
    }
}

//下载器
class WebDownloader{
    public void  download(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
