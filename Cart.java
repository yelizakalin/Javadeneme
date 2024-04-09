package EnocaTest;
import java.util.ArrayList;
import java.util.List;

public class Cart implements CartMethods{

    private List<Product> items;
    private int itemStock;
    private double price;

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public int getPrice() {
        return itemStock;
    }

    public void setPrice(double priceTotal) {
        this.price = priceTotal;
    }
    
    public Cart() {
        items = new ArrayList<>();
    }
    
    
    public boolean isEmpty() {
    	return items.isEmpty();
    }
    
    
  
    
    
    
    

    @Override
    public double getCartTotal() {
        double totalPrice = 0.0;
        System.out.println("Total orders placed so far:");

        for (Product product : items) {
            int quantity = product.getStockState() - (product.getStockState() - getItemStock()); // Get the quantity of the product
            double productTotalPrice = product.getPrice() * quantity; // Calculate the total price for the product
            System.out.println(product.getProductName() + " - Quantity: " + quantity + 
                               " Total Amount: " + productTotalPrice);
            totalPrice += productTotalPrice; // Accumulate the total price
        }

        System.out.println("Total Order Amount: " + totalPrice);
        return totalPrice;
    }
   
    
    @Override
    public void getCart() {
        System.out.println("Items in cart:");
        Product lastProduct = items.get(items.size() - 1);
        int quantity = getItemStock();
            System.out.println(lastProduct.getProductName() + " - Quantity: " + quantity + 
                               " Total Amount: " + (lastProduct.getPrice() * quantity));
            price += (lastProduct.getPrice() * quantity);

    }
    
    
    

    @Override
    public void updateCart() {
       
    }

    @Override
    public void emptyCart() {
        items.clear();
        System.out.println("Cart emptied.");
    }

   public void addToCart(Product product, int itemStock,double priceTotal) {
    	
    	if (product.getStockState() >= itemStock) {

    		items.add(product);

    		 product.decreaseStockState(itemStock);
    		 
    		 getCart();

        } else {
           System.out.println("We're sorry, it has no stock");
        }	
    }
}
