import java.util.*;

public class Design_DS_GetRandom {

    Map<Integer,Integer> map;
    static List<Integer> list;

    Design_DS_GetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }


    //for the new DS
    //add, delete, search, getRandom
    public static void main(String[] args) {
        Design_DS_GetRandom d = new Design_DS_GetRandom();
        d.add(10);
        d.add(20);
        d.add(30);

        d.delete(10);

        System.out.println(list);
    }

    void add(int x) {
        //10->20->30
        //[10,0] , [20,1], [30,2]
        int size = list.size();
        list.add(x);
        map.put(x,size);
    }

    int search(int x) {
        if (map.containsKey(x)) {
            return map.get(x);
        }
        return -1;
    }

    //10->20->30
    void delete(int x) {

        //find the index from map
        Integer index = map.get(x);
        map.remove(x);

        //get the last element from list
        int size = list.size();
        int last = list.get(size-1);//30

        //swap the index with the last element
        Collections.swap(list, index, size-1);    //30->20

        //delete the last element from list
        list.remove(size-1);

        //add the element with the swapped index in map
        map.put(last,index);
    }

    int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
