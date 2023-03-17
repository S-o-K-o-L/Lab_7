package src.logic;

import src.annotation.Config;
import src.annotation.Property;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ConfigService {
    public static <T> T load(Class<T> clazz) {
        if (clazz.isAnnotationPresent(Config.class) && clazz.isInterface()) {
            Config config = clazz.getAnnotation(Config.class);
            Properties properties = new Properties();
            InputStream reader = ConfigService.class
                    .getClassLoader()
                    .getResourceAsStream(config.path());
            try {
                properties.load(reader);
                Reflections reflections = new Reflections(
                        new ConfigurationBuilder()
                                .forPackage("src")
                                .setScanners(Scanners.SubTypes));
                Class<? extends T> implementationClass = reflections.getSubTypesOf(clazz)
                        .stream()
                        .findFirst()
                        .orElse(null);
                T implClass = implementationClass.getConstructor().newInstance();
                Field[] fields = implementationClass.getDeclaredFields();
                for (var field : fields) {
                    if (field.getType().equals(Properties.class)) {
                        field.setAccessible(true);
                        field.set(implClass, properties);
                    }
                }
                return implClass;
            } catch (IOException | IllegalAccessException | NoSuchMethodException |
                     InstantiationException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private static class ConfigInvocationHandler implements InvocationHandler {

        private final Properties properties;

        public ConfigInvocationHandler(Properties properties) {
            this.properties = properties;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Property propertyAnnotation = method.getAnnotation(Property.class);
            if (propertyAnnotation == null) {
                throw new IllegalArgumentException("Property annotation not found");
            }

            String key = propertyAnnotation.value();
            String value = properties.getProperty(key);
            if (value == null) {
                throw new IllegalArgumentException("Property value not found for key: " + key);
            }

            Class<?> returnType = method.getReturnType();
            if (returnType == String.class) {
                return value;
            } else if (returnType == boolean.class) {
                return Boolean.parseBoolean(value);
            } else if (returnType == int.class) {
                return Integer.parseInt(value);
            } else if (returnType == long.class) {
                return Long.parseLong(value);
            } else if (returnType == float.class) {
                return Float.parseFloat(value);
            } else if (returnType == double.class) {
                return Double.parseDouble(value);
            } else {
                throw new IllegalArgumentException("Unsupported property type: " + returnType);
            }
        }
    }
}
