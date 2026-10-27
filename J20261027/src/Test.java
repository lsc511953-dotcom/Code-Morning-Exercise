public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,4);
        myArrayList.add(3,6);
        myArrayList.add(4,8);
        myArrayList.add(5,10);

        myArrayList.display();

        System.out.println(myArrayList.get(1));

        System.out.println(myArrayList.size());

        System.out.println(myArrayList.contains(10));

        System.out.println(myArrayList.remove(8));

        myArrayList.display();

        myArrayList.clear();

        myArrayList.display();
    }
}
