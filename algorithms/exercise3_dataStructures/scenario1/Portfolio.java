package algorithms.exercise3_dataStructures.scenario1;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Portfolio {
    private Asset[] staticAssets;
    private LinkedList<Asset> dynamicAssets;
    private Stack<String> history;
    
    public Portfolio() {
        staticAssets = new Asset[10];
        dynamicAssets = new LinkedList<>();
        history = new Stack<>();
    }


    public void buyAsset(Asset asset, boolean isStatic) {
        if (asset == null)
            return;
        
        addToHistory(asset.getName(), true);

        if (isStatic) {
            if (staticAssets[staticAssets.length] == null) {
                for (int i = 0; i < staticAssets.length; i++) {
                    if (staticAssets[i] == null) {
                        staticAssets[i] = asset;
                        break;
                    }
                }
            }
            else {
                Asset temp = null;
                for (int i = 0; i < staticAssets.length - 1; i++) {
                    temp = staticAssets[i];
                    staticAssets[i] = staticAssets[i + 1];
                    staticAssets[i + 1] = temp;
                }
                staticAssets[staticAssets.length] = asset;
            }
        }
        else
            if (dynamicAssets == null)
                dynamicAssets = new LinkedList<>();

            dynamicAssets.add(asset);
    }

    public void sellAsset(Asset asset, boolean isStatic) {

        if (asset == null)
            return;

        addToHistory(asset.getName(), false);

        if (!isStatic) {
            if (dynamicAssets == null)
                dynamicAssets = new LinkedList<>();
            if (dynamicAssets.contains(asset)) {
                dynamicAssets.remove(asset);
            }
        }
        else {
            int i = 0;
            for (i = 0; i < staticAssets.length; i++) {
                if (staticAssets[i] == asset) {
                    staticAssets[i] = null;
                    break; 
                }
            }
            Asset temp = null;
            for (int j = i; j < staticAssets.length - 1; j++) {
                temp = staticAssets[j];
                staticAssets[j] = staticAssets[j + 1];
                staticAssets[j + 1] = temp;
            }
        }
    }

    private void showTree(LinkedList<Asset> assets) {

        if (assets == null)
            return;
        if (assets.isEmpty())
            System.out.println(assets);

        Asset asset = assets.get(0);
        for (int i = 0; i < assets.size(); i++) {
            asset = assets.get(i);
            System.out.println(asset);

            if (asset.getSubAssets() != null && !asset.getSubAssets().isEmpty())
                showTree(asset.getSubAssets());
        }
    }

    public void showTree() {
        showTree(dynamicAssets);
    }

    public void generateAssetsForTests(int staticAssets, int dynamicAssets) {
        Random random = new Random();
        for (int i = 0; i < staticAssets; i++) {
            if (i < this.staticAssets.length)
                this.staticAssets[i] = new Asset("Asset" + i, random.nextDouble(500000));
            else
                break; 
        }
        Asset asset = null;
        Asset subAsset = null;
        for (int i = 0; i < dynamicAssets; i++) {
            asset = new Asset("Asset" + i, random.nextDouble(432425));
            this.dynamicAssets.add(asset);
            subAsset = new Asset("SubAsset" + i, random.nextDouble(234525));
            asset.getSubAssets().add(subAsset);
        }
    }

    public void addToHistory(String name, boolean bought) {

        if (bought)
            history.push("bought: " + name);
        else
            history.push("sold: " + name);
        
    }

    public void unBuy() {
        if (history.isEmpty())
            return;
        
        history.pop();
    }

    public void unSell() {
        if (history.isEmpty())
            return;
        
        history.pop();
    }
}
