// 最优解法应该是Segmet Tree
// https://leetcode.com/problems/design-phone-directory/discuss/119330/My-segment-tree-solution
class PhoneDirectory {
    PhoneList phoneList;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        phoneList = new PhoneList(maxNumbers);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        return phoneList.getNumber();
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return phoneList.checkIndex(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        phoneList.releaseIndex(number);
    }
}

class PhoneList{
    int[] list;

    public PhoneList(int max){
        list = new int[max];
    }
    
    public int getNumber(){
        for(int i = 0; i < list.length; i++){
            if(list[i] == 0){
                list[i] = 1;
                return i;
            }
        }
        return -1;
    }
    
    public boolean checkIndex(int num){
        if(list[num] == 0)  return true;
        return false;
    }
    
    public void releaseIndex(int num){
        if(list[num] == 1)
            list[num] = 0;
        return;
    }
}