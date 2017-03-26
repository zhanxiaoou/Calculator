package com.example.calculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	/*double sum = 0;//记录最终结果，默认为0
	double data1 = 0;//记录待处理数据1(运算符之前)，默认为0
	double data2 = 0;//记录待处理数据2（运算符之后），默认为0
	int option = 0;//记录运算符状态，默认为0
	int point = 0;//记录是否有小数，默认为0
	int state = 0;//state有两个作用：当输入数字时state==1,需先文本框重置为0，再获取按钮字符；当输入运算符时state==1,需将运算符状态重置为0。
	int back = 0;//只有back为零时，才允许退格。*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		//创建activity页面，隐藏标题栏
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		//按钮数字1
		Button button1 = (Button)findViewById(R.id.number1);
		button1.setOnClickListener(onclicklistener);
		button1.setOnTouchListener(ontouchlistener);
		//按钮数字2
		Button button2 = (Button)findViewById(R.id.number2);
		button2.setOnClickListener(onclicklistener);
		button2.setOnTouchListener(ontouchlistener);
		//按钮数字3
		Button button3 = (Button)findViewById(R.id.number3);
		button3.setOnClickListener(onclicklistener);
		button3.setOnTouchListener(ontouchlistener);
		//按钮数字4
		Button button4 = (Button)findViewById(R.id.number4);
		button4.setOnClickListener(onclicklistener);
		button4.setOnTouchListener(ontouchlistener);
		//按钮数字5
		Button button5 = (Button)findViewById(R.id.number5);
		button5.setOnClickListener(onclicklistener);
		button5.setOnTouchListener(ontouchlistener);
		//按钮数字6
		Button button6 = (Button)findViewById(R.id.number6);
		button6.setOnClickListener(onclicklistener);
		button6.setOnTouchListener(ontouchlistener);
		//按钮数字7
		Button button7 = (Button)findViewById(R.id.number7);
		button7.setOnClickListener(onclicklistener);
		button7.setOnTouchListener(ontouchlistener);
		//按钮数字8
		Button button8 = (Button)findViewById(R.id.number8);
		button8.setOnClickListener(onclicklistener);
		button8.setOnTouchListener(ontouchlistener);
		//按钮数字9
		Button button9 = (Button)findViewById(R.id.number9);
		button9.setOnClickListener(onclicklistener);
		button9.setOnTouchListener(ontouchlistener);
		//按钮数字0
		Button button0 = (Button)findViewById(R.id.number0);
		button0.setOnClickListener(onclicklistener);
		button0.setOnTouchListener(ontouchlistener);
		//按钮“+”
		Button buttonplus = (Button)findViewById(R.id.plus);
		buttonplus.setOnClickListener(onclicklistener);
		buttonplus.setOnTouchListener(ontouchlistener);
		//按钮“-”
		Button buttonminus = (Button)findViewById(R.id.minus);
		buttonminus.setOnClickListener(onclicklistener);
		buttonminus.setOnTouchListener(ontouchlistener);
		//按钮“*”
		Button buttontimes = (Button)findViewById(R.id.times);
		buttontimes.setOnClickListener(onclicklistener);
		buttontimes.setOnTouchListener(ontouchlistener);
		//按钮“/”
		Button buttondivided = (Button)findViewById(R.id.divided);
		buttondivided.setOnClickListener(onclicklistener);
		buttondivided.setOnTouchListener(ontouchlistener);
		//按钮"."
		Button buttondecimal = (Button)findViewById(R.id.decimal);
		buttondecimal.setOnClickListener(onclicklistener);
		buttondecimal.setOnTouchListener(ontouchlistener);
		//按钮"="
		Button buttonis = (Button)findViewById(R.id.is);
		buttonis.setOnClickListener(onclicklistener);
		buttonis.setOnTouchListener(ontouchlistener);
		//按钮"AC"
		Button buttonclean = (Button)findViewById(R.id.clean);
		buttonclean.setOnClickListener(onclicklistener);
		buttonclean.setOnTouchListener(ontouchlistener);
		//按钮"Back"
		Button buttonback = (Button)findViewById(R.id.back);
		buttonback.setOnClickListener(onclicklistener);
		buttonback.setOnTouchListener(ontouchlistener);
		//按钮"Back"
		Button buttonleft = (Button)findViewById(R.id.left);
		buttonleft.setOnClickListener(onclicklistener);
		buttonleft.setOnTouchListener(ontouchlistener);
		//按钮"Back"
		Button buttonright = (Button)findViewById(R.id.right);
		buttonright.setOnClickListener(onclicklistener);
		buttonright.setOnTouchListener(ontouchlistener);
	}
	
	//实例化监听器ontouchlistener
	OnTouchListener ontouchlistener = new OnTouchListener(){		
		//按钮点击时颜色变化
		public boolean onTouch(View v,MotionEvent event){			
			Button b = (Button) v;//实例化按钮对象,b即button

			if(b.getId()==R.id.number1 || b.getId()==R.id.number2 || b.getId()==R.id.number3 || 
			   b.getId()==R.id.number4 || b.getId()==R.id.number5 || b.getId()==R.id.number6 || 
			   b.getId()==R.id.number7 || b.getId()==R.id.number8 || b.getId()==R.id.number9 || 
			   b.getId()==R.id.number0 || b.getId()==R.id.decimal || b.getId()==R.id.back    || 
			   b.getId()==R.id.plus    || b.getId()==R.id.minus   || b.getId()==R.id.times   || 
			   b.getId()==R.id.divided || b.getId()==R.id.is      || b.getId()==R.id.clean   ||
			   b.getId()==R.id.left || b.getId()==R.id.right){
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					b.setBackgroundResource(R.drawable.frame_touch);
				}				
				if(event.getAction()==MotionEvent.ACTION_UP){
					b.setBackgroundResource(R.drawable.frame);
				}							
			}						
			return false;			
		}};
	
	//实例化监听器onclicklistener
	OnClickListener onclicklistener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			EditText expression = (EditText)findViewById(R.id.expression);//表达式文本框
			TextView result = (TextView)findViewById(R.id.result);//结果文本框
			String e = expression.getText().toString();//获取文本框的字符串，t即text
			Button b = (Button) v;//实例化按钮对象,b即button
		
		//组成表达式	
		//输入数字、小数点、运算符、右括号时
		if(b.getId()==R.id.number1 || b.getId()==R.id.number2 || b.getId()==R.id.number3 || 
		   b.getId()==R.id.number4 || b.getId()==R.id.number5 || b.getId()==R.id.number6 || 
		   b.getId()==R.id.number7 || b.getId()==R.id.number8 || b.getId()==R.id.number9 || 
		   b.getId()==R.id.number0 || b.getId()==R.id.decimal || b.getId()==R.id.plus    || 
		   b.getId()==R.id.minus   || b.getId()==R.id.times   || b.getId()==R.id.divided ||
		   b.getId()==R.id.left    || b.getId()==R.id.right){
			//特殊情况，点击左括号按钮，若此时字符串最后一个字符为数字或者右括号，先自动添加乘号，然后再添加左括号
			if(e.length() >= 1 && b.getId()==R.id.left){
				char c = e.charAt(e.length()-1);
				if(c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||
				   c=='7'||c=='8'||c=='9'||c=='0'||c==')'){
					e = e+"*"+b.getText();					
				}
				//直接添加字符
				else
					e = e+b.getText();				
			}
			else
				e = e+b.getText();
			
			result.setText("0");
			expression.setText(e);
			expression.setSelection(e.length());
		}	
		//点击等于号按钮时，计算出结果
		if(b.getId()==R.id.is){
			try{
				double sum = arithmetic(e);
				if(sum==0.0d){//结果为0.0d时，文本框展示为"0"
					result.setText("0");
					expression.setText("");
				}	
				else if(sum%1 == 0.0d){//结果没有小数时，文本框展示为整数
					DecimalFormat form = new DecimalFormat("#");
					result.setText(form.format(sum));
					expression.setText("");
				}	
				else//按实际结果展示
					result.setText(String.valueOf(sum));
					expression.setText("");
			}
			catch(NumberFormatException n){
				result.setText("算式有误");
				expression.setText("");
			}
			catch(ArithmeticException a){
				result.setText("0不能作除数");
				expression.setText("");
			}
		}		
		//全清
		if(b.getId()==R.id.clean){
			result.setText("0");
			expression.setText("");
		}
		//退格
		if( b.getId()==R.id.back){
			try{
				result.setText("0");
				e = e.substring(0, e.length()-1);
				expression.setText(e);
				expression.setSelection(e.length());
			}
			catch(StringIndexOutOfBoundsException s){
				result.setText("0");
				expression.setText("");
			}
		}			
	}};
				
	//四则运算方法,依次对字符串中（）、+、-、*、/符号进行查找——拆分——计算，从而完成四则运算。此处运用到递归的思想。
	public static double arithmetic(String context){
		int index; 
		BigDecimal b1;
		BigDecimal b2;
		
		//“()”,由里及外查找括号，先查找最右边的“(”，然后查找与之对应的“)”
		index = context.lastIndexOf("(");
		if(index != -1){
			int rightindex = context.indexOf(")",index);
			return arithmetic(context.substring(0, index)+arithmetic(context.substring(index+1,rightindex))+context.substring(rightindex+1));			
		}
		//到此处，表示此时字符串中已无“()”
		
		//“+”
		index = context.indexOf("+");
		if(index != -1){
			b1 = new BigDecimal(arithmetic(context.substring(0, index)));
			b2 = new BigDecimal(arithmetic(context.substring(index+1)));
			
			return b1.add(b2).doubleValue();			
		}
		//到此处，表示此时字符串中已无“+”
		
		//“-”
		index = context.lastIndexOf("-");
		if(index != -1){
			b1 = new BigDecimal(arithmetic(context.substring(0, index)));
			b2 = new BigDecimal(arithmetic(context.substring(index+1)));
			
			return b1.subtract(b2).doubleValue();	
		}
		//到此处，表示此时字符串中已无“-”
		
		//“*”
		index = context.indexOf("x");
		if(index != -1){
			b1 = new BigDecimal(arithmetic(context.substring(0, index)));
			b2 = new BigDecimal(arithmetic(context.substring(index+1)));
			
			return b1.multiply(b2).doubleValue();			
		}
		//到此处，表示此时字符串中已无“*”
		
		//“/”
		index = context.lastIndexOf("÷");
		if(index != -1){
			b1 = new BigDecimal(arithmetic(context.substring(0, index)));
			b2 = new BigDecimal(arithmetic(context.substring(index+1)));
				
			return b1.divide(b2,10,BigDecimal.ROUND_DOWN).doubleValue(); 	
		}
		//到此处，表示此时字符串中已无“/”
		
		
		return Double.parseDouble(context);
	}
	
	/*//实例化监听对象onclicklistener
	OnClickListener onclicklistener = new OnClickListener(){
		
		@Override
		public void onClick(View v) {
				
		TextView text = (TextView)findViewById(R.id.textview);//实例化文本框对象
		String t = text.getText().toString();//获取文本框的字符串，t即text
		Button b = (Button) v;//实例化按钮对象,b即button
		
		//输入数字（数字0-9，小数点）
		if(b.getId()==R.id.number1 || b.getId()==R.id.number2 || b.getId()==R.id.number3 || 
		   b.getId()==R.id.number4 || b.getId()==R.id.number5 || b.getId()==R.id.number6 || 
		   b.getId()==R.id.number7 || b.getId()==R.id.number8 || b.getId()==R.id.number9 || 
		   b.getId()==R.id.number0 || b.getId()==R.id.decimal){//分两种情况，数字或者小数点
			
			if(state==1){//当输入数字时state==1,需先文本框重置为0，再获取按钮字符；
			   t = "0";
			   state = 0;
		    }
			
			if(t.length()<11){//文本框字符串长度小于等于11位时
				
				if(b.getId()!=R.id.decimal){//输入数字时
					if(t.equals("0")){
						//当文本框为零，将0替换为获取到的按钮字符
						t=(String) b.getText();
					}

					else//文本框不为零，直接将获取到的按钮字符添加到文本框字符串后面
						t=t+b.getText();
						
				}
				else{//输入小数点时，如果point == 0（即当前没有小数点）则添加小数点，反之不作任何操作（即不再重复添加小数点）。			
					if(point == 0)
						t=t+b.getText();
						point = 1;			
				}				
			}			
			text.setText(t);//文本框展示出最新的字符串
			back=0;
		}
						
		//输入退格符号
		if(b.getId()==R.id.back){
			if(back==0){
				//先判断文本框文本是否为空
				if(t.equals("")||t==null){
					text.setText("0");
				}
				else{
					t=t.substring(0,t.length()-1);//退格自减字符
					
					//当退格之后字符串长度是否为零
					if(t.length()==0){
						
					text.setText("0");
						
					}
					else//否则直接打印出字符串
						text.setText(t);				
				}					
			}
			else
				text.setText(t);
		}
			
		//输入运算符（加减乘除）
		if(b.getId()==R.id.plus || b.getId()==R.id.minus || b.getId()==R.id.times || b.getId()==R.id.divided){
			if(state == 1 ){
				option = 0;
			}
			//当运算符状态不为1时，进行计算，此时运算符作用相当于等号
			if(option!=0){
				//将当前文本框数据赋值给data2
				try{//当t==null时，Double.valueOf(t)会抛出NumberFormatException
					data2 = Double.valueOf(t);
					BigDecimal b1 = new BigDecimal(Double.toString(data1));
					BigDecimal b2 = new BigDecimal(Double.toString(data2));
					
					switch (option){
						case 1:
							//fault = b1.add(b2);
							sum = b1.add(b2).doubleValue();
							//sum = data1 + data2;
							break;
						case 2:
							//fault = b1.subtract(b2);
							sum = b1.subtract(b2).doubleValue();
							//sum = data1 - data2;
							break;
						case 3:
							//fault = b1.multiply(b2);
							sum = b1.multiply(b2).doubleValue();
							//sum = data1 * data2;
							break;
						case 4:
							if(data2==0){
								Toast.makeText(MainActivity.this,"0不能作除数",Toast.LENGTH_LONG).show();
								sum = 0;
							}
							else
								//fault = b1.divide(b2);
								sum= b1.divide(b2,10,BigDecimal.ROUND_DOWN).doubleValue(); 	
								//sum=data1/data2;
							break;			
					}					
					*//**if(option==1){//加
						sum = data1 + data2;
						
					}
					if(option==2){//减
						sum = data1 - data2;
						
					}
					if(option==3){//乘
						sum = data1 * data2;
	
					}
					if(option==4){//除
						if(data2==0){
							Toast.makeText(MainActivity.this,"0不能作除数",Toast.LENGTH_SHORT).show();
							sum = 0;						
						}
						else
						sum=data1/data2;						
					}*//*
					//sum = fault.doubleValue();					
					data1 = sum;
					state = 1;
					//此处没有将option重置为0，是因为接下去会根据实际按钮对象重置option
					
					if(sum==0.0d)//结果为0.0d时，文本框展示为"0"
						text.setText("0");
					else if(sum%1 == 0.0d){//结果没有小数时，文本框展示为整数
						DecimalFormat form = new DecimalFormat("#");
						text.setText(form.format(sum));
					}	
					else{//按实际结果展示
						text.setText(String.valueOf(sum));

					}
				}
				catch(NumberFormatException e){//当Double.valueOf(t)会抛出NumberFormatException，执行下方语句										
					*//**String s = null;
					if(b.getId()==R.id.plus)
						s="+";
								
					if(b.getId()==R.id.minus)
						s="-";
								
					if(b.getId()==R.id.times)
						s="x";
								
					if(b.getId()==R.id.divided)
						s="÷";
					
					text.setText(s);
					*//*										
					text.setText("0");
					state = 1;															
				}
			}	
			
			//当option为零时，将当前文本框中字符串赋值给data1
			else{				
				try{//当t==null时，Double.valueOf(t)会抛出NumberFormatException
					data1 = Double.valueOf(t);
					*//**String s = null;
					if(b.getId()==R.id.plus)
						s="+";
								
					if(b.getId()==R.id.minus)
						s="-";
								
					if(b.getId()==R.id.times)
						s="x";
								
					if(b.getId()==R.id.divided)
						s="÷";
					
					text.setText(s);
					*//*										
					text.setText(t);
					state = 1;
				}
				catch(NumberFormatException e){//当Double.valueOf(t)会抛出NumberFormatException，执行下方语句
					text.setText(t);
					state = 1;
				}
			}
			//根据输入的运算符重置option	
			if(b.getId()==R.id.plus)
				option=1;
						
			if(b.getId()==R.id.minus)
				option=2;
						
			if(b.getId()==R.id.times)
				option=3;
						
			if(b.getId()==R.id.divided)
				option=4;			
			point = 0;
			back = 1;//点击运算符后，文本框内容不允许退格
		}
		
		//输入等于号
		if(b.getId()==R.id.is){
		 	
			//当option不为零时根据option进行相应计算
			if(option!=0){
				
				try{
				data2 = Double.valueOf(t);
				BigDecimal b1 = new BigDecimal(Double.toString(data1));
				BigDecimal b2 = new BigDecimal(Double.toString(data2));
				
				switch (option){
					case 1:
						sum = b1.add(b2).doubleValue();
						//sum = data1 + data2;
						break;
					case 2:
						sum = b1.subtract(b2).doubleValue();
						//sum = data1 - data2;
						break;
					case 3:
						sum = b1.multiply(b2).doubleValue();
						//sum = data1 * data2;
						break;
					case 4:
						if(data2==0){
							Toast.makeText(MainActivity.this,"0不能作除数",Toast.LENGTH_LONG).show();
							sum = 0;
						}
						else
						sum= b1.divide(b2,10,BigDecimal.ROUND_DOWN).doubleValue(); 	
						//sum=data1/data2;							
						break;			
				}
				
				data1 = sum;
				option = 0;
				state = 1;
								
				if(sum==0.0d)//结果为0.0d时，文本框展示为"0"
					text.setText("0");
				else if(sum%1 == 0.0d){//结果没有小数时，文本框展示为整数
					DecimalFormat form = new DecimalFormat("#");
					text.setText(form.format(sum));
					}	
				else//按实际结果展示
					text.setText(String.valueOf(sum));					
				}
				catch(NumberFormatException e){					
					text.setText(t);
					state = 1;
				}
			}	
			
			//option为零，直接展示文本框数据
			else{					
				text.setText(t);
				state = 1;
			}
			back = 1;//点击等号，运算结果不允许退格
		}
		
		//输入清零符号：将所有全局变量重置为0，文本框归零
		if(b.getId()==R.id.clean){
			sum = 0;
			data1 = 0;
			data2 = 0;
			option = 0;
			point = 0;
			state = 0;
			back = 0;
			
			text.setText("0");//文本框归零
		}
	}};*/


	
}
