package businessLayer;

import businessLayer.validators.ProductUnitPriceValidator;
import businessLayer.validators.Validator;
import dataAccessLayer.ProductDAO;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {

    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new ProductUnitPriceValidator());

        productDAO = new ProductDAO();
    }

    public Product findProductById(int id) throws SQLException {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("The product with id = " + id + " was not found!");
        }
        return product;
    }

    public Product findProductByName(String name) throws SQLException {
        Product product = productDAO.findByName(name);
        if (product == null) {
            throw new NoSuchElementException("The product with name = " + name + " was not found!");
        }
        return product;
    }

    public int insertProduct(Product product) throws SQLException {
        boolean ok = true;
        for (Validator<Product> v : validators) {
            if(!v.validate(product)){
                ok = false;
                break;
            }
        }
        if(ok) {
            return ProductDAO.insert(product);
        }
        return -1;
    }

    public int updateProduct(Product product) throws SQLException {
        boolean ok = true;
        for (Validator<Product> v : validators) {
            if(!v.validate(product)){
                ok = false;
                break;
            }
        }
        if(ok) {
            return ProductDAO.updateProduct(product);
        }
        return -1;
    }

    public int deleteProduct(Product product) throws SQLException {
        return ProductDAO.deleteProduct(product);
    }

    public ArrayList<String> getNames() throws SQLException {
        return  ProductDAO.selectNames();
    }

    public ArrayList<Product> getProducts() throws SQLException {
        return  ProductDAO.findAll();
    }

}
