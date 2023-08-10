import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Customer {
    private String name;
    private int age;
    private int orderPrice;
    private String profilePhotoUrl;

    public Customer(String name, int age, int orderPrice) {
        this.name = name;
        this.age = age;
        this.orderPrice = orderPrice;
    }

    public Customer(Customer customer) {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isOlderThen20Age() {
        return this.age > 20;
    }

    public Customer() {
    }

    public boolean hasValidProfilePhoto() throws IOException {
        URL url = new URL(this.profilePhotoUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
