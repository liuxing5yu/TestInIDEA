package xstream;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class XStreamTester {
	public static void main(String args[]) {
		XStreamTester tester = new XStreamTester();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}

		});

		Student student = new Student("Mahesh", "Parashar");

		// xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("student", Student.class);

		System.out.println(xstream.toXML(student));

	}
}

