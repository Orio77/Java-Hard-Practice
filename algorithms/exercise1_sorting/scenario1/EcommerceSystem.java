package algorithms.exercise1_sorting.scenario1;

import java.util.ArrayList;
import java.util.Random;

public class EcommerceSystem {
    ArrayList<Product> productBase;
    Product[] productsSample;

    public EcommerceSystem() {
        productBase = new ArrayList<>();
        productsSample = new Product[100];
    }

    public void bubbleSortPrice() {
        @SuppressWarnings("unused")
        boolean swapped;
        for (int i = 0; i < productsSample.length; i++) {
            swapped = false;
            for (int j = 0; j < productsSample.length - 1; j++) {
                if (productsSample[j + 1].getPrice() > productsSample[j].getPrice()) {
                    Product temp = productsSample[j];
                    productsSample[j] = productsSample[j + 1];
                    productsSample[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped = false)
                break;
        }
    }

    public void quickSort(ArrayList<Product> products, int start, int end) {

        if (!(start < end))
            return;

        int pivot = partition(products, start, end);

        quickSort(products, start, pivot - 1);
        quickSort(products, pivot + 1, end);
    }

    public int partition(ArrayList<Product> products, int start, int end) {
        int pivot = getMedian(products, start, end);
        int i = start;
        int j = end;

        while (i < j) {
            while (products.get(i).getPrice() < products.get(pivot).getPrice()) {
                i++;
            }
            while (products.get(j).getPrice() > products.get(pivot).getPrice()) {
                j--;
            }
            Product temp = null;
            if (i <= j) {
                temp = products.get(j);
                products.set(j, products.get(i));
                products.set(i, temp);
                i++;
                j--;
            }
        }
        return i;
    }

    public int getMedian(ArrayList<Product> products, int start, int end) {
        int first = products.get(start).getPrice();
        int last = products.get(end).getPrice();
        int mid = products.get(start + (end - start) / 2).getPrice();

        if ((first > last && first < mid) || first < last && first > mid)
            return start;
        else if ((last > first && last < mid) || (last < first && last > mid))
            return end;
        else 
            return start + (end - start) / 2;
    }

    public void mergeSort(ArrayList<Product> products, int left, int right, int category) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(products, left, middle - 1, category);
            mergeSort(products, middle + 1, right, category);

            merge(products, left, middle, right, category);
        }
    }

    private void merge(ArrayList<Product> products, int left, int middle, int right, int category) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        ArrayList<Product> L = new ArrayList<>();
        ArrayList<Product> R = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            L.add(products.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            R.add(products.get(middle + 1 + j));
        }

        int i = 0;
        int j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (category == 0) {
                if (L.get(i).getPrice() <= R.get(j).getPrice()) {
                    products.set(k, L.get(i));
                    i++;
                }
                else {
                    products.set(k, R.get(j));
                    j++;
                }
                k++;
            }
            else if (category == 0) {
                if (L.get(i).getRatings() <= R.get(j).getRatings()) {
                    products.set(k, L.get(i));
                    i++;
                }
                else {
                    products.set(k, R.get(j));
                    j++;
                }
                k++;
            }
            else if (category == 0) {
                if (L.get(i).getPopularity() <= R.get(j).getPopularity()) {
                    products.set(k, L.get(i));
                    i++;
                }
                else {
                    products.set(k, R.get(j));
                    j++;
                }
                k++;
            }
            else 
                return;
        }

        while (i < n1) {
            products.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            products.set(k, R.get(j));
            j++;
            k++;
        }
    }

    public void generateSampleProductsForTests() {
        Random random = new Random();
        for (int i = 0; i < productsSample.length; i++) {
            productsSample[i] = new Product("Product " + i, random.nextInt(100000), random.nextDouble(5), random.nextDouble(10));
            System.out.println(productsSample[i].getPrice());
        }
    }

    public void printProductsSample() {
        int i = 1;
        for (Product product : productsSample) {
            System.out.println(i + ". " + product);
            i++;
        }
    }
}
