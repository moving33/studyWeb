package com.j.ch14.di.lookUp;
import java.util.concurrent.atomic.AtomicLong;

public class Pizza {
    // thread에 안전한 lock이 걸려있지 않은 단일변수
    // 위 변수는 Pizza 클래스를 생성하더라도 참고하는 값은 이미 메모리에 잡혀 있는 영역을 참조한다.
    private static AtomicLong count = new AtomicLong(0);
    private boolean isVeg;

    public Pizza() {
        System.out.println("Pizza Create");
        count.incrementAndGet();
    }

    public String toString(){
        return "A new "+(isVeg ? "veggie" : "")+"Pizza, count ("+count.get()+")"+"/ hashCode : "+this.hashCode()+" /count HashCode :"+count.hashCode();

    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }

    public static AtomicLong getCount() {
        return count;
    }

    public static void setCount(AtomicLong count) {
        Pizza.count = count;
    }

    public boolean isVeg() {
        return isVeg;
    }
}

