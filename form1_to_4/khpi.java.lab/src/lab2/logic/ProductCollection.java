package lab2.logic;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;

public class ProductCollection extends AbstractCollection<IBaseProduct>  {
    private IBaseProduct[] products;
    private int size;

    public ProductCollection() {
        super();
        products = new IBaseProduct[10];
        size =0;
    }

    @Override
    public Iterator<IBaseProduct> iterator() {
        throw new NotImplementedException();
    }

    @Override
    public int size() {
        return size;
    }
    public IBaseProduct getAt(int index){
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        return products[index];
    }

    @Override
    public boolean add(IBaseProduct product) {
        products[size] = product;
        size++;
        if(size == products.length){
            IBaseProduct[] tempProducts = products;
            products = new IBaseProduct[(int) (products.length*1.25)];
            System.arraycopy( tempProducts, 0, products, 0, tempProducts.length );
        }
        return true;
    }

    protected void sort(Comparator<IBaseProduct> comparator){
        IBaseProduct temp;
        for(int i=0;i<size-1;i++)
            if(comparator.compare(this.products[i],this.products[i+1])<0){
                temp = this.products[i];
                this.products[i] = this.products[i+1];
                this.products[i+1]=temp;
                if(i>0) i-=2;
            }
    }

    public void sortByPrice(){
        this.sort((o1, o2) ->(int)(o1.getPrice() - o2.getPrice()));
    }

    public String getPrintedListOfProduct(){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<size;i++)
            result.append(products[i]).append('\n');
        return result.toString();
    }


}
