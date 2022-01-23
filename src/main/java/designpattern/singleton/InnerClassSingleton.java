package designpattern.singleton;

public class InnerClassSingleton {
    private static class InnerClassInstance {
        private static InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        // 禁止反射机制创建多实例
        if (InnerClassInstance.innerClassSingleton != null) {
            throw new RuntimeException("InnerClassSingleton already exist!");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassInstance.innerClassSingleton;
    }


}
