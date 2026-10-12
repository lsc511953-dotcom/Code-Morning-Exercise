import javax.management.MBeanAttributeInfo;

public class Test {
    public static void main(String[] args) {
        MySingleList<Integer> singleList = new MySingleList<>();
        singleList.add(0,4);
        singleList.add(1,5);
        singleList.add(2,8);
        singleList.add(3,4);

        singleList.display();

        System.out.println(singleList.size());

        singleList.removeAllKeys(4);
        singleList.display();
    }
}
