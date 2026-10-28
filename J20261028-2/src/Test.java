public class Test {
    public static void main(String[] args) {
        MySingleList<Integer> mySingleList = new MySingleList<>();
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(3);
        mySingleList.addLast(4);

        mySingleList.removeAllKeys(3);

        mySingleList.display();
    }
}
