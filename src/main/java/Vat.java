import java.util.HashMap;
import java.util.Map;

public class Vat {

    private HashMap <Integer, Float> vatCategories = new HashMap<>();


    public Vat() {
    }

    public HashMap<Integer, Float> getVatCategories() {
        return vatCategories;
    }

    public void setVatCategories(HashMap<Integer, Float> vatCategories) {
        this.vatCategories = vatCategories;
    }

    public void addSales(int vatCategory, float netSales){

        float tempNetSales = 0;
        if (this.vatCategories.containsKey(vatCategory)){
            this.vatCategories.put(vatCategory, this.vatCategories.get(vatCategory)+ netSales);
            // tempNetSales = this.vatCategories.get(vatCategory) + netSales;
            }
        else {
            this.vatCategories.put(vatCategory, netSales);
        }
    }

    public void printVat(){

        for (Map.Entry me : this.vatCategories.entrySet()) {
            int vatCat = ((int) me.getKey());
            float gross = ((float) me.getValue());

            float clearvalue =(float) ((gross)/((vatCat*0.01)+1.00));

            float roundedValue = (float) Math.round(clearvalue * 100) / 100;

            float vatValue = (float) Math.round((gross-roundedValue) * 100) / 100;


            System.out.println("Key: "+me.getKey() + " & gross " + me.getValue() +" & Value: " + roundedValue + " & Vat: " + vatValue);
        }
    }

}
