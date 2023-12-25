package ADI.Algorithms.Greedy;

import java.util.*;

class items {
    double ratio;
    double profit;
    double weight;

    items(double ratio, double profit, double weight){
        this.ratio = ratio;
        this.profit = profit;
        this.weight = weight;
    }
}

public class KnapSack {
    public static void main(String[] args) {
        int n = 3;

        double[] profits = {120,100,60};
        double[] weight = {17,13,8};

        double maxWeight = 20;

        double res = 0; 

        ArrayList<items> data = new ArrayList<>();

        for(int i = 0; i < n; i++){
            double ratio = profits[i]/weight[i];
            data.add(new items(ratio,profits[i],weight[i]));
        }

//        Collections.sort(data);
        data.sort(Comparator.comparingDouble(value -> value.ratio));
//        Collections.sort(data,Comparator.comparingDouble(value -> value.ratio));


        for(items i : data){
            System.out.println(i.ratio + " " + i.profit + " " + i.weight);
        }

        for(int i = data.size() -1; i >= 0; i--){
            if(maxWeight <= 0){
                break;
            }
            if(data.get(i).weight <= maxWeight){
                res += data.get(i).profit;
                maxWeight -= data.get(i).weight;
            }
            else if(data.get(i).weight > maxWeight){
                res += maxWeight * data.get(i).ratio;
                maxWeight = 0;
            }
        }
        System.out.println(res);


    }
}
