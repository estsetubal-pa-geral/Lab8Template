package pt.pa.patterns.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amfs
 */
public class ComposedPackage extends Package {

    private List<Package> packageList;

    public ComposedPackage(String code, int freeMonths) {
        super(code, freeMonths);

        packageList = new LinkedList<>();
    }

    public ComposedPackage(String code, int freeMonths, Package... packages) {
        this(code, freeMonths);

        for (Package p : packages) {
            add(p);
        }
    }

    public final void add(Package p) {
        if (!packageList.contains(p)) {
            packageList.add(p);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s\n", getDescription()));

        for (Package p : packageList) {
            sb.append(String.format("\t%s\n", p.getDescription()));
        }

        return sb.toString();
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Package p : packageList) {
            total += p.getPrice();
        }
        return total;
    }

    @Override
    public void applyDiscount(double percentage) {
        for (Package p : packageList) {
            p.applyDiscount(percentage);
        }
    }
}
