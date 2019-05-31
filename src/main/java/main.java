import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class main {

    public static void main(String[] args) throws Exception
    {
        List <Splitter> filelines = new ArrayList<>();
        List<Vat> VatCategories = new CopyOnWriteArrayList<>();
        try
                (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\test\\Receipt.txt"), "x-IBM737"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                filelines.add(new Splitter(line.trim().split("\\s+ ")));
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("--------");
        AtomicInteger pass = new AtomicInteger();
        filelines.forEach((temp)->{
            pass.getAndIncrement();
            String[] splitted = temp.getSplittedline();
            if (splitted.length !=0) {
                if (splitted[splitted.length-1].contains("%")) {
                    //Find Vat category
                    int currentVatCategory=Integer.parseInt(splitted[splitted.length-1].substring(0,2));
                    float currentNetPrice = Float.parseFloat(splitted[splitted.length-2]);

                    if (VatCategories.isEmpty()){
                        VatCategories.add(new Vat(currentVatCategory,currentNetPrice));
                        System.out.println("Initial : "+currentNetPrice + pass);
                    }

                }
            }
            });
        for (Vat vatCategory : VatCategories) {
            System.out.println(vatCategory.getVatcategory()+ " -- " + vatCategory.getNetsales());
        }

    }
}
