package lab3.logic;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class ProductCollection<T extends IBaseProduct> extends AbstractCollection<T>  {
    private T[] products;
    private int size;

    public ProductCollection() {
        super();
        products = (T[]) new IBaseProduct[10];
        size =0;
    }

    class ProductIterator implements Iterator<T> {
        private int position;

        public ProductIterator() {
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return position<size;
        }

        @Override
        public T next() {
            return products[position++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ProductIterator();
    }

    public Iterator<T> iterator(float minPrice,float maxPrict) {
        Stack<T> goodProduct = new Stack<>();
        Arrays.stream(products).forEach(t -> {
            if(t!= null && t.getPrice()>=minPrice && t.getPrice() <= maxPrict)
                goodProduct.push(t);
        });
        Iterator<T> stackIterator = goodProduct.iterator();
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return stackIterator.hasNext();
            }

            @Override
            public T next() {
                return stackIterator.next();
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
    public T getAt(int index){
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        return products[index];
    }

    @Override
    public boolean add(T product) {
        products[size] = product;
        size++;
        if(size == products.length){
            T[] tempProducts = products;
            products = (T[]) new IBaseProduct[(int) (products.length*1.25)];
            System.arraycopy( tempProducts, 0, products, 0, tempProducts.length );
        }
        return true;
    }

    protected void sort(Comparator<T> comparator){
        T temp;
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
