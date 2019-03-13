package lang;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;

import java.util.Date;

/**
 * @author hwj
 * @date 2019/3/13 10:25
 */
public class TestEqualsBuilder {

	@Test
	public void test1(){
		boolean equals = new EqualsBuilder().append(1, 1).append(new Date(),new Date()).isEquals();
		System.out.println(equals);
	}
}
