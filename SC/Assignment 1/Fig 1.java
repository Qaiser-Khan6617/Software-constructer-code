public interface CloudHostingProvider {
    void createServer(String region);
    void listServers(String region);
}
 CDNProvider
public interface CDNProvider {
    String getCDNAddress();
}
CloudStorageProvider
public interface CloudStorageProvider {
    void storeFile(String name);
    String getFile(String name);
}

// Amazon
public class Amazon implements CloudHostingProvider, CDNProvider, CloudStorageProvider {

    @Override
    public void storeFile(String name) {
        System.out.println("Amazon: File stored -> " + name);
    }

    @Override
    public String getFile(String name) {
        return "Amazon: Retrieving file -> " + name;
    }

    @Override
    public void createServer(String region) {
        System.out.println("Amazon: Server created in " + region);
    }

    @Override
    public void listServers(String region) {
        System.out.println("Amazon: Listing servers in " + region);
    }

    @Override
    public String getCDNAddress() {
        return "cdn.amazon.com";
    }
}


// Dropbox 

public class Dropbox implements CloudStorageProvider {

    @Override
    public void storeFile(String name) {
        System.out.println("Dropbox: File stored -> " + name);
    }

    @Override
    public String getFile(String name) {
        return "Dropbox: Retrieving file -> " + name;
    }
}

//Main
public class MainFig1 {
    public static void main(String[] args) {

        Amazon amazon = new Amazon();
        Dropbox dropbox = new Dropbox();

        amazon.storeFile("report.pdf");
        amazon.createServer("Asia");
        amazon.listServers("Asia");
        System.out.println(amazon.getCDNAddress());

        dropbox.storeFile("photo.png");
        System.out.println(dropbox.getFile("photo.png"));
    }
}
