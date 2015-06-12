import java.util.LinkedList;
import java.util.List;

public class PhoneInterview {
// Q1:
// 给一个float[] arr, 无序有dup，去掉最大值和最小值(若重复，只去一个），算平均值
// follow up: 最大值或最小值重复的话，全去掉，算平均值(hashMap)
	
// Q2:
// Array computeMovingAverage(Date startDate, Date endDate, windowSize)
// using the following call
// float getPrice(Date date) 
// example:
// start date = d1
// end date = d5
// [d1 d2 d3 d4 d5] window size = 3   
 
// return [avg(d1,d2,d3), avg(d2,d3,d4), avg(d3,d4,d5)]
// Let's assume this is all for a single security, so no need to expand any declarations
// to have a security argument.  
 
// [d1] window size = 3 (start date = end date = d1)   
// startDate = d1 endDate = d5 windowSize = 3
//
// follow up1: instead of computing averages, we compute rolling minimums [1.0, 2.0, 3.0] 
// follow up2: what if getPrice(i) is expensive;
	 
	 public List<Float> computeAvg (int startDate, int endDate, int windowSize){
	     List<Float> ret = new LinkedList<Float>();
	     // consider edge case
	                                        // 5-3+1 = 3  start [d1] -> [d3] start = d3
	     for(int start = startDate; start <= endDate-windowSize+1; start++){
	         float avgPrice = avg(start, start+windowSize-1);  // avg d1 => d3  to avg d3 => d5
	         ret.add(avgPrice);
	     }
	     return ret;
	 }
	 // 
	 public float avg(int start, int end){
	     if(end < start)    return BAD_VALUE;
	     float sum = (float) 0.0;
	     for(int i = start; i <= end; i++){
	         sum += getPrice(i);//if i is overbounded 
	         }
	         float ret = sum / (float)(end-start+1);
	     }
	 }
}
