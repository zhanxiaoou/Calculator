package com.example.calculator;



import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	double sum = 0;//记录最终结果，默认为0
	//BigDecimal fault;

	double data1 = 0;//记录待处理数据1(运算符之前)，默认为0
	double data2 = 0;//记录待处理数据2（运算符之后），默认为0
	int option = 0;//记录运算符状态，默认为0
	int point = 0;//记录是否有小数，默认为0
	int state = 0;//state有两个作用：当输入数字时state==1,需先文本框重置为0，再获取按钮字符；当输入运算符时state==1,需将运算符状态重置为0。
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		//创建activity页面，隐藏标题栏
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		

		//按钮数字1
		Button button1 = (Button)findViewById(R.id.number1);
		button1.setOnClickListener(listener);
		//按钮数字2
		Button button2 = (Button)findViewById(R.id.number2);
		button2.setOnClickListener(listener);
		//按钮数字3
		Button button3 = (Button)findViewById(R.id.number3);
		button3.setOnClickListener(listener);
		//按钮数字4
		Button button4 = (Button)findViewById(R.id.number4);
		button4.setOnClickListener(listener);
		//按钮数字5
		Button button5 = (Button)findViewById(R.id.number5);
		button5.setOnClickListener(listener);
		//按钮数字6
		Button button6 = (Button)findViewById(R.id.number6);
		button6.setOnClickListener(listener);
		//按钮数字7
		Button button7 = (Button)findViewById(R.id.number7);
		button7.setOnClickListener(listener);
		//按钮数字8
		Button button8 = (Button)findViewById(R.id.number8);
		button8.setOnClickListener(listener);
		//按钮数字9
		Button button9 = (Button)findViewById(R.id.number9);
		button9.setOnClickListener(listener);
		//按钮数字0
		Button button0 = (Button)findViewById(R.id.number0);
		button0.setOnClickListener(listener);
		//按钮“+”
		Button buttonplus = (Button)findViewById(R.id.plus);
		buttonplus.setOnClickListener(listener);
		//按钮“-”
		Button buttonminus = (Button)findViewById(R.id.minus);
		buttonminus.setOnClickListener(listener);
		//按钮“*”
		Button buttontimes = (Button)findViewById(R.id.times);
		buttontimes.setOnClickListener(listener);
		//按钮“/”
		Button buttondivided = (Button)findViewById(R.id.divided);
		buttondivided.setOnClickListener(listener);
		//按钮"."
		Button buttondecimal = (Button)findViewById(R.id.decimal);
		buttondecimal.setOnClickListener(listener);
		//按钮"="
		Button buttonis = (Button)findViewById(R.id.is);
		buttonis.setOnClickListener(listener);
		//按钮"AC"
		Button buttonclean = (Button)findViewById(R.id.clean);
		buttonclean.setOnClickListener(listener);
		//按钮"Back"
		Button buttonback = (Button)findViewById(R.id.back);
		buttonback.setOnClickListener(listener);
	}
		//实例化监听对象listener
	OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
				
		TextView text = (TextView)findViewById(R.id.textview);//实例化文本框对象
		String t = text.getText().toString();//获取文本框的字符串，t即text
		Button b = (Button) v;//实例化按钮对象,b即button
		

	
	
		//输入数字（数字0-9，小数点）
		if(b.getId()==R.id.number1 || b.getId()==R.id.number2 || b.getId()==R.id.number3 || b.getId()==R.id.number4 || b.getId()==R.id.number5 ||
		   b.getId()==R.id.number6 || b.getId()==R.id.number7 || b.getId()==R.id.number8 || b.getId()==R.id.number9 || b.getId()==R.id.number0 ||
		   b.getId()==R.id.decimal){//分两种情况，数字或者小数点
			
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
		}
		
		
		
		
		//输入退格符号
		if(b.getId()==R.id.back){
			//先判断文本框文本是否为空
			if(t.equals("")||t==null){
				text.setText("");
			}
			else{
				t=t.substring(0,t.length()-1);//退格自减字符
				
				//当退格之后字符串长度是否为零
				if(t.length()==0){
					
				text.setText("");
					
				}
				else//否则直接打印出字符串
					text.setText(t);				
			}
				
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
					
					/**if(option==1){//加
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
						
					}*/
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
					
					
					/**String s = null;
					if(b.getId()==R.id.plus)
						s="+";
								
					if(b.getId()==R.id.minus)
						s="-";
								
					if(b.getId()==R.id.times)
						s="x";
								
					if(b.getId()==R.id.divided)
						s="÷";
					
					text.setText(s);
					*/
					
					
					text.setText("");
					state = 1;
					
					
					
				}
			}	
			
			//当option为零时，将当前文本框中字符串赋值给data1
			else{				
				try{//当t==null时，Double.valueOf(t)会抛出NumberFormatException
					data1 = Double.valueOf(t);
					/**String s = null;
					if(b.getId()==R.id.plus)
						s="+";
								
					if(b.getId()==R.id.minus)
						s="-";
								
					if(b.getId()==R.id.times)
						s="x";
								
					if(b.getId()==R.id.divided)
						s="÷";
					
					text.setText(s);
					*/
					
					
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
	
		}
		//输入清零符号：将所有全局变量重置为0，文本框归零
		if(b.getId()==R.id.clean){
			sum = 0;
			data1 = 0;
			data2 = 0;
			option = 0;
			point = 0;
			state = 0;
			
			text.setText("0");//文本框归零
		}
	}};

}
