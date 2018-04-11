package ch04.action;

import ch04.model.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ProductAction extends ActionSupport implements Preparable,ModelDriven<Product>{

    private Product product;

    @Override
    public void prepare() throws Exception {
        product = new Product();
    }

    @Override
    public Product getModel() {
        return product;
    }

    public String addProductForm() throws Exception{
        return SUCCESS;
    }

    public String addProduct() throws Exception{
        System.out.println(">>>addProduct.action : ");
        if(product != null){
            System.out.println("Product name  :"+product.getName());
            System.out.println("Product Model No : "+product.getModelNo());
        }
        return SUCCESS;
    }

    public String viewProduct()throws Exception{
        System.out.println(">>>ViewProduct : ");
        if(product != null){
            System.out.println("Product name  :"+product.getName());
            System.out.println("Product Model No : "+product.getModelNo());
        }
        return SUCCESS;
    }
}
