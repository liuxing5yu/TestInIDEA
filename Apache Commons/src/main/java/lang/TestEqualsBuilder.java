package lang;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author hwj
 * @date 2019/3/13 10:25
 */
public class TestEqualsBuilder {

    @Test
    public void test1() {
        boolean equals = new EqualsBuilder().append(1, 1).append(new Date(), new Date()).isEquals();
        System.out.println(equals);
    }

    @Test
    public void testReflectionEquals() {
        final TestObject o1 = new TestObject(4);
        final TestObject o2 = new TestObject(5);
        assertTrue(EqualsBuilder.reflectionEquals(o1, o1));
        assertFalse(EqualsBuilder.reflectionEquals(o1, o2));
        o2.setA(4);
        assertTrue(EqualsBuilder.reflectionEquals(o1, o2));

        assertFalse(EqualsBuilder.reflectionEquals(o1, this));

        assertFalse(EqualsBuilder.reflectionEquals(o1, null));
        assertFalse(EqualsBuilder.reflectionEquals(null, o2));
        assertTrue(EqualsBuilder.reflectionEquals(null, null));
    }

    static class TestObject {
        private int a;

        TestObject() {
        }

        TestObject(final int a) {
            this.a = a;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null) {
                return false;
            }
            if (o == this) {
                return true;
            }
            if (o.getClass() != getClass()) {
                return false;
            }

            final TestObject rhs = (TestObject) o;
            return a == rhs.a;
        }

        @Override
        public int hashCode() {
            return a;
        }

        public void setA(final int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }
    }
}
