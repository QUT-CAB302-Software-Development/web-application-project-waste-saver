package example.data;

public class Counter {
    private int count;

    public Counter(int i){
        this.count = i;
    }

    public Counter(){
        this.count = 1;
    }
    public void setCount(int i){
        this.count = i;
    }

    public int get(){
        return count;
    }

    public void clear(){
        count = 1;
    }

    public int getAndCount(){
        return count++;
    }

    @Override
    public String toString(){
        return "" + count;
    }
}
