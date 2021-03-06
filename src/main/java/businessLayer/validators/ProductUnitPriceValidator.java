package businessLayer.validators;

import javafx.scene.control.Alert;
import model.Product;

/**
 * Class that implements the interface Validator and validates the unit price of a product
 * @author Anca
 */
public class ProductUnitPriceValidator implements Validator<Product>{

    private static final double MIN_PRICE = 10;
    private static final double MAX_PRICE = 5000;

    /**
     * Method to check if the inserted unit price is in the required interval
     * @param product object transmitted as parameter
     * @return boolean
     */
    @Override
    public boolean validate(Product product) {
        if (product.getUnitPrice() < MIN_PRICE || product.getUnitPrice() > MAX_PRICE) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill in a unit price greater than 10.00 and smaller than 5000.00");
            alert.show();
           return false;
        }
        return true;
    }
}
