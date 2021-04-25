package presentationLayer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ProductsController {

    public BorderPane productsPane;
    public Button btnAddProduct;
    public Button btnEditProduct;
    public Button btnDeleteProduct;
    public Button btnViewProductsTable;

    public void addProduct(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("addProduct");
        productsPane.setCenter(view);
    }

    public void editProduct(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("editProduct");
        productsPane.setCenter(view);
    }

    public void deleteProduct(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("deleteProduct");
        productsPane.setCenter(view);
    }

    public void viewProductsTable(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("tableProducts");
        productsPane.setCenter(view);
    }

}
