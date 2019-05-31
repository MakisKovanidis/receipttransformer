public class Vat {

    private int vatcategory;
    private float netsales;


    public Vat(int vatcategory, float netsales) {
        this.vatcategory = vatcategory;
        this.netsales = netsales;
    }

    public int getVatcategory() {
        return vatcategory;
    }

    public void setVatcategory(int vatcategory) {
        this.vatcategory = vatcategory;
    }

    public float getNetsales() {
        return netsales;
    }

    public void setNetsales(float netsales) {
        this.netsales = netsales;
    }

    public void addNetSales(float argNetSales){
        this.netsales= this.netsales + argNetSales;
    }

    public boolean hasVatCategory(int ArgVatCategory){
        if (this.vatcategory == ArgVatCategory)
            return true;
        else
            return false;
    }

}
