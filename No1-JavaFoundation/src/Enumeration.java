import java.util.*;

/**
 * @author Chen Manman
 * @since ${DATE} ${TIME}
 */

class Juice {
    enum FreshJuiceSize {SMALL, MEDIUM, LARGE}

    FreshJuiceSize size;
}

public class Enumeration {
    public static void main(String[] args) {
//        Juice juice = new Juice();
//        juice.size = Juice.FreshJuiceSize.MEDIUM;
//        System.out.println(juice.size);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "value1");
//        map.put("2", "value2");
//        map.put("3", "value3");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        LinkedList<String> list = new LinkedList<>();
        list.add("hhh");
        list.add("ggg");
        list.add("kkk");
        list.addFirst("mmm");
        list.addLast("jjj");
        System.out.println(list.get(2));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.set(1, "chenmm");
        list.remove(2);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}