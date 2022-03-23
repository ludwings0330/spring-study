package com.example.springstudy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    interface Introduce {
        void introduce();
        void introduceV2();
    }

    static class IntroduceImpl implements Introduce {
        @Override
        public void introduce() {
            System.out.println("my name is Ludwings.");
        }

        @Override
        public void introduceV2() {
            System.out.println("my name is Changmin bae");
        }
    }

    static class IntroduceProxyHandler implements InvocationHandler {
        private final Introduce target;

        public IntroduceProxyHandler(Introduce target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            hello();
            method.invoke(target, args);
            bye();
            return null;
        }

        private void hello() {
            System.out.println("hello");
        }

        private void bye() {
            System.out.println("bye");
        }
    }

    @Test
    public void test() throws Exception {
        final IntroduceImpl introduce = new IntroduceImpl();
        final IntroduceProxyHandler handler = new IntroduceProxyHandler(introduce);

        final Introduce introduceProxy = (Introduce) Proxy.newProxyInstance(
                                                                Introduce.class.getClassLoader(),
                                                                new Class[]{Introduce.class},
                                                                handler);

        introduceProxy.introduce();
        introduceProxy.introduceV2();
    }

}
