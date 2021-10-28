package c1114_按序打印;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
  static class Foo {
    private AtomicBoolean signal1 = new AtomicBoolean(false);
    private AtomicBoolean signal2 = new AtomicBoolean(false);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {

      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      signal1.getAndSet(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
      while (!signal1.get()) {}
      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      signal2.getAndSet(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
      while (!signal2.get()) {}
      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
    }
  }
}
