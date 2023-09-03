import java.util.HashMap;
import java.util.Objects;

public class MutableHashMapKeys {
    public static void main(String[] args) {
        var brokenMap = new HashMap<MutableString, String>();

        var value = "abc";
        var key = new MutableString(value);
        brokenMap.put(key, value);

        System.out.println(brokenMap.get(key));
        System.out.println(brokenMap);

        key.setValue("def");

        System.out.println(brokenMap.get(key));
        System.out.println(brokenMap);
    }

    /*
    * EXAMPLE WHAT NOT TO DO
    * Keys in HashMaps should not be mutable,
    * because if the Key would be changed, then the
    * generated HashCode will change and we will receive
    * a Null Value
    * */

    private static class MutableString {
        private String value;

        public MutableString(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            Objects.requireNonNull(value);
            this.value = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            final MutableString that = (MutableString) obj;
            return value.equals(that.value);
        }

        public int hashCode() {
            return value.hashCode();
        }


        public String toString() {
            return value;
        }
    }
}
