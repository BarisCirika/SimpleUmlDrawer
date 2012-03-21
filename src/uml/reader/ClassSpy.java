package uml.reader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.security.KeyStore.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.omg.Dynamic.Parameter;

import uml.drawer.ClassObject;

public class ClassSpy {

	private String className;
	private Vector<String> parameterTypes;
	private ClassObject classObj;

	public ClassSpy(String className, ClassObject classObj) {
		parameterTypes = new Vector<String>();
		this.classObj = classObj;
		this.className = "uml.reader." + className;
		System.out.println(this.className);
		try {
			Class cls = Class.forName(this.className);
			classObj.setClassName(className);

			Field[] fields = cls.getDeclaredFields();
			for (int i = 1; i <= fields.length; i++) {
				Field f = fields[i - 1];
				String field;
				if (f.getType().toString().contains("String")) {
					classObj.addField(f.getName(), "String");
				} else {
					classObj.addField(f.getType().toString(), f.getName());
				}

			}
			ArrayList<String> methodArray = new ArrayList<String>();
			String returnType;
			Method[] methods = cls.getDeclaredMethods();
			Class[] paramaters;
			String arg;
			for (Method m : methods) {
				methodArray = new ArrayList<String>();
				paramaters = m.getParameterTypes();
				if (paramaters.length > 0) {
					for (int j = 0; j < paramaters.length; j++) {
						arg = "arg" + j;
						if (paramaters[j].toString().contains("String")) {
							methodArray.add(arg + ":String");
						} else {
							methodArray.add((arg + ":" + paramaters[j]
									.toString()));
						}
					}
				}
				if (m.getReturnType().toString().contains("String")) {
					returnType = "String";
				} else {
					returnType = m.getReturnType().toString();
				}

				classObj.addMethod(returnType, m.getName(), methodArray);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong Class Name");
		}
	}
}
