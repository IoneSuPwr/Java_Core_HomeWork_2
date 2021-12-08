public class MyArrayDataExc extends Exception {
    public int i;
    public int j;

    MyArrayDataExc(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
