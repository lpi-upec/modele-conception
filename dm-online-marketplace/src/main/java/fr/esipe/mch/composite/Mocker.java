package fr.esipe.mch.composite;

import java.lang.reflect.Proxy;

public class Mocker {
    public static <T> T createMock(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new MockerInvocationHandler()
        );
    }

    public static <T> T verify(T mock, Comparable<Integer> comparable){
        return null;
    }

    public static <V> DoReturnBuilder<V> doReturn(V value) {
        return null;
    }

    public static class DoReturnBuilder<V> {
        private final V value;

        public DoReturnBuilder(V value){
            this.value = value;
        }
    }
}
