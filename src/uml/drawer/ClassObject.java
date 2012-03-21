package uml.drawer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ClassObject extends JPanel {
	
	private double startingX = 10;
	private double startingY = 80;
	private double width = 200;
	private int lineHeight = 30;
	private int widhtArrange=0;
	
	private String className;
	private ArrayList<Field> fields;
	private ArrayList<Method> methods;

	public ClassObject() {
		fields = new ArrayList<Field>();
		methods = new ArrayList<Method>();
	}
	
	public void setClassName(String name) {
		this.className = name;
	}

	public void addField(String type, String name) {
		Field field = new Field(type, name);
		fields.add(field);
	}
	
	public void addMethod(String returnType, String name, ArrayList<String> params) {
		Method method = new Method(returnType, name, params);
		methods.add(method);
	}
	
	public void print()
	{
		System.out.println(fields.size());
		for (Field field : fields) {
			System.out.println(field.getName() + field.getType());
		}
	}
	public void arrangeWidht(){
		
	}

	@Override
	public void paint(Graphics g) {
		
		int max=methods.get(0).getParameters().size();
		double classNameAreaHeight = 1 * lineHeight;
		double fieldsAreaHeight = fields.size() * lineHeight;
		double methodsAreaHeight = methods.size() * lineHeight;
		for (int i = 1; i < methods.size(); i++) {
			if(max<methods.get(i).getParameters().size()){
				widhtArrange=40;
				widhtArrange*=methods.get(i).getParameters().size();
				max=methods.get(i).getParameters().size();
			}
		}
		width+=widhtArrange;
		Graphics2D g2 = (Graphics2D)g; 
	    Rectangle2D classArea = new Rectangle2D.Double(startingX, startingY, width, classNameAreaHeight); 
	    g2.draw(classArea); 
	    
	    
	    Rectangle2D fieldArea = new Rectangle2D.Double(startingX,startingY+classNameAreaHeight,width, fieldsAreaHeight); 
	    g2.draw(fieldArea);
	    
	    Rectangle2D methodArea = new Rectangle2D.Double(startingX,startingY+classNameAreaHeight+fieldsAreaHeight,width, methodsAreaHeight); 
	    g2.draw(methodArea);
	    
	    Font font1 = new Font("Serif",Font.PLAIN,13); 
	    g2.setFont(font1); 
	    g2.drawString(className,(int)(startingX + 10),(int)(startingY + 20)); 
	    
	    
	    int i = 1;
	    for (Field field : fields) {
	    	g2.drawString(field.getType() + " : " + field.getName(),(int)(startingX + 10),(int)(startingY + classNameAreaHeight + 20 + i));
	    	i += lineHeight;
		}
	    
	    for (Method method : methods) {
	    	
	    	StringBuilder fullMethodName = new StringBuilder();
	    	fullMethodName.append(method.getName());
	    	
	    	fullMethodName.append("(");
	    	int size = method.getParameters().size();
	    	int y = 0;
	    	for (String param : method.getParameters()) {
	    		fullMethodName.append(param);
	    		y++;
	    		
	    		if(y < size) {
	    			fullMethodName.append(",");
	    		}
			}
	    	fullMethodName.append(")");
	    	
	    	fullMethodName.append(" : ");
	    	fullMethodName.append(method.getReturnType());
	    	
	    	g2.drawString(fullMethodName.toString(),(int)(startingX + 10),(int)(startingY + classNameAreaHeight + 20 + i));
	    	i += lineHeight;
		}
	    

	    //super.paint(g);
	}
}
