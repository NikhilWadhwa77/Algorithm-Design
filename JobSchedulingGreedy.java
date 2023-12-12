package ADI.Algorithms.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class jobs{

    String jobId;
    int deadline;
    int profit;

    jobs(String jobId, int deadline, int profit){
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }

}

public class JobScheduling {
    public static void main(String[] args) {

//        sample input
//        a 2 100
//        b 1 19
//        c 2 27
//        d 1 25
//        e 3 15

        Scanner sc = new Scanner(System.in);

//      number of jobs
        int n = sc.nextInt();

//      arraylist to add number of jobs in form of object
        ArrayList<jobs> data = new ArrayList<>();

//      taking jobs input and storing them in data (arraylist)
        for(int i = 0; i < n; i++){
            data.add(new jobs(sc.next(),sc.nextInt(),sc.nextInt()));
        }

//      Comparator to sort jobs on basis of the profits of each job in ascending order
        data.sort(Comparator.comparing(value -> value.profit));

        int maxDead = 0;

//        for loop [O(n)] to find the max Deadline among all the jobs
        for(jobs i : data){
//          sout to print sorted data
            System.out.println(i.jobId + " " + i.deadline + " " + i.profit);
            if(i.deadline > maxDead){
                maxDead = i.deadline;
            }
        }

//        System.out.println(maxDead);

//      new "Job Scheduling Array" to store maximum profits on basis of there deadlines
        int[] arr = new int[maxDead];

//      Main logic (easily understandable)
        for(int i = data.size() - 1; i >= 0; i--){

            int currentDead = data.get(i).deadline - 1;

            if(arr[currentDead] == 0){
                arr[currentDead] = data.get(i).profit;
            }
            else{
                int j = currentDead - 1;
                while(j > 0 && arr[j] != 0){
                    j--;
                }
                if(j >= 0 && arr[j] == 0){
                    arr[j] = data.get(i).profit;
                }
            }
        }

//      sout array that contains profit
        System.out.println(Arrays.toString(arr));

//        for printing "Total Profit"
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
