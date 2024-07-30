package dataStructures.exercise14_optimization.scenario3;

import java.util.*;

class DataPoint {
    double[] features;
    double label;

    DataPoint(double[] features, double label) {
        this.features = features;
        this.label = label;
    }
}

class Model {
    double[] weights;

    Model(int numFeatures) {
        this.weights = new double[numFeatures];
        Arrays.fill(this.weights, 0.5);
    }

    double predict(DataPoint dp) {
        double prediction = 0;
        for (int i = 0; i < dp.features.length; i++) {
            prediction += dp.features[i] * this.weights[i];
        }
        return prediction;
    }

    void updateWeights(DataPoint dp, double learningRate) {
        double error = dp.label - predict(dp);
        for (int i = 0; i < dp.features.length; i++) {
            this.weights[i] += learningRate * error * dp.features[i];
        }
    }
}

class Main {
    static List<DataPoint> preprocessData(List<DataPoint> data) {
        // This loop could be optimized by parallelizing the operations
        
        for (DataPoint dp : data) {
            for (int i = 0; i < dp.features.length; i++) {
                dp.features[i] /= 100.0; // Normalize feature to range 0-1
            }
        }
        return data;
    }

    static List<DataPoint> preprocessDataOpt(List<DataPoint> data) {
        data.parallelStream().forEach(dp -> Arrays.parallelSetAll(dp.features, i -> dp.features[i] / 100));
        return data;
    }

    static void trainModel(List<DataPoint> data, Model model, double learningRate, int epochs) {
        // This loop could be optimized by using a more efficient training algorithm
        for (int epoch = 0; epoch < epochs; epoch++) {
            Collections.shuffle(data);
            for (DataPoint dp : data) {
                model.updateWeights(dp, learningRate);
            }
        }
    }

    public static void main(String[] args) {
        List<DataPoint> data = new ArrayList<>();
        // Assume data is filled with some values here
        Model model = new Model(10); // Assume 10 features
        data = preprocessData(data);
        trainModel(data, model, 0.01, 100);
    }
}