import java.util.*;

public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        // define variables.
        Stack<Integer> s = new Stack<>();       // holds values of unassigned temp readings.
        HashMap<Integer, Integer> temp_day = new HashMap<>();       // day : temp.
        int[] return_temp = new int[temperatures.length];

        // initalize.
        temp_day.put(0, temperatures[0]);
        s.push(0);

        // go through temperatures.
        for(int i = 1; i < temperatures.length; i++) {

            temp_day.put(i, temperatures[i]);
            // add to stack.
            if(s.isEmpty() || temperatures[i] < s.peek()) {
                s.push(i);
                continue;
            }

            // update stack.
            else if(temperatures[i] > temp_day.get(s.peek())) {
                do {
                    int popped_day = s.pop();
                    return_temp[popped_day] = i - popped_day;
                }
                while(!s.isEmpty() && temperatures[i] > temp_day.get(s.peek()));
            }
        }
        for(int i : return_temp) {
            System.out.println(i);
        }
        return return_temp;
    }
    public static void main(String[] args) {
        DailyTemp d = new DailyTemp();
        int[] temp = {1,1,4,2,1,1,0,0};
        d.dailyTemperatures(temp);
    }
}