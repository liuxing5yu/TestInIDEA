package lang.arch;

import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author hwj
 * @date 2018/11/8 14:04
 */
public class TestArchUitls {
	public static void main(String[] args) {
		Processor processor = ArchUtils.getProcessor();
		System.out.println(ToStringBuilder.reflectionToString(processor));
		System.out.println(ReflectionToStringBuilder.toString(processor,new RecursiveToStringStyle()));
	}
}
