/*
Questions

Are the intervals sorted in any way
what if there is no overlapping
Assurity that start time <= endtime ( Relation between start and end time)
[1,3] [ 1,10000] [2,8]
[1,3] [2,8] [1,10000]
[1,8] [1,10000]

Case 1:Overlap
---------------          -----------------
  -----

--------                 ----------------
     ----------

Case 2:No over lap
----------                         ---------------
             ---------------                        -------------
sort it based on start time
start time of 2nd is greater than end time of first then donot merge

*/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalsList = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        for(int [] interval : intervals){
            intervalsList.add(new Interval(interval[0],interval[1]));
        }
        intervalsList.sort((a,b) -> a.startTime - b.startTime);
        Interval cur = intervalsList.get(0);
        for(int i=1;i<intervalsList.size();i++){
            Interval next = intervalsList.get(i);
            if(cur.endTime<next.startTime){
                result.add(cur);
                cur = next;
            }
            else{
                cur.endTime = Math.max(cur.endTime,next.endTime);
            }
        }
        result.add(cur);
        int [][] res = new int [result.size()][2];
        for(int i=0;i<res.length;i++){
            Interval interval = result.get(i);
            res[i][0] = interval.startTime;
            res[i][1] = interval.endTime;
        }
        return res;
    }

    class Interval{
        int startTime;
        int endTime;

        public Interval(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String toString(){
            return "[" + this.startTime + "," + this.endTime + "]";
        }
    }
}

