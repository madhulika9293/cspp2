import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String inm;
    private String quant;
    private String price;
    Item(final String inm1, final String quant1, final String price1) {
        this.inm = inm1;
        this.quant = quant1;
        this.price = price1;
    }
    /**
     * getting name.
     *
     * @return     { name }
     */
    public String getinm() {
        return inm;
    }
    /**
     * getting quantity.
     *
     * @return     { quantity }
     */
    public String getquant() {
        return quant;
    }
    /**
     * getting price.
     *
     * @return     { price }
     */
    public String getprice() {
        return price;
    }
    /**
     * Sets the quantity.
     *
     * @param      quant2  The quant 2
     */
    public void setQuantity(final String quant2) {
        this.quant = quant2;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return inm + " " + quant + " " + Float.valueOf(price);
    }
}

class Shoppingcart {
    private ArrayList<Item> catalog;
    private ArrayList<Item> cart;
    private int discount;
    private boolean cflag;
    private int hundred = 100;
    /**
     * Constructs the object.
     */
    Shoppingcart() {
        catalog = new ArrayList<>();
        cart = new ArrayList<>();
        discount = 0;
        cflag = true;
    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    void addToCatalog(final Item item) {
        catalog.add(item);
    }
    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    void addToCart(final Item item) {
        for (Item catalogitem : catalog) {
            if ((catalogitem.getinm()).equals(item.getinm())) {
                for (Item cartitem : cart) {
                    if ((cartitem.getinm().equals(item.getinm()))) {
                        int a = Integer.parseInt(cartitem.getquant());
                        int b = Integer.parseInt(item.getquant());
                        int c = a + b;
                        cartitem.setQuantity(String.valueOf(c));
                        return;
                    }
                }
                cart.add(item);
                return;
            } 
        }
    }
    void removeFromcart(final Item items) {
        for (Item cartitems : cart) {
            if ((cartitems.getinm()).equals(items.getinm())) {
                int a = Integer.parseInt(cartitems.getquant());
                int b = Integer.parseInt(items.getquant());
                int c = a - b;
                if (c == 0) {
                    cart.remove(cartitems);
                    return;
                } else { 
                    cartitems.setQuantity(String.valueOf(c));
                    return;
                }
            }
        }
    }
    Double getTotalamount() {
        double total = 0;
        for (Item cartit : cart) {
            for (Item cat : catalog) {
                if ((cartit.getinm()).equals(cat.getinm())) {
                    double price = Double.valueOf(cat.getprice()) * Double.valueOf(cartit.getquant());
                    //pricearr.add(price);
                    total = total + price;
                }
            }
        }
        return total;
    }
    Double getPayableamount() {
        double payableAmount = 0;
        double amt = getTotalamount();
        double discountval = (discount * amt) / hundred;
        double amount = amt - discountval;
        double tax = (15 * amount) / hundred;
        payableAmount = amount  + tax;
        return payableAmount;
    }
    void applycoupon(final String coupon) {
        int[] couponvals = new int[] {10, 20, 30, 50};
        String[] num = coupon.split("D");
        int coupondis = Integer.parseInt(num[1]);
        if (cflag) {
            for (int i = 0; i < couponvals.length; i++) {
            if (coupondis == couponvals[i]) {
                discount = coupondis;
                cflag = false;
                return;
            }
          }
          System.out.println("Invalid coupon");
          return;
        }
    }
    void showCart() {
        for (Item cartit : cart) {
            System.out.println(cartit.getinm() + " " + cartit.getquant());
        }
    }
    public float getPrice(String name) {
        for (Item e : catalog) {
            if (e.getinm().equals(name)) {
                return Float.valueOf(e.getprice());
            }
        }
        return 0.0f;
    }
    /**
     * Shows the catalog.
     */
    void showCatalog() {
        for (Item item : catalog) {
            System.out.println(item.toString());
        }
    }
    /**
     * Printing invoice.
     */
    void printInvoice() {
        System.out.println("Name" + "   " + "quantity" + "   " + "Price");
        for (Item iter : cart) {
            System.out.println(iter.getinm() + " " + iter.getquant() + " " + getPrice(iter.getinm()));
        }
        double totalamount = getTotalamount();
        double discountedval = (discount * totalamount) / hundred;
        double taxval = 0.0;
        if (discountedval == 0.0) {
            taxval = (15 * totalamount) / hundred;
        } else {
            taxval = (15 * (totalamount - discountedval)) / hundred;
        }
        System.out.println("Total:" + String.valueOf(totalamount));
        System.out.println("Disc%:" + String.valueOf(discountedval));
        System.out.println("Tax:" + String.valueOf(taxval));
        System.out.println("Payable amount: " + String.valueOf(getPayableamount()));
    }
}