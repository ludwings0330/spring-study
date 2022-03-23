package com.example.springstudy;


import org.junit.jupiter.api.Test;

public class JavaProxy {
    interface Introduce {
        void introduce();
    }

    static class IntroduceImpl implements Introduce {
        @Override
        public void introduce() {
            System.out.println("my name is ludwings.");
        }
    }

    static class IntroduceProxy implements Introduce {
        Introduce target = new IntroduceImpl();

        @Override
        public void introduce() {
            hello();
            target.introduce();
            bye();
        }

        public void hello () {
            System.out.println("hello");
        }

        public void bye() {
            System.out.println("bye");
        }
    }



    @Test
    public void test() throws Exception {
        Introduce introduce = new IntroduceProxy();
        introduce.introduce();
    }
}
